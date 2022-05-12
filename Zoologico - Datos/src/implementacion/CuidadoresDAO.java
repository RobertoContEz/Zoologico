package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaCuidador;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Cuidador;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class CuidadoresDAO implements IPersistenciaCuidador {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    public CuidadoresDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Cuidador> getCollection() {
        return this.baseDatos.getCollection("Cuidadores", Cuidador.class);
    }

    @Override
    public boolean agregar(Cuidador cuidador) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        try {
            MongoCollection<Cuidador> coleccion = this.getCollection();
            coleccion.insertOne(cuidador);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean actualizar(Cuidador cuidador) {
        try {
            if (cuidador.getId() == null) {
                System.out.println("ID del Cuidador invalida");
            } else {
                MongoCollection<Cuidador> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", cuidador.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("nombre", cuidador.getNombre())
                        .append("direccion", cuidador.getDireccion())
                        .append("telefono", cuidador.getTelefono())
                        .append("fechaIngreso", cuidador.getFechaIngreso())
                        .append("especiesExperto", cuidador.getEspeciesExperto())
                        .append("especiesBasicas", cuidador.getEspeciesBasicas())
                        .append("especiesActuales", cuidador.getEspeciesActuales())
                        .append("listadoDeEspeciesCuidadas", cuidador.getListadoDeEspeciesCuidadas())
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
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Cuidador> coleccion = this.getCollection();
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
    public Cuidador consultar(ObjectId id) {
        try {
            List<Cuidador> listaCuidadores = new ArrayList<>();
            MongoCollection<Cuidador> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaCuidadores);
            if (listaCuidadores.isEmpty()) {
                return null;
            } else {
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return listaCuidadores.get(0);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Cuidador> consultarTodos() {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            List<Cuidador> listaCuidadores = new ArrayList<>();
            MongoCollection<Cuidador> collection = this.getCollection();
            collection.find().into(listaCuidadores);
            return listaCuidadores;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
