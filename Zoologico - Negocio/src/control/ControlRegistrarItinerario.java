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
        
        if (buscarItinerario(nombre) == null) {
//            JOptionPane.INFORMATION_MESSAGE();
              
        }
        
        return null;
    }
    
}
