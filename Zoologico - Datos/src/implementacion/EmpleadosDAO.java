package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaEmpleado;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.PersistenceException;
import objetos.Empleado;
import org.bson.Document;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class EmpleadosDAO implements IPersistenciaEmpleado {

    private IConexionBD conexion;
    private MongoDatabase baseDatos;

    /**
     * Constructor que iguala el atributo conexión al valor del parámetro
     * recibido. Establece la conexión a la base de datos.
     *
     * @param conexion parámetro con la conexión.
     */
    public EmpleadosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.getConexion();
    }

    @Override
    public MongoCollection<Empleado> getCollection() {
        return this.baseDatos.getCollection("Empleados", Empleado.class);
    }

    /**
     * Agrega un empleado a la base de datos.
     *
     * @param empleado empleado a agregar a la base de datos.
     * @return true en caso de agregar exitosamente la información a la base,
     * false en caso contrario.
     */
    @Override
    public boolean agregar(Empleado empleado) {
        try {
            MongoCollection<Empleado> coleccion = this.getCollection();
            coleccion.insertOne(empleado);
            return true;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    /**
     * Actualiza la información de un empleado en la base de datos.
     *
     * @param empleado empleado a actualizar en la base.
     * @return true en caso de modificar exitosamente la información, false en
     * caso contrario.
     */
    @Override
    public boolean actualizar(Empleado empleado) {
        try {
            if (empleado.getId() == null) {
                System.out.println("ID del Empleado invalida");
            } else {
                MongoCollection<Empleado> coleccion = this.getCollection();
                Document filtro = new Document();
                filtro.append("_id", empleado.getId());

                Document entidadActualizada = new Document();
                entidadActualizada.append("$set", new Document("nombre", empleado.getNombre())
                        .append("direccion", empleado.getDireccion())
                        .append("telefono", empleado.getTelefono())
                        .append("fechaIngreso", empleado.getFechaIngreso())
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
     * Elimina la información de un empleado dentro de la base.
     *
     * @param id empleado a buscar en la base para ser eliminado.
     * @return treu enc aso de eliminar exitosamente al empleado, false en caso
     * contrario.
     */
    @Override
    public boolean eliminar(ObjectId id) {
        try {
            MongoCollection<Empleado> coleccion = this.getCollection();
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
     * Busca a un empleado en específico dentro de la base.
     *
     * @param id empleado a buscar dentro de la base.
     * @return regresa un empleado en caso de encontrarlo, null en caso
     * contrario.
     */
    @Override
    public Empleado consultar(ObjectId id) {
        try {
            List<Empleado> listaEmpleados = new ArrayList<>();
            MongoCollection<Empleado> collection = this.getCollection();
            Document filtro = new Document();
            filtro.append("_id", id);
            collection.find(filtro).into(listaEmpleados);
            if (listaEmpleados.isEmpty()) {
                return null;
            } else {
                return listaEmpleados.get(0);
            }
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    /**
     * Consulta la lista de todos los animales registrados en la base.
     *
     * @return lista con todos los animales registrados.
     */
    @Override
    public List<Empleado> consultarTodos() {
        try {
            List<Empleado> listaEmpleados = new ArrayList<>();
            MongoCollection<Empleado> collection = this.getCollection();
            collection.find().into(listaEmpleados);
            return listaEmpleados;
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            return null;
        }
    }

}
