package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Recorrido;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 */
public interface IPersistenciaRecorrido {
    
    MongoCollection<Recorrido> getCollection();

    public boolean agregar(Recorrido recorrido);

    public boolean actualizar(Recorrido recorrido);

    public boolean eliminar(ObjectId id);

    public Recorrido consultar(ObjectId id);

    public List<Recorrido> consultarTodos();
    
}
