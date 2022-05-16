package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaQueja;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Queja;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a las Quejas con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse
 */
public class QuejasDAO implements IPersistenciaQueja {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public QuejasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Queja> getCollection() {
        return this.baseDatos.getCollection("Quejas", Queja.class);
    }

    /**
     * Agrega una queja a la base de datos.
     *
     * @param queja queja a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Queja queja) {
        try {
            MongoCollection<Queja> coleccion = this.getCollection();
            coleccion.insertOne(queja);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información de una queja en la base de datos.
     *
     * @param queja queja a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Queja queja) {
        try {
            if (queja.getId() == null) {
                System.out.println("ID del Queja invalida");
            } else {
                MongoCollection<Queja> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", queja.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("fecha", queja.getFecha())
                        .append("hora", queja.getHora())
                        .append("queja", queja.getQueja())
                        .append("correo", queja.getCorreo())
                        .append("telefono", queja.getTelefono())
                        .append("idItinerario", queja.getIdItinerario())
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
     * Elimina la información de una queja dentro de la base.
     *
     * @param id queja a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente la queja, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Queja> coleccion = this.getCollection();
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
     * Busca una queja en específico dentro de la base.
     *
     * @param id queja a buscar dentro de la base.
     * @return regresa una queja en caso de encontrarlo, null en caso contrario.
     */
    @Override
    public Queja consultar(ObjectId id) {
        try {
            List<Queja> listaQuejas = new ArrayList<>();
            MongoCollection<Queja> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaQuejas);
            if (listaQuejas.isEmpty()) {
                return null;
            } else {
                return listaQuejas.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Consulta la lista de todas las quejas registradas en la base.
     *
     * @return lista con todas las quejas registradas.
     */
    @Override
    public List<Queja> consultarTodos() {
        try {
            List<Queja> listaQuejas = new ArrayList<>();
            MongoCollection<Queja> collection = this.getCollection();
            collection.find().into(listaQuejas);
            return listaQuejas;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
