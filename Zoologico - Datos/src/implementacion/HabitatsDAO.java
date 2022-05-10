package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaHabitat;
import java.util.ArrayList;
import java.util.List;
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

    public HabitatsDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Habitat> getCollection() {
        return this.baseDatos.getCollection("Habitats", Habitat.class);
    }

    @Override
    public boolean agregar(Habitat habitat) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Habitat> coleccion = this.getCollection();
        coleccion.insertOne(habitat);
        return true;
    }

    @Override
    public boolean actualizar(Habitat habitat) {
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
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Habitat consultar(ObjectId id) {
        List<Habitat> listaHabitats = new ArrayList<>();
        MongoCollection<Habitat> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaHabitats);
        if (listaHabitats.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaHabitats.get(0);
        }
    }

    @Override
    public List<Habitat> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Habitat> listaHabitatas = new ArrayList<>();
        MongoCollection<Habitat> collection = this.getCollection();
        collection.find().into(listaHabitatas);
        return listaHabitatas;
    }

}
