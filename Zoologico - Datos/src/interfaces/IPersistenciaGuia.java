package interfaces;

import objetos.Guia;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaGuia {
    public boolean agregar(Guia guia);
    public boolean actualizar(Guia guia);
    public boolean eliminar(ObjectId id);
    public Guia consultar(ObjectId id);
    public Guia consultarTodos();
}
