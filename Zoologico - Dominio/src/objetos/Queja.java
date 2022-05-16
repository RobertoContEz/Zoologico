package objetos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa las quejas presentadas por los visitantes de los
 * distintos recorridos del zoológico. Una abstracción de esta clase contiene
 * todos los datos relevantes de la queja. En la base de datos, las quejas se
 * almacenan en la collección de Recorridos como un documento anidado.
 */
public class Queja {

    private ObjectId id;
    private LocalDate fecha;
    private LocalTime hora;
    private String queja;
    private String correo;
    private String telefono;
    private String nombre;
    private ObjectId idRecorrido;

    /**
     * Constructor por defecto.
     */
    public Queja() {
    }

    /**
     * Inicializa la queja con el id.
     *
     * @param id Id del guía.
     */
    public Queja(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa la queja con todos los atributos a exepción del id.
     *
     * @param fecha la fecha del recorrido de la queja
     * @param hora la hora del recorrido de la queja
     * @param queja el enunciado de la queja
     * @param correo el correo del visitante
     * @param telefono el teléfono del visitante
     * @param nombre el nombre del visitante
     * @param idRecorrido el id del recorrido para el que se presentó la queja
     */
    public Queja(LocalDate fecha, LocalTime hora, String queja, String correo, String telefono, String nombre, ObjectId idRecorrido) {
        this.fecha = fecha;
        this.hora = hora;
        this.queja = queja;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.idRecorrido = idRecorrido;
    }

    /**
     * Inicializa la queja con todos los atributos a exepción del id.
     *
     * @param id el id de la queja
     * @param fecha la fecha del recorrido de la queja
     * @param hora la hora del recorrido de la queja
     * @param queja el enunciado de la queja
     * @param correo el correo del visitante
     * @param telefono el teléfono del visitante
     * @param nombre el nombre del visitante
     * @param idRecorrido el id del recorrido para el que se presentó la queja
     */
    public Queja(ObjectId id, LocalDate fecha, LocalTime hora, String queja, String correo, String telefono, String nombre, ObjectId idRecorrido) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.queja = queja;
        this.correo = correo;
        this.telefono = telefono;
        this.nombre = nombre;
        this.idRecorrido = idRecorrido;
    }

    /**
     * Devuelve el id de la queja.
     *
     * @return el id de la queja
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id de la queja.
     *
     * @param id el id de la queja
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha del recorrido de la queja.
     *
     * @return la fecha del recorrido de la queja
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del recorrido de la queja.
     *
     * @param fecha la fecha del recorrido de la queja
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la hora del recorrido de la queja.
     *
     * @return la hora del recorrido de la queja
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora del recorrido de la queja.
     *
     * @param hora la hora del recorrido de la queja
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Devuelve el enunciado de la queja.
     *
     * @return el enunciado de la queja
     */
    public String getQueja() {
        return queja;
    }

    /**
     * Establece el enunciado de la queja.
     *
     * @param queja el enunciado de la queja
     */
    public void setQueja(String queja) {
        this.queja = queja;
    }

    /**
     * Devuelve el correo del visitante.
     *
     * @return el correo del visitante
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del visitante.
     *
     * @param correo el correo del visitante
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el teléfono del visitante.
     *
     * @return el teléfono del visitante
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del visitante.
     *
     * @param telefono el teléfono del visitante
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    /**
     * Devuelve el nombre del visitante.
     * 
     * @return el nombre del visitante
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el el nombre del visitante.
     * 
     * @param nombre el nombre del visitante 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el id del recorrido para el que se presentó la queja.
     *
     * @return el id del recorrido para el que se presentó la queja
     */
    public ObjectId getIdRecorrido() {
        return idRecorrido;
    }

    /**
     * Establece el id del recorrido para el que se presentó la queja.
     *
     * @param idRecorrido el id del recorrido para el que se presentó la queja
     */
    public void setIdRecorrido(ObjectId idRecorrido) {
        this.idRecorrido = idRecorrido;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + Objects.hashCode(this.id);
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
        final Queja other = (Queja) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Queja{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", queja=" + queja + ", correo=" + correo + ", telefono=" + telefono + ", idRecorrido=" + idRecorrido + '}';
    }

}
