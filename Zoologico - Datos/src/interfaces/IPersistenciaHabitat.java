package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Habitat;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Habitats con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaHabitat {

    MongoCollection<Habitat> getCollection();

    public boolean agregar(Habitat habitat);

    public boolean actualizar(Habitat habitat);

    public boolean eliminar(ObjectId id);

    public Habitat consultar(ObjectId id);

    public List<Habitat> consultarTodos();
}
