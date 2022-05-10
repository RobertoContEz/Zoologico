package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaQueja;
import java.util.ArrayList;
import java.util.List;
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
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Queja> getCollection() {
        return this.baseDatos.getCollection("Quejas", Queja.class);
    }

    @Override
    public boolean agregar(Queja queja) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Queja> coleccion = this.getCollection();
        coleccion.insertOne(queja);
        return true;
    }

    @Override
    public boolean actualizar(Queja queja) {
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
    }

    @Override
    public boolean eliminar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Queja consultar(ObjectId id) {
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
    }

    @Override
    public List<Queja> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Queja> listaQuejas = new ArrayList<>();
        MongoCollection<Queja> collection = this.getCollection();
        collection.find().into(listaQuejas);
        return listaQuejas;
    }

}
