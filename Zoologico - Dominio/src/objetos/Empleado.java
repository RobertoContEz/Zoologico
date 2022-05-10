package objetos;

import java.util.Date;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa a los empleados del zoológico. Una abstracción de esta
 * clase contiene todos los datos relevantes del empleado. En la base de datos,
 * los empleados se almacenan en la collección de Empleados.
 */
public class Empleado {

    private ObjectId id;
    private String nombre;
    private String direccion;
    private String telefono;
    private Date fechaIngreso;

    /**
     * Constructor por defecto.
     */
    public Empleado() {
    }

    /**
     * Inicializa el empleado con el id.
     *
     * @param id Id del empleado.
     */
    public Empleado(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa el empleado con todos los atributos a exepción del id.
     *
     * @param nombre Nombre del empleado.
     * @param direccion Domicilio del empleado.
     * @param telefono Teléfono del empleado.
     * @param fechaIngreso Fecha de ingreso del empleado como empleado.
     */
    public Empleado(String nombre, String direccion, String telefono, Date fechaIngreso) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Inicializa el empleado con todos los atributos.
     *
     * @param id Id del empleado.
     * @param nombre Nombre del empleado.
     * @param direccion Domicilio del empleado.
     * @param telefono Teléfono del empleado.
     * @param fechaIngreso Fecha de ingreso del empleado.
     */
    public Empleado(ObjectId id, String nombre, String direccion, String telefono, Date fechaIngreso) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
        this.fechaIngreso = fechaIngreso;
    }

    /**
     * Devuelve el id del empleado.
     *
     * @return el id del empleado
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del empleado.
     *
     * @param id el id del empleado
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del empleado.
     *
     * @return el nombre del empleado
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del empleado.
     *
     * @param nombre el nombre del empleado
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la dirección del empleado.
     *
     * @return la dirección del empleado
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * Establece la dirección del empleado.
     *
     * @param direccion la dirección del empleado
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * Devuelve el teléfono del empleado.
     *
     * @return el teléfono del empleado
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del empleado.
     *
     * @param telefono el teléfono del empleado
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve la fecha de ingreso del empleado.
     *
     * @return la fecha de ingreso del empleado
     */
    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    /**
     * Establece la fecha de ingreso del empleado.
     *
     * @param fechaIngreso la fecha de ingreso del empleado
     */
    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 19 * hash + Objects.hashCode(this.id);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Empleado other = (Empleado) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Empleado{" + "id=" + id + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + ", fechaIngreso=" + fechaIngreso + '}';
    }

}
