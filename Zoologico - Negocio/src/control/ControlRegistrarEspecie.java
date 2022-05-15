package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaCuidador;
import interfaces.IPersistenciaEspecie;
import interfaces.IPersistenciaHabitat;
import java.util.List;
import objetos.Cuidador;
import objetos.Especie;
import objetos.Habitat;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 * Esta clase hace la conexión entre las guis y persistencias, recupera y
 * verifica en la base de datos los Cuidadores, Habitats, Especies
 */
public class ControlRegistrarEspecie {
    
    /**
     * Recupera un lista con las hábitats registradas en la base de datos.
     * @return lista con todas las hábitats registradas.
     */
    public List<Habitat> recuperaHabitats() {
        IPersistenciaHabitat dao = FabricaDAOs.getHabitatsDAO();
        
        return dao.consultarTodos();
    }
    
    /**
     * Recupera un lista con los cuidadores registrados en la base de datos.
     * @return lista con todos los cuidadores registrados.
     */
    public List<Cuidador> recuperaCuidadores() {
        IPersistenciaCuidador dao = FabricaDAOs.getCuidadoresDAO();
        
        return dao.consultarTodos();
    }
    
    /**
     * Verifica la existencia del nombre en español de una especie.
     * @param nombre parámetro a buscar en la base de datos.
     * @return retorna la información de la especie en caso de estar registrada, null en caso contrario.
     */
    public Especie buscarEspecie(String nombre) {
        IPersistenciaEspecie dao = FabricaDAOs.getEspeciesDAO();
        
        List<Especie> lista = dao.consultarTodos();
        
        for (Especie especie : lista) {
            if(especie.getNombreEspanol().equals(nombre)) return especie;
        }
        
        return null;
    }
    
    /**
     * Guarda un objeto de tipo especie en la base de datos.
     * @param especie objeto a guardar en la base de datos.
     * @return 
     */
    public boolean guardar(Especie especie) {
        IPersistenciaEspecie dao = FabricaDAOs.getEspeciesDAO();
        
        return dao.agregar(especie);
    }
}
