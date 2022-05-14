package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaHabitat;
import java.util.ArrayList;
import java.util.List;
import objetos.Habitat;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Esta clase hace la
 * conexión entre las guis y persistencias, registra Habitats recuperando
 * climas, vegetaciones y continentes de la base de datos
 *
 */
public class ControlRegistrarHabitat {
    
     /**
     * Metodo que devuelve la lista de Climas
     *
     * @return lista de Climas
     */
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
    /**
     * Metodo que devuelve la lista de Vegetaciones
     *
     * @return lista de Vegetaciones
     */

    public List<String> recuperaListaVegetaciones() {
        List lista = new ArrayList();
        lista.add("Selvatica");
        lista.add("Arbóreo");
        lista.add("Hiervas bajas");
        lista.add("Arrecife");
        lista.add("Nula");
        
        return lista;
    }
     /**
     * Metodo que devuelve la lista de Continentes
     *
     * @return lista de Continentes
     */
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
     /**
     * Metodo que se encarga de verificar la existencia de Habitat en la base de
     * datos
     *
     * @param nombre parametro a verificar en la base de datos
     * @return Habitat encontrado, si no, regresa null
     */
    public Habitat verificarExistencia(String nombre) {
        IPersistenciaHabitat dao = FabricaDAOs.getHabitatsDAO();
        
        List<Habitat> lista = dao.consultarTodos();
        
        for (Habitat habitat : lista) {
            if(habitat.getNombre().equals(nombre)) return habitat;
        }
        
        return null;
    }
    /**
     * Metodo que guarda el Habitat en la base de datos
     *
     * @param habitat parametro a guardar en la base de datos
     * @return Habitat guardado en la base de datos
     */
    public boolean guardar(Habitat habitat) {
        IPersistenciaHabitat dao = FabricaDAOs.getHabitatsDAO();
        
        return dao.agregar(habitat);
    }
}
