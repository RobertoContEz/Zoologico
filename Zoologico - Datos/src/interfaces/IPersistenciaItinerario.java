package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Itinerario;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaItinerario {

    MongoCollection<Itinerario> getCollection();

    public boolean agregar(Itinerario itinerario);

    public boolean actualizar(Itinerario itinerario);

    public boolean eliminar(ObjectId id);

    public Itinerario consultar(ObjectId id);

    public List<Itinerario> consultarTodos();
}
