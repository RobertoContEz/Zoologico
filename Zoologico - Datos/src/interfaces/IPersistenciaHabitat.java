package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Habitat;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaHabitat {
    
    MongoCollection<Habitat> getCollection();

    public boolean agregar(Habitat habitat);

    public boolean actualizar(Habitat habitat);

    public boolean eliminar(ObjectId id);

    public Habitat consultar(ObjectId id);

    public List<Habitat> consultarTodos();
}
