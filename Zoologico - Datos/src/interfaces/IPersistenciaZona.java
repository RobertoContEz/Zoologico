package interfaces;

import java.util.List;
import objetos.Zona;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaZona {
    public boolean agregar(Zona zona);
    public boolean actualizar(Zona zona);
    public boolean eliminar(ObjectId id);
    public Zona consultar(ObjectId id);
    public List<Zona> consultarTodos();
}
