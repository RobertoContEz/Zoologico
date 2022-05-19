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
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Recorridos con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse
 *
 */
public class RecorridoDAO implements IPersistenciaRecorrido {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public RecorridoDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Recorrido> getCollection() {
        return this.baseDatos.getCollection("Recorridos", Recorrido.class);
    }

    /**
     * Agrega un recorrido a la base de datos.
     *
     * @param recorrido recorrido a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Recorrido recorrido) {
        try {
            MongoCollection<Recorrido> coleccion = this.getCollection();
            coleccion.insertOne(recorrido);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información de un recorrido en la base de datos.
     *
     * @param recorrido recorrido a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
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
                        .append("fechaHora", recorrido.getFechaHora())
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
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Elimina la información de un recorrido dentro de la base.
     *
     * @param id recorrido a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente el recorrido, false en caso
     * contrario.
     */
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

    /**
     * Busca un recorrido en específico dentro de la base.
     *
     * @param id recorrido a buscar dentro de la base.
     * @return regresa un recorrido en caso de encontrarlo, null en caso
     * contrario.
     */
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
                return listaRecorrido.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return listaRecorrido.get(0);
        }
    }

    /**
     * Consulta la lista de todos los recorridos registrados en la base.
     *
     * @return lista con todos los recorridos registrados.
     */
    @Override
    public List<Recorrido> consultarTodos() {
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

    /**
     * Consulta la lista de todos los recorridos registrados en la base en el
     * último mes.
     *
     * @return lista con todos los recorridos registrados en el último mes.
     */
    @Override
    public List<Recorrido> consultarRecorridosUltimoMes() {
        List<Recorrido> listaRecorrido = new ArrayList<>();
        MongoCollection<Recorrido> collection = this.getCollection();
        try {
            Document filtro = new Document();
            LocalDateTime ultimoMes = LocalDateTime.now().minusDays(30);
            filtro.append("fechaHora", new Document("$gt", ultimoMes));
            collection.find(filtro).into(listaRecorrido);
            return listaRecorrido;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
