package interfaces;

import objetos.Empleado;
import org.bson.types.ObjectId;

/**
 * TODO: Documentar interfaz
 */
public interface IPersistenciaEmpleado {
    public boolean agregar(Empleado empleado);
    public boolean actualizar(Empleado empleado);
    public boolean eliminar(ObjectId id);
    public Empleado consultar(ObjectId id);
    public Empleado consultarTodos();
}
