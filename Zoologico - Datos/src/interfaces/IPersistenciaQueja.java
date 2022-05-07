package interfaces;

import java.util.List;
import objetos.Queja;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaQueja {
    public boolean agregar(Queja queja);
    public boolean actualizar(Queja queja);
    public boolean eliminar(ObjectId id);
    public Queja consultar(ObjectId id);
    public List<Queja> consultarTodos();
}
