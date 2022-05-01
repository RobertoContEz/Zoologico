
package objetos;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

//Collección el la BD: Habitads
public class Habitad {
    private ObjectId id;
    private String nombre;
    private String tipoClima;
    private String tipoVegetacion;
    private List<String> continentesDondeSeEncuentra;

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    public String getTipoVegetacion() {
        return tipoVegetacion;
    }

    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }

    public List<String> getContinentesDondeSeEncuentra() {
        return continentesDondeSeEncuentra;
    }

    public void setContinentesDondeSeEncuentra(List<String> continentesDondeSeEncuentra) {
        this.continentesDondeSeEncuentra = continentesDondeSeEncuentra;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.id);
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
        final Habitad other = (Habitad) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Habitad{" + "id=" + id + ", nombre=" + nombre + ", tipoClima=" + tipoClima + ", tipoVegetacion=" + tipoVegetacion + ", continentesDondeSeEncuentra=" + continentesDondeSeEncuentra + '}';
    }

    
}
