package implementacion;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaRecorrido;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Recorrido;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 */
public class RecorridoDAO implements IPersistenciaRecorrido {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public RecorridoDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Recorrido> getCollection() {
        return this.baseDatos.getCollection("Recorridos", Recorrido.class);
    }

    @Override
    public boolean agregar(Recorrido recorrido) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        try {
            MongoCollection<Recorrido> coleccion = this.getCollection();
            coleccion.insertOne(recorrido);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean actualizar(Recorrido recorrido) {
        try {
            if (recorrido.getId() == null) {
                System.out.println("ID del Recorrido invalida");
            } else {
                MongoCollection<Recorrido> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", recorrido.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("idItinerario", recorrido.getIdItinerario())
                        .append("idGuia", recorrido.getIdGuia())
                        .append("fechHora", recorrido.getFechaHora())
                        .append("numVistitantes", recorrido.getNumVistitantes())
                        .append("quejas", recorrido.getQuejas())
                );

                UpdateResult resultado = coleccion.updateOne(filtro, entidadActualizada);

                if (resultado.getModifiedCount() == 0) {
                    System.out.println("No se ha actualizado");
                } else {
                    System.out.println("Se ha actualizado");
                }
            }
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Recorrido> coleccion = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            coleccion.deleteOne(filtro);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    @Override
    public Recorrido consultar(ObjectId id) {
        List<Recorrido> listaRecorrido = new ArrayList<>();
        MongoCollection<Recorrido> collection = this.getCollection();
        Document filtro = new Document();
        try {
            filtro.append("_id", id);
            collection.find(filtro).into(listaRecorrido);
            if (listaRecorrido.isEmpty()) {
                return null;
            } else {
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return listaRecorrido.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return listaRecorrido.get(0);
        }
    }

    @Override
    public List<Recorrido> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Recorrido> listaRecorrido = new ArrayList<>();
        MongoCollection<Recorrido> collection = this.getCollection();
        try {
            collection.find().into(listaRecorrido);
            return listaRecorrido;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Recorrido> consultarRecorridosUltimoMes() {
        List<Recorrido> listaRecorrido = new ArrayList<>();
        MongoCollection<Recorrido> collection = this.getCollection();
        try {
            Document filtro = new Document();
            LocalDateTime ultimoMes = LocalDateTime.now().minusDays(30);
            //DBObject query = new BasicDBObject("fechHora", new BasicDBObject("$gt", ultimoMes));
            filtro.append("fechHora", new BasicDBObject("$gt", ultimoMes));                      
            collection.find(filtro).into(listaRecorrido);
            if (listaRecorrido.isEmpty()) {
                return null;
            } else {
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return (List<Recorrido>) listaRecorrido.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
