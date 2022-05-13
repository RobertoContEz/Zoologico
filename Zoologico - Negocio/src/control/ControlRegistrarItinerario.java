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
 * TODO: Documentar clase
 */
public class ControlRegistrarItinerario {

    public List<Zona> recuperaZonasZoologico() {
        IPersistenciaZona dao = FabricaDAOs.getZonaDAO();
        
        return dao.consultarTodos();
    }

    public List<Guia> recuperaGuiasRegistrados() {
        IPersistenciaGuia dao = FabricaDAOs.getGuiasDAO();
        return dao.consultarTodos();
    }
    
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
