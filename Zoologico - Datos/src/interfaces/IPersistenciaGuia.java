package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Guia;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaGuia {

    MongoCollection<Guia> getCollection();

    public boolean agregar(Guia guia);

    public boolean actualizar(Guia guia);

    public boolean eliminar(ObjectId id);

    public Guia consultar(ObjectId id);

    public List<Guia> consultarTodos();
}
