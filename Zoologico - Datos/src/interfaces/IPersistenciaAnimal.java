package interfaces;

import objetos.Animal;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaAnimal {
    public boolean agregar(Animal animal);
    public boolean actualizar(Animal animal);
    public boolean eliminar(ObjectId id);
    public Animal consultar(ObjectId id);
    public Animal consultarTodos();
}
