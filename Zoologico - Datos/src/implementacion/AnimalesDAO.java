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

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class AnimalesDAO implements IPersistenciaAnimal {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public AnimalesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Animal> getCollection() {
        return this.baseDatos.getCollection("Animales", Animal.class);
    }

    @Override
    public boolean agregar(Animal animal) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Animal> coleccion = this.getCollection();
        coleccion.insertOne(animal);
        return true;
    }

    @Override
    public boolean actualizar(Animal animal) {
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
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Animal consultar(ObjectId id) {
        List<Animal> listaAnimales = new ArrayList<>();
        MongoCollection<Animal> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaAnimales);
        if (listaAnimales.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaAnimales.get(0);
        }
    }

    @Override
    public List<Animal> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Animal> listaAnimales = new ArrayList<>();
        MongoCollection<Animal> collection = this.getCollection();
        collection.find().into(listaAnimales);
        return listaAnimales;
    }

}
