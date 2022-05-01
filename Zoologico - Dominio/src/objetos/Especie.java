
package objetos;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

//Collección el la BD: Especies
public class Especie {
    private ObjectId id;
    private String nombreEspanol;
    private String nombreCientifico;
    private String descripcionGeneral;
    private List<ObjectId> habitadsDondePuedeVivir;
    private ObjectId idZona;
    private ObjectId idCuidador;

    public Especie() {
    }

    public Especie(ObjectId id) {
        this.id = id;
    }

    public Especie(String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> habitadsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador) {
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.habitadsDondePuedeVivir = habitadsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
    }

    public Especie(ObjectId id, String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> habitadsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador) {
        this.id = id;
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.habitadsDondePuedeVivir = habitadsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getNombreEspañol() {
        return nombreEspanol;
    }

    public void setNombreEspañol(String nombreEspañol) {
        this.nombreEspanol = nombreEspañol;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public List<ObjectId> getHabitadsDondePuedeVivir() {
        return habitadsDondePuedeVivir;
    }

    public void setHabitadsDondePuedeVivir(List<ObjectId> habitadsDondePuedeVivir) {
        this.habitadsDondePuedeVivir = habitadsDondePuedeVivir;
    }

    public String getNombreEspanol() {
        return nombreEspanol;
    }

    public void setNombreEspanol(String nombreEspanol) {
        this.nombreEspanol = nombreEspanol;
    }

    public ObjectId getIdZona() {
        return idZona;
    }

    public void setIdZona(ObjectId idZona) {
        this.idZona = idZona;
    }

    public ObjectId getIdCuidador() {
        return idCuidador;
    }

    public void setIdCuidador(ObjectId idCuidador) {
        this.idCuidador = idCuidador;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
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
        final Especie other = (Especie) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Especie{" + "id=" + id + ", nombreEspanol=" + nombreEspanol + ", nombreCientifico=" + nombreCientifico + ", descripcionGeneral=" + descripcionGeneral + ", habitadsDondePuedeVivir=" + habitadsDondePuedeVivir + ", idZona=" + idZona + ", idCuidador=" + idCuidador + '}';
    }
}
