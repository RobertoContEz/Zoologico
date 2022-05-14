package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaGuia;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaQueja;
import interfaces.IPersistenciaZona;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
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
            if(itinerario.getNombre().equals(nombre)) return itinerario;
        }
        
        return null;
    }
    
    public int calcularEspeciesVisitadas(List<ObjectId> ids) {
        int especies = 0;
        IPersistenciaZona dao = FabricaDAOs.getZonaDAO();
        List<Zona> zonas = dao.consultarTodos();
        for (Zona zona : zonas) {
            List<ObjectId> e = zona.getEspeciesQueTiene();
            if(e!=null)
                especies += e.size();
        }
        return especies;
    }
    
    public boolean guardar(Itinerario itinerario) {
        IPersistenciaItinerario dao = FabricaDAOs.getItinerariosDAO();
        
        return dao.agregar(itinerario);
    }
    
    public boolean actualizarGuia(ObjectId idItinerario, ObjectId idGuia) {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();
        Guia guia = dao.consultar(idGuia);
        guia.agregaItinerario(idItinerario);
        return dao.actualizar(guia);
    }
}
