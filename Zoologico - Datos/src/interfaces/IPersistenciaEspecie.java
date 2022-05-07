package interfaces;

import objetos.Especie;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaEspecie {
    public boolean agregar(Especie especie);
    public boolean actualizar(Especie especie);
    public boolean eliminar(ObjectId id);
    public Especie consultar(ObjectId id);
    public Especie consultarTodos();
}
