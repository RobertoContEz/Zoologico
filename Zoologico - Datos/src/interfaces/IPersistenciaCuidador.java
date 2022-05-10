package interfaces;

import com.mongodb.client.MongoCollection;
import java.util.List;
import objetos.Cuidador;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * TODO: Documentar interfaz
 */
public interface IPersistenciaCuidador {

    MongoCollection<Cuidador> getCollection();

    public boolean agregar(Cuidador cuidador);

    public boolean actualizar(Cuidador cuidador);

    public boolean eliminar(ObjectId id);

    public Cuidador consultar(ObjectId id);

    public List<Cuidador> consultarTodos();
}
