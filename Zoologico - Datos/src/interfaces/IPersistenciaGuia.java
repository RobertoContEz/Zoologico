package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Guias con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse mediante metodos abstractos
 * en la interfaz
 */
public interface IPersistenciaGuia {

    MongoCollection<Guia> getCollection();

    public boolean agregar(Guia guia);

    public boolean actualizar(Guia guia);

    public boolean eliminar(ObjectId id);

    public Guia consultar(ObjectId id);

    public List<Guia> consultarTodos();
}
