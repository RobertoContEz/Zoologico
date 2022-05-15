package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaHabitat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Habitat;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class HabitatsDAO implements IPersistenciaHabitat {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public HabitatsDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Habitat> getCollection() {
        return this.baseDatos.getCollection("Habitats", Habitat.class);
    }

    /**
     * Agrega un hábitat a la base de datos.
     *
     * @param habitat hábitat a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Habitat habitat) {
        try {
            MongoCollection<Habitat> coleccion = this.getCollection();
            coleccion.insertOne(habitat);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza la información de un hábitat en la base de datos.
     *
     * @param habitat hábitat a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Habitat habitat) {
        try {
            if (habitat.getId() == null) {
                System.out.println("ID del Habitat invalida");
            } else {
                MongoCollection<Habitat> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", habitat.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("nombre", habitat.getNombre())
                        .append("tipoClima", habitat.getTipoClima())
                        .append("tipoVegetacion", habitat.getTipoVegetacion())
                        .append("continentesDondeSeEncuentra", habitat.getContinentesDondeSeEncuentra())
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
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina la información de un hábitat dentro de la base.
     *
     * @param id hábitat a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente el hábitat, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Habitat> coleccion = this.getCollection();
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
     * Busca un hábitat en específico dentro de la base.
     *
     * @param id hábitat a buscar dentro de la base.
     * @return regresa un hábitat en caso de encontrarlo, null en caso
     * contrario.
     */
    @Override
    public Habitat consultar(ObjectId id) {
        try {
            List<Habitat> listaHabitats = new ArrayList<>();
            MongoCollection<Habitat> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaHabitats);
            if (listaHabitats.isEmpty()) {
                return null;
            } else {
                return listaHabitats.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta la lista de todos los hábitats registrados en la base.
     *
     * @return lista con todos los hábitat registrados.
     */
    @Override
    public List<Habitat> consultarTodos() {
        try {
            List<Habitat> listaHabitatas = new ArrayList<>();
            MongoCollection<Habitat> collection = this.getCollection();
            collection.find().into(listaHabitatas);
            return listaHabitatas;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
