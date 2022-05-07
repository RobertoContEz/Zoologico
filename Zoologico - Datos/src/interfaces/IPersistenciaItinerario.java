package interfaces;

import java.util.List;
import objetos.Itinerario;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaItinerario {
    public boolean agregar(Itinerario itinerario);
    public boolean actualizar(Itinerario itinerario);
    public boolean eliminar(ObjectId id);
    public Itinerario consultar(ObjectId id);
    public List<Itinerario> consultarTodos();
}
