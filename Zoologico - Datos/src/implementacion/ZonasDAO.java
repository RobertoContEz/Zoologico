package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaZona;
import java.util.ArrayList;
import java.util.List;
import objetos.Zona;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class ZonasDAO implements IPersistenciaZona {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public ZonasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Zona> getCollection() {
        return this.baseDatos.getCollection("Zonas", Zona.class);
    }

    @Override
    public boolean agregar(Zona zona) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Zona> coleccion = this.getCollection();
        coleccion.insertOne(zona);
        return true;
    }

    @Override
    public boolean actualizar(Zona zona) {
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
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Zona consultar(ObjectId id) {
        List<Zona> listaZona = new ArrayList<>();
        MongoCollection<Zona> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaZona);
        if (listaZona.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaZona.get(0);
        }
    }

    @Override
    public List<Zona> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Zona> listaZona = new ArrayList<>();
        MongoCollection<Zona> collection = this.getCollection();
        collection.find().into(listaZona);
        return listaZona;
    }

}
