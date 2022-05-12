package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaHabitat;
import java.util.ArrayList;
import java.util.List;
import objetos.Habitat;

/**
 * 
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * TODO: Documentar clase
 */
public class ControlRegistrarHabitat {
    
    public List<String> recuperaListaClimas() {
        List lista = new ArrayList();
        lista.add("Humedo");
        lista.add("Templado");
        lista.add("Soleado");
        lista.add("Polar");
        lista.add("Seco");
        lista.add("Acuático");
        
        return lista;
    }
    
    public List<String> recuperaListaVegetaciones() {
        List lista = new ArrayList();
        lista.add("Selvatica");
        lista.add("Arbóreo");
        lista.add("Hiervas bajas");
        lista.add("Arrecife");
        lista.add("Nula");
        
        return lista;
    }
    
    public List<String> recuperaListaContinentes() {
        List lista = new ArrayList();
        lista.add("America");
        lista.add("Europa");
        lista.add("África");
        lista.add("Oceanía");
        lista.add("Asia");
        lista.add("Antartica");
        lista.add("Mar profundo");
        
        return lista;
    }
    
    public Habitat verificarExistencia(String nombre) {
        IPersistenciaHabitat dao = FabricaDAOs.getHabitatsDAO();
        
        List<Habitat> lista = dao.consultarTodos();
        
        for (Habitat habitat : lista) {
            if(habitat.getNombre().equals(nombre)) return habitat;
        }
        
        return null;
    }
    
    public boolean guardar(Habitat habitat) {
        IPersistenciaHabitat dao = FabricaDAOs.getHabitatsDAO();
        
        return dao.agregar(habitat);
    }
}
