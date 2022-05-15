package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Queja;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a las Quejas con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaQueja {

    MongoCollection<Queja> getCollection();

    public boolean agregar(Queja queja);

    public boolean actualizar(Queja queja);

    public boolean eliminar(ObjectId id);

    public Queja consultar(ObjectId id);

    public List<Queja> consultarTodos();
}
