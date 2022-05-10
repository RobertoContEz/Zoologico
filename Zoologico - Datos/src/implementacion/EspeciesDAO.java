package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaEspecie;
import java.util.ArrayList;
import java.util.List;
import objetos.Especie;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class EspeciesDAO implements IPersistenciaEspecie {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public EspeciesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Especie> getCollection() {
        return this.baseDatos.getCollection("Especies", Especie.class);
    }

    @Override
    public boolean agregar(Especie especie) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Especie> coleccion = this.getCollection();
        coleccion.insertOne(especie);
        return true;
    }

    @Override
    public boolean actualizar(Especie especie) {
        if (especie.getId() == null) {
            System.out.println("ID de la Especie invalida");
        } else {
            MongoCollection<Especie> coleccion = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", especie.getId());

            Document entidadActualizada = new Document();
            entidadActualizada.append("$set", new Document("nombreEspanol", especie.getNombreEspanol())
                    .append("nombreCientifico", especie.getNombreCientifico())
                    .append("descripcionGeneral", especie.getDescripcionGeneral())
                    .append("idsHabitatsDondePuedeVivir", especie.getIdsHabitatsDondePuedeVivir())
                    .append("idZona", especie.getIdZona())
                    .append("idCuidador", especie.getIdCuidador())
                    .append("animales", especie.getAnimales())
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
    public Especie consultar(ObjectId id) {
        List<Especie> listaEspecies = new ArrayList<>();
        MongoCollection<Especie> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaEspecies);
        if (listaEspecies.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaEspecies.get(0);
        }
    }

    @Override
    public List<Especie> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Especie> listaEspecies = new ArrayList<>();
        MongoCollection<Especie> collection = this.getCollection();
        collection.find().into(listaEspecies);
        return listaEspecies;
    }


    
}
