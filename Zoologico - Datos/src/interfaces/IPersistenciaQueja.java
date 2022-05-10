package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Queja;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaQueja {

    MongoCollection<Queja> getCollection();

    public boolean agregar(Queja queja);

    public boolean actualizar(Queja queja);

    public boolean eliminar(ObjectId id);

    public Queja consultar(ObjectId id);

    public List<Queja> consultarTodos();
}
