package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Empleado;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaEmpleado {

    MongoCollection<Empleado> getCollection();

    public boolean agregar(Empleado empleado);

    public boolean actualizar(Empleado empleado);

    public boolean eliminar(ObjectId id);

    public Empleado consultar(ObjectId id);

    public List<Empleado> consultarTodos();
}
