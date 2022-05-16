package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaAnimal;
import java.util.ArrayList;
import java.util.List;
import objetos.Animal;
import org.bson.Document;
import org.bson.types.ObjectId;
import javax.persistence.PersistenceException;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Animales con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse
 */
public class AnimalesDAO implements IPersistenciaAnimal {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public AnimalesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Animal> getCollection() {
        return this.baseDatos.getCollection("Animales", Animal.class);
    }

    /**
     * Agrega un animal a la base de datos.
     *
     * @param animal animal a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Animal animal) {
        try {
            MongoCollection<Animal> coleccion = this.getCollection();
            coleccion.insertOne(animal);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Actualiza la información de un animal en la base de datos.
     *
     * @param animal animal a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Animal animal) {
        try {
            if (animal.getId() == null) {
                System.out.println("ID del Animal invalida");
            } else {
                MongoCollection<Animal> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", animal.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("nombre", animal.getNombre())
                        .append("sexo", animal.getSexo())
                        .append("edad", animal.getEdad())
                        .append("idEspecie", animal.getIdEspecie())
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
     * Elimina la información de un animal dentro de la base.
     *
     * @param id animal a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente al animal, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Animal> coleccion = this.getCollection();
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
     * Busca un animal en específico dentro de la base.
     *
     * @param id animal a buscar dentro de la base.
     * @return regresa un animal en caso de encontrarlo, null en caso contrario.
     */
    @Override
    public Animal consultar(ObjectId id) {
        List<Animal> listaAnimales = new ArrayList<>();
        MongoCollection<Animal> collection = this.getCollection();
        Document filtro = new Document();
        try {
            filtro.append("_id", id);
            collection.find(filtro).into(listaAnimales);
            if (listaAnimales.isEmpty()) {
                return null;
            } else {
                return listaAnimales.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return listaAnimales.get(0);
        }
    }

    /**
     * Consulta la lista de todos los animales registrados en la base.
     *
     * @return lista con todos los animales registrados.
     */
    @Override
    public List<Animal> consultarTodos() {
        try {
            List<Animal> listaAnimales = new ArrayList<>();
            MongoCollection<Animal> collection = this.getCollection();
            collection.find().into(listaAnimales);
            return listaAnimales;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
    }

}
