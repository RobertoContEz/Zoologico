package interfaces;

import objetos.Habitat;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaHabitat {
    public boolean agregar(Habitat habitat);
    public boolean actualizar(Habitat habitat);
    public boolean eliminar(ObjectId id);
    public Habitat consultar(ObjectId id);
    public Habitat consultarTodos();
}
