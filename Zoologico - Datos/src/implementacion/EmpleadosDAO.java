package implementacion;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.result.UpdateResult;
import interfaces.IConexionBD;
import interfaces.IPersistenciaEmpleado;
import java.util.ArrayList;
import java.util.List;
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

    public EmpleadosDAO(IConexionBD conexion) {
        this.conexion = conexion;
        this.baseDatos = this.conexion.crearConexion();
    }

    @Override
    public MongoCollection<Empleado> getCollection() {
        return this.baseDatos.getCollection("Empleados", Empleado.class);
    }

    @Override
    public boolean agregar(Empleado empleado) {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        MongoCollection<Empleado> coleccion = this.getCollection();
        coleccion.insertOne(empleado);
        return true;
    }

    @Override
    public boolean actualizar(Empleado empleado) {
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
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        return true;
    }

    @Override
    public boolean eliminar(ObjectId id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Empleado consultar(ObjectId id) {
        List<Empleado> listaEmpleados = new ArrayList<>();
        MongoCollection<Empleado> collection = this.getCollection();
        Document filtro = new Document();
        filtro.append("_id", id);
        collection.find(filtro).into(listaEmpleados);
        if (listaEmpleados.isEmpty()) {
            return null;
        } else {
            // TODO: MANEJAR POSIBLES EXCEPCIONES...
            return listaEmpleados.get(0);
        }
    }

    @Override
    public List<Empleado> consultarTodos() {
        // TODO: MANEJAR POSIBLES EXCEPCIONES...
        List<Empleado> listaEmpleados = new ArrayList<>();
        MongoCollection<Empleado> collection = this.getCollection();
        collection.find().into(listaEmpleados);
        return listaEmpleados;
    }

}
