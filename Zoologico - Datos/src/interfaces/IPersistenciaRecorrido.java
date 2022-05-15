package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Recorrido;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Recorridos con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaRecorrido {

    MongoCollection<Recorrido> getCollection();

    public boolean agregar(Recorrido recorrido);

    public boolean actualizar(Recorrido recorrido);

    public boolean eliminar(ObjectId id);

    public Recorrido consultar(ObjectId id);

    public List<Recorrido> consultarTodos();

    public List<Recorrido> consultarRecorridosUltimoMes();

}
