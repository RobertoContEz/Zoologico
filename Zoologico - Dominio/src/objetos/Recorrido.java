package objetos;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 */
public class Recorrido {

    private ObjectId id;
    private ObjectId idItinerario;
    private ObjectId idGuia;
    private LocalDateTime fechaHora;
    private int numVistitantes;
    private List<Queja> quejas;

    public Recorrido() {
    }

    public Recorrido(ObjectId idItinerario, ObjectId idGuia, LocalDateTime fechaHora, int numVistitantes, List<Queja> quejas) {
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
        this.fechaHora = fechaHora;
        this.numVistitantes = numVistitantes;
        this.quejas = quejas;
    }

    public Recorrido(ObjectId id, ObjectId idItinerario, ObjectId idGuia, LocalDateTime fechaHora, int numVistitantes, List<Queja> quejas) {
        this.id = id;
        this.idItinerario = idItinerario;
        this.idGuia = idGuia;
        this.fechaHora = fechaHora;
        this.numVistitantes = numVistitantes;
        this.quejas = quejas;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public ObjectId getIdItinerario() {
        return idItinerario;
    }

    public void setIdItinerario(ObjectId idItinerario) {
        this.idItinerario = idItinerario;
    }

    public ObjectId getIdGuia() {
        return idGuia;
    }

    public void setIdGuia(ObjectId idGuia) {
        this.idGuia = idGuia;
    }

    public LocalDateTime getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(LocalDateTime fechaHora) {
        this.fechaHora = fechaHora;
    }

    public int getNumVistitantes() {
        return numVistitantes;
    }

    public void setNumVistitantes(int numVistitantes) {
        this.numVistitantes = numVistitantes;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

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
