package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaGuia;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaQueja;
import interfaces.IPersistenciaRecorrido;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;
import objetos.Queja;
import objetos.Recorrido;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 * Esta clase hace la conexión entre las guis y persistencias, recupera y
 * verifica en la base de datos los los Recorridos, Itinerarios de los
 * Recorridos, Guias de los Recorridos y ordena Recorridos
 */
public class ControlRegistrarQueja {

    /**
     * Metodo que recupera los Recorridos del ultimo mes
     *
     * @return recorridos del ultimo mes
     */
    public List<Recorrido> recuperarRecorridosUltimoMes() {
        IPersistenciaRecorrido daoRecorrido = FabricaDAOs.getRecorridosDAO();

        return daoRecorrido.consultarRecorridosUltimoMes();
    }

    /**
     * Metodo que recupera los Itinerarios de los Recorridos
     *
     * @param recorridos parametro a buscar en la base de datos
     * @return lista de Itineraios, null en caso contrario
     */
    public List<Itinerario> recuperarItinerariosDeLosRecorridos(List<Recorrido> recorridos) {
        IPersistenciaItinerario daoItinerario = FabricaDAOs.getItinerariosDAO();

        List<ObjectId> ids = new ArrayList();
        for (Recorrido recorrido : recorridos) {
            ids.add(recorrido.getIdItinerario());
        }
        ids = new ArrayList(new HashSet(ids));

        List<Itinerario> lista = new ArrayList();
        for (ObjectId id : ids) {
            lista.add(daoItinerario.consultar(id));
        }

        return lista.isEmpty() ? null : lista;
    }

    /**
     * Metodo que agrupa los Itinerarios y los de Recorridos respectios
     *
     * @param itinerarios parametro que se busca en la lista de Itinerarios en
     * la base de datos
     * @param recorridos parametro que se busca en la lista de Recorridos en la
     * base de datos
     * @return mapa de Itinerarios y Recorridos
     */
    public HashMap<Itinerario, List<Recorrido>> ordenarRecorridos(List<Itinerario> itinerarios, List<Recorrido> recorridos) {
        HashMap<Itinerario, List<Recorrido>> mapa = new HashMap();

        for (Itinerario itinerario : itinerarios) {
            List<Recorrido> r = new ArrayList();
            for (Recorrido recorrido : recorridos) {
                if (recorrido.getIdItinerario().equals(itinerario.getId())) {
                    r.add(recorrido);
                }
            }
            mapa.put(itinerario, (r.isEmpty() ? null : r));
        }

        return mapa;
    }

    /**
     * Metodo que consulta el Guia respecto a su recorrido en la base de datos
     *
     * @param recorrido parametro que busca el recorrido en la base de datos
     * @return guia consultado de la base de datos
     */
    public Guia recuperarGuia(Recorrido recorrido) {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();

        return dao.consultar(recorrido.getIdGuia());
    }

    /**
     * Metodo que guarda Queja en la base de datos
     *
     * @param queja parametro a guardar en la base de datos
     * @param recorrido parametro de recorrido a actualizar con la queja
     * @return confirmación de la operación
     */
    public boolean guardar(Queja queja, Recorrido recorrido) {
        IPersistenciaQueja daoQ = FabricaDAOs.getQuejasDAO();
        IPersistenciaRecorrido daoR = FabricaDAOs.getRecorridosDAO();

        if(recorrido.getQuejas()!=null) {
            if(!recorrido.getQuejas().contains(queja)) {
                recorrido.getQuejas().add(queja);
            }
        } else {
            List<Queja> quejas = new ArrayList();
            quejas.add(queja);
            recorrido.setQuejas(quejas);
        }
                
        if(daoR.actualizar(daoR.consultar(recorrido.getId()))) {
            return daoQ.agregar(queja);
        } else {
            return false;
        }
    }
}
