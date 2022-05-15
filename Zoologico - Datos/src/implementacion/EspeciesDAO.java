package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaEspecie;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
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

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public EspeciesDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Especie> getCollection() {
        return this.baseDatos.getCollection("Especies", Especie.class);
    }

    /**
     * Agrega una especie a la base de datos.
     *
     * @param especie especie a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Especie especie) {
        try {
            MongoCollection<Especie> coleccion = this.getCollection();
            coleccion.insertOne(especie);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza la información de una especie en la base de datos.
     *
     * @param especie especie a actualizar en la base.
     * @return true en caso de modificar eitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Especie especie) {
        try {
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
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Elimina la información de una especie dentro de la base.
     *
     * @param id especie a buscar dentro de la base para ser eliminado.
     * @return true en caso de eliminar exitosamente la especie, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Especie> coleccion = this.getCollection();
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
     * Busca una especie en específico dentro de la base.
     *
     * @param id especie a buscar dentro de la base.
     * @return regresa una especie en caso de encontrarla, null en caso
     * contrario.
     */
    @Override
    public Especie consultar(ObjectId id) {
        try {
            List<Especie> listaEspecies = new ArrayList<>();
            MongoCollection<Especie> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaEspecies);
            if (listaEspecies.isEmpty()) {
                return null;
            } else {
                return listaEspecies.get(0);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta la lista de todas las especies registradas en la base.
     *
     * @return lista con todas las especies registradas en la base.
     */
    @Override
    public List<Especie> consultarTodos() {
        try {
            List<Especie> listaEspecies = new ArrayList<>();
            MongoCollection<Especie> collection = this.getCollection();
            collection.find().into(listaEspecies);
            return listaEspecies;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
