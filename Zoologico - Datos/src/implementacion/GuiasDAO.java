package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaGuia;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Guia;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola Clase que hace la
 * conexión con la base de datos respecto a los Guias con capacidad para
 * guardarse, actualizarse, eliminarse y recuperarse
 */
public class GuiasDAO implements IPersistenciaGuia {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public GuiasDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Guia> getCollection() {
        return this.baseDatos.getCollection("Empleados", Guia.class);
    }

    /**
     * Agrega un guía a la base de datos.
     *
     * @param guia guía a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Guia guia) {
        try {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            MongoCollection<Guia> coleccion = this.getCollection();
            coleccion.insertOne(guia);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza la información de un guía en la base de datos.
     *
     * @param guia guia a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Guia guia) {
        try {
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
                        .append("itinerarioActual", guia.getIdsItinerariosActuales())
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

    /**
     * Elimina la información de un guía dentro de la base.
     *
     * @param id guía a buscar en la base para ser eliminado.
     * @return true en caso de eliminar exitosamente al guía, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Guia> coleccion = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            filtro.append("tipo", "Guía");
            coleccion.deleteOne(filtro);
            return true;
        } catch (PersistenceException ex) {
            System.err.println(ex.getMessage());
            return false;
        }
    }

    /**
     * Busca un guía en específico dentro de la base.
     *
     * @param id guía a buscar dentro de la base.
     * @return regresa un guía en caso de encontrarlo, null en caso contrario.
     */
    @Override
    public Guia consultar(ObjectId id) {
        try {
            List<Guia> listaGuias = new ArrayList<>();
            MongoCollection<Guia> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            filtro.append("tipo", "Guía");
            collection.find(filtro).into(listaGuias);
            if (listaGuias.isEmpty()) {
                return null;
            } else {
                // TODO: MANEJAR POSIBLES EXCEPCIONES...
                return listaGuias.get(0);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta la lista de todos los guías registrados en la base.
     *
     * @return lista con todos los guías registrados.
     */
    @Override
    public List<Guia> consultarTodos() {
        try {
            List<Guia> listaGuias = new ArrayList<>();
            MongoCollection<Guia> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("tipo", "Guía");
            collection.find(filtro).into(listaGuias);
            return listaGuias;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
