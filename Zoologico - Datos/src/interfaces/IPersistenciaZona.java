package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Zona;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaZona {

    MongoCollection<Zona> getCollection();

    public boolean agregar(Zona zona);

    public boolean actualizar(Zona zona);

    public boolean eliminar(ObjectId id);

    public Zona consultar(ObjectId id);

    public List<Zona> consultarTodos();
}
