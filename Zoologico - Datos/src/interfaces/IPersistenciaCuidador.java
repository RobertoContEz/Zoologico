package interfaces;

import objetos.Cuidador;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaCuidador {
    public boolean agregar(Cuidador cuidador);
    public boolean actualizar(Cuidador cuidador);
    public boolean eliminar(ObjectId id);
    public Cuidador consultar(ObjectId id);
    public Cuidador consultarTodos();
}
