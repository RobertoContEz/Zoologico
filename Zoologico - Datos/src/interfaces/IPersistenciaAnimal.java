package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Animal;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaAnimal {
    
    MongoCollection<Animal> getCollection();

    public boolean agregar(Animal animal);

    public boolean actualizar(Animal animal);

    public boolean eliminar(ObjectId id);

    public Animal consultar(ObjectId id);

    public List<Animal> consultarTodos();
}
