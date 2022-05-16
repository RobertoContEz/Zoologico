package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaZona;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Zona;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a las Zonas con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse
 */
public class ZonasDAO implements IPersistenciaZona {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public ZonasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Zona> getCollection() {
        return this.baseDatos.getCollection("Zonas", Zona.class);
    }

    /**
     * Agrega una zona a la base de datos.
     *
     * @param zona zona a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Zona zona) {
        try {
            MongoCollection<Zona> coleccion = this.getCollection();
            coleccion.insertOne(zona);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información de una zona en la base de datos.
     *
     * @param zona zona a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Zona zona) {
        try {
            if (zona.getId() == null) {
                System.out.println("ID de la Zona invalida");
            } else {
                MongoCollection<Zona> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", zona.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("ubicacionActual", zona.getUbicacionActual())
                        .append("nombre", zona.getNombre())
                        .append("extension", zona.getExtension())
                        .append("especiesQueTiene", zona.getEspeciesQueTiene())
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
     * Elimina la información de una zona dentro de la base.
     *
     * @param id zona a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente la zona, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Zona> coleccion = this.getCollection();
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
     * Busca una zona en específico dentro de la base.
     *
     * @param id zona a buscar dentro de la base.
     * @return regresa una zona en caso de encontrarla, null en caso contrario.
     */
    @Override
    public Zona consultar(ObjectId id) {
        try {
            List<Zona> listaZona = new ArrayList<>();
            MongoCollection<Zona> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaZona);
            if (listaZona.isEmpty()) {
                return null;
            } else {
                return listaZona.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Consulta la lista de todas las zonas registrados en la base.
     *
     * @return lista con todas las zonas registrados.
     */
    @Override
    public List<Zona> consultarTodos() {
        try {
            List<Zona> listaZona = new ArrayList<>();
            MongoCollection<Zona> collection = this.getCollection();
            collection.find().into(listaZona);
            return listaZona;
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
