package objetos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 */
public class Recorrido {

    private ObjectId id;
    private ObjectId idItinerario;
    private ObjectId idGuia;
    private LocalDateTime fechaHora;
    private int numVistitantes;
    private List<Queja> quejas;

    /**
     * Constructor por defecto.
     */
    public Recorrido() {
    }

    /**
     * Metodo que inicializa el recorrido con todos los atributos menos con el
     * id del Recorrido
     *
     * @param idItinerario id del itinerario
     * @param idGuia id del Guia
     * @param fechaHora fecha y hora del recorrido
     * @param numVistitantes numero de visitantes del recorrido
     * @param quejas lista de quejas del recorido
     */
    public Recorrido(ObjectId idItinerario, ObjectId idGuia, LocalDateTime fechaHora, int numVistitantes, List<Queja> quejas) {
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
        this.fechaHora = fechaHora;
        this.numVistitantes = numVistitantes;
        this.quejas = quejas;
    }

    /**
     * Metodo que inicializa el recorrido con todos los atributos
     *
     * @param id id del recorrido
     * @param idItinerario id del itinerario
     * @param idGuia id del Guia
     * @param fechaHora fecha y hora del recorrido
     * @param numVistitantes numero de visitantes del recorrido
     * @param quejas lista de quejas del recorido
     */
    public Recorrido(ObjectId id, ObjectId idItinerario, ObjectId idGuia, LocalDateTime fechaHora, int numVistitantes, List<Queja> quejas) {
        this.id = id;
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
        this.fechaHora = fechaHora;
        this.numVistitantes = numVistitantes;
        this.quejas = quejas;
    }

    /**
     * Metodo que devuelve el id del Recorrido
     *
     * @return id del recorrido
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Metodo que establece el id del Recorrido
     *
     * @param id del Recorrido
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Metodo que devuelve el id del Itinerario
     *
     * @return id del Itinerario
     */
    public ObjectId getIdItinerario() {
        return idItinerario;
    }

    /**
     * Metodo que establece el id del Itinerario
     *
     * @param idItinerario id del Itinerario
     */
    public void setIdItinerario(ObjectId idItinerario) {
        this.idItinerario = idItinerario;
    }

    /**
     * Metodo que devuelve el id del Guia
     *
     * @return id del Guia
     */
    public ObjectId getIdGuia() {
        return idGuia;
    }

    /**
     * Metodo que establece el id del Guia
     *
     * @param idGuia id del Guia
     */
    public void setIdGuia(ObjectId idGuia) {
        this.idGuia = idGuia;
    }

    /**
     * Metodo que devuelve la fecha y hora del Recorrido
     *
     * @return fecha y hora del Recorrido
     */
    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    /**
     * Metodo que establece la fecha y hora del Recorrido
     *
     * @param fechaHora fecha y hora de Recorrido
     */
    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    /**
     * Metodo que devuelve el numero de Visitantes del Recorrido
     *
     * @return numero de Visitantes del Recorrido
     */
    public int getNumVistitantes() {
        return numVistitantes;
    }

    /**
     * Metodo que establece el numero de Visitantes del Reorrido
     *
     * @param numVistitantes numero de Visitantes del Recorrido
     */
    public void setNumVistitantes(int numVistitantes) {
        this.numVistitantes = numVistitantes;
    }

    /**
     * Metodo que devuelve la lista de Quejas
     *
     * @return lista de Quejas
     */
    public List<Queja> getQuejas() {
        return quejas;
    }

    /**
     * Metodo que establece la lista de Quejas
     *
     * @param quejas lista de Quejas
     */
    public void setQuejas(List<Queja> quejas) {
        this.quejas = quejas;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.id);
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
        final Recorrido other = (Recorrido) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Recorrido{" + "id=" + id + ", idItinerario=" + idItinerario + ", idGuia=" + idGuia + ", fechHora=" + fechaHora + ", numVistitantes=" + numVistitantes + ", quejas=" + quejas + '}';
    }

}
