package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaItinerario;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Itinerario;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class ItinerariosDAO implements IPersistenciaItinerario {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public ItinerariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Itinerario> getCollection() {
        return this.baseDatos.getCollection("Itinerarios", Itinerario.class);
    }

    /**
     * Agrega un itinerario a la base de datos.
     *
     * @param itinerario itinerario a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Itinerario itinerario) {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            MongoCollection<Itinerario> coleccion = this.getCollection();
            coleccion.insertOne(itinerario);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información de un itinerario en la base de datos.
     *
     * @param itinerario itinerario a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Itinerario itinerario) {
        try {
            if (itinerario.getId() == null) {
                System.out.println("ID del Itinerario invalida");
            } else {
                MongoCollection<Itinerario> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", itinerario.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("nombre", itinerario.getNombre())
                        .append("idsZonasVisitadas", itinerario.getIdsZonasVisitadas())
                        .append("duracionDelRecorrido", itinerario.getDuracionDelRecorrido())
                        //                    .append("diasDelRecorrido", itinerario.get())
                        //                    .append("horasALasQueInicia", itinerario.getHorasALasQueInicia())
                        .append("longitud", itinerario.getLongitud())
                        .append("numeroMaximoVisitantes", itinerario.getNumeroMaximoVisitantes())
                        .append("numeroEspeciesVisitadas", itinerario.getNumeroEspeciesVisitadas())
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

    /**
     * Elimina la información de un itinerario dentro de la base.
     *
     * @param id itinerario a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente el itinerario, false en
     * caso contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Itinerario> coleccion = this.getCollection();
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
     * Busca un itinerario en específico dentro de la base.
     *
     * @param id itinerario a buscar dentro de la base.
     * @return regresa un itinerario en caso de encontrarlo, null en caso
     * contrario.
     */
    @Override
    public Itinerario consultar(ObjectId id) {
        try {
            List<Itinerario> listaItinerarios = new ArrayList<>();
            MongoCollection<Itinerario> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaItinerarios);
            if (listaItinerarios.isEmpty()) {
                return null;
            } else {
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return listaItinerarios.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    /**
     * Consulta la lista de todos los itinerarios registrados en la base.
     *
     * @return lista con todos los itinerarios registrados.
     */
    @Override
    public List<Itinerario> consultarTodos() {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            List<Itinerario> listaItinerarios = new ArrayList<>();
            MongoCollection<Itinerario> collection = this.getCollection();
            collection.find().into(listaItinerarios);
            return listaItinerarios;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

}
