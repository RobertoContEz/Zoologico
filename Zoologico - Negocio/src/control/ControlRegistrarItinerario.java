package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaGuia;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaZona;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;
import objetos.Zona;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 * Esta clase hace la conexión entre las guis y persistencias, recupera y
 * verifica en la base de datos los Itinerarios y Guias de la base de datos
 *
 */
public class ControlRegistrarItinerario {

    /**
     * Metodo que devuelve las zonas recuperadas del Zoologico en la base de
     * datos
     *
     * @return zonas del Zoologico en la base de datos
     */
    public List<Zona> recuperaZonasZoologico() {
        IPersistenciaZona dao = FabricaDAOs.getZonaDAO();

        return dao.consultarTodos();
    }

    /**
     * Metodo que devuelve los guias recuperados del Zoologico en la base de
     * datos
     *
     * @return guias registrados del Zoologico en la base de datos
     */
    public List<Guia> recuperaGuiasRegistrados() {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();
        return dao.consultarTodos();
    }

    /**
     * Metodo que busca el itinerario en la base de datos
     *
     * @param nombre parametro a guarda en la base de datos
     * @return itinerario de la base de datos, si no, regresa null
     */
    public Itinerario buscarItinerario(String nombre) {
        IPersistenciaItinerario dao = FabricaDAOs.getItinerariosDAO();

        List<Itinerario> lista = dao.consultarTodos();

        for (Itinerario itinerario : lista) {
            if (itinerario.getNombre().equals(nombre)) {
                return itinerario;
            }
        }

        return null;
    }

    /**
     * Metodo que calcula las especies visitadas de la lista de los id de la
     * base de datos
     *
     * @param ids parametro que calcula en la base de datos
     * @return numero de especies visitadas
     */
    public int calcularEspeciesVisitadas(List<ObjectId> ids) {
        int especies = 0;
        IPersistenciaZona dao = FabricaDAOs.getZonaDAO();
        List<Zona> zonas = dao.consultarTodos();
        for (Zona zona : zonas) {
            List<ObjectId> e = zona.getEspeciesQueTiene();
            if (e != null) {
                especies += e.size();
            }
        }
        return especies;
    }

    /**
     * Metodo que guarda un itinerario nuevo en la base de datos
     *
     * @param itinerario objeto a guardar en la base de datos
     * @return
     */
    public boolean guardar(Itinerario itinerario) {
        IPersistenciaItinerario dao = FabricaDAOs.getItinerariosDAO();

        return dao.agregar(itinerario);
    }

    /**
     * Metodo que actualiza el Guia en el Itinerario respecto a su id en la base
     * de datos
     *
     * @param idItinerario parametro que toma en cuenta para actualizar en la
     * base de datos
     * @param idGuia parametro a actualizar en la base de datos
     * @return guia actualizado
     */
    public boolean actualizarGuia(ObjectId idItinerario, ObjectId idGuia) {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();
        Guia guia = dao.consultar(idGuia);
        guia.agregaItinerario(idItinerario);
        return dao.actualizar(guia);
    }
}
