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
 * TODO: Documentar clase
 */
public class ControlRegistrarQueja {

    public List<Recorrido> recuperarRecorridosUltimoMes() {
        IPersistenciaRecorrido daoRecorrido = FabricaDAOs.getRecorridosDAO();
        
        return daoRecorrido.consultarRecorridosUltimoMes();
    }
    
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
        
        return lista.isEmpty()? null : lista;
    } 

    public HashMap<Itinerario,List<Recorrido>> ordenarRecorridos(List<Itinerario> itinerarios, List<Recorrido> recorridos) {
        HashMap<Itinerario,List<Recorrido>> mapa = new HashMap();
        
        for (Itinerario itinerario : itinerarios) {
            List<Recorrido> r = new ArrayList();
            for (Recorrido recorrido : recorridos) {
                if (recorrido.getIdItinerario().equals(itinerario.getId()))
                    r.add(recorrido);
            }
            mapa.put(itinerario, (r.isEmpty()?null:r));
        }
        
        return mapa;
    }
    
    public Guia recuperarGuia(Recorrido recorrido) {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();
        
        return dao.consultar(recorrido.getIdGuia());
    }
    
    public boolean guardar(Queja queja) {
        IPersistenciaQueja dao = FabricaDAOs.getQuejasDAO();
        
        return dao.agregar(queja);
    }
}
