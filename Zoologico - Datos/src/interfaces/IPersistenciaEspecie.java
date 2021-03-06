package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Especie;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a las Especies con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaEspecie {

    MongoCollection<Especie> getCollection();

    public boolean agregar(Especie especie);

    public boolean actualizar(Especie especie);

    public boolean eliminar(ObjectId id);

    public Especie consultar(ObjectId id);

    public List<Especie> consultarTodos();
}
