package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaGuia;
import java.util.ArrayList;
import java.util.List;
import objetos.Guia;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class GuiasDAO implements IPersistenciaGuia{

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public GuiasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Guia> getCollection() {
        return this.baseDatos.getCollection("Guias", Guia.class);
    }

    @Override
    public boolean agregar(Guia guia) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Guia> coleccion = this.getCollection();
        coleccion.insertOne(guia);
        return true;
    }

    @Override
    public boolean actualizar(Guia guia) {
        if (guia.getId() == null) {
            System.out.println("ID del Guia invalida");
        } else {
            MongoCollection<Guia> coleccion = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", guia.getId());

            Document entidadActualizada = new Document();
            entidadActualizada.append("$set", new Document("nombre", guia.getNombre())
                    .append("direccion", guia.getDireccion())
                    .append("telefono", guia.getTelefono())
                    .append("fechaIngreso", guia.getFechaIngreso())
                    .append("itinerarioActual", guia.getItinerarioActual())
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
    public Guia consultar(ObjectId id) {
        List<Guia> listaGuias = new ArrayList<>();
        MongoCollection<Guia> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaGuias);
        if (listaGuias.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaGuias.get(0);
        }
    }

    @Override
    public List<Guia> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Guia> listaGuias = new ArrayList<>();
        MongoCollection<Guia> collection = this.getCollection();
        collection.find().into(listaGuias);
        return listaGuias;
    }

    
}
