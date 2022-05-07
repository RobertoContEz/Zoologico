
package objetos;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Esta clase representa las quejas presentadas por los visitantes de los distintos itinerarios del zoológico.
 * Una abstracción de esta clase contiene todos los datos relevantes de la queja.
 * En la base de datos, las quejas se almacenan en la collección de Itinerarios como un documento anidado.
 */
public class Queja {
    private ObjectId id;
    private LocalDate fecha;
    private LocalTime hora;
    private String queja;
    private String correo;
    private String telefono;
    private ObjectId idItinerario;

    /**
     * Constructor por defecto.
     */
    public Queja() {
    }

    /**
     * Inicializa la queja con el id.
     * @param id Id del guía.
     */
    public Queja(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa la queja con todos los atributos a exepción del id.
     * @param fecha la fecha del recorrido de la fecha
     * @param hora la hora del recorrido de la fecha
     * @param queja el enunciado de la queja
     * @param correo el correo del visitante
     * @param telefono el teléfono del visitante
     * @param idItinerario el id del itinerario para el que se presentó la queja
     */
    public Queja(LocalDate fecha, LocalTime hora, String queja, String correo, String telefono, ObjectId idItinerario) {
        this.fecha = fecha;
        this.hora = hora;
        this.queja = queja;
        this.correo = correo;
        this.telefono = telefono;
        this.idItinerario = idItinerario;
    }

    /**
     * Inicializa la queja con todos los atributos a exepción del id.
     * @param id el id de la queja
     * @param fecha la fecha del recorrido de la queja
     * @param hora la hora del recorrido de la queja
     * @param queja el enunciado de la queja
     * @param correo el correo del visitante
     * @param telefono el teléfono del visitante
     * @param idItinerario el id del itinerario para el que se presentó la queja
     */
    public Queja(ObjectId id, LocalDate fecha, LocalTime hora, String queja, String correo, String telefono, ObjectId idItinerario) {
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.queja = queja;
        this.correo = correo;
        this.telefono = telefono;
        this.idItinerario = idItinerario;
    }

    /**
     * Devuelve el id de la queja.
     * @return el id de la queja
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id de la queja.
     * @param id el id de la queja
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la fecha del recorrido de la queja.
     * @return la fecha del recorrido de la queja
     */
    public LocalDate getFecha() {
        return fecha;
    }

    /**
     * Establece la fecha del recorrido de la queja.
     * @param fecha la fecha del recorrido de la queja
     */
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    /**
     * Devuelve la hora del recorrido de la queja.
     * @return la hora del recorrido de la queja
     */
    public LocalTime getHora() {
        return hora;
    }

    /**
     * Establece la hora del recorrido de la queja.
     * @param hora la hora del recorrido de la queja
     */
    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    /**
     * Devuelve el enunciado de la queja.
     * @return el enunciado de la queja
     */
    public String getQueja() {
        return queja;
    }

    /**
     * Establece el enunciado de la queja.
     * @param queja el enunciado de la queja
     */
    public void setQueja(String queja) {
        this.queja = queja;
    }

    /**
     * Devuelve el correo del visitante.
     * @return el correo del visitante
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * Establece el correo del visitante.
     * @param correo el correo del visitante
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * Devuelve el teléfono del visitante.
     * @return el teléfono del visitante
     */
    public String getTelefono() {
        return telefono;
    }

    /**
     * Establece el teléfono del visitante.
     * @param telefono el teléfono del visitante
     */
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
        
    /**
     * Devuelve el id del itinerario para el que se presentó la queja.
     * @return el id del itinerario para el que se presentó la queja
     */
    public ObjectId getIdItinerario() {
        return idItinerario;
    }

    /**
     * Establece el id del itinerario para el que se presentó la queja.
     * @param idItinerario el id del itinerario para el que se presentó la queja
     */
    public void setIdItinerario(ObjectId idItinerario) {
        this.idItinerario = idItinerario;
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
        return "Queja{" + "id=" + id + ", fecha=" + fecha + ", hora=" + hora + ", queja=" + queja + ", correo=" + correo + ", telefono=" + telefono + ", idItinerario=" + idItinerario + '}';
    }

}
