package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Empleado;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Empleados con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaEmpleado {

    MongoCollection<Empleado> getCollection();

    public boolean agregar(Empleado empleado);

    public boolean actualizar(Empleado empleado);

    public boolean eliminar(ObjectId id);

    public Empleado consultar(ObjectId id);

    public List<Empleado> consultarTodos();
}
