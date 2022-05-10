package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaItinerario;
import java.util.ArrayList;
import java.util.List;
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

    public ItinerariosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Itinerario> getCollection() {
        return this.baseDatos.getCollection("Itinerarios", Itinerario.class);
    }

    @Override
    public boolean agregar(Itinerario itinerario) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Itinerario> coleccion = this.getCollection();
        coleccion.insertOne(itinerario);
        return true;
    }

    @Override
    public boolean actualizar(Itinerario itinerario) {
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
                    .append("diasDelRecorrido", itinerario.getDiasDelRecorrido())
                    .append("horasALasQueInicia", itinerario.getHorasALasQueInicia())
                    .append("longitud", itinerario.getLongitud())
                    .append("numeroMaximoVisitantes", itinerario.getNumeroMaximoVisitantes())
                    .append("numeroEspeciesVisitadas", itinerario.getNumeroEspeciesVisitadas())
                    .append("quejas", itinerario.getQuejas())
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
    public Itinerario consultar(ObjectId id) {
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
    }

    @Override
    public List<Itinerario> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Itinerario> listaItinerarios = new ArrayList<>();
        MongoCollection<Itinerario> collection = this.getCollection();
        collection.find().into(listaItinerarios);
        return listaItinerarios;
    }

   
}
