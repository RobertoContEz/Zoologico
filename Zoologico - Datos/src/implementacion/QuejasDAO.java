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
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class QuejasDAO implements IPersistenciaQueja {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public QuejasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Queja> getCollection() {
        return this.baseDatos.getCollection("Quejas", Queja.class);
    }

    @Override
    public boolean agregar(Queja queja) {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            MongoCollection<Queja> coleccion = this.getCollection();
            coleccion.insertOne(queja);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

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
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return listaQuejas.get(0);
            }
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return null;
        }
    }

    @Override
    public List<Queja> consultarTodos() {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
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
