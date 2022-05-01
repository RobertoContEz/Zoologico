
package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

//Collección el la BD: Especies
public class Especie {
    private ObjectId id;
    private String nombreEspanol;
    private String nombreCientifico;
    private String descripcionGeneral;
    private List<ObjectId> habitatsDondePuedeVivir;
    private ObjectId idZona;
    private ObjectId idCuidador;
    private List<Animal> animales;

    public Especie() {
    }

    public Especie(ObjectId id) {
        this.id = id;
    }

    public Especie(String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> habitatsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador, List<Animal> animales) {
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.habitatsDondePuedeVivir = habitatsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
        this.animales = animales;
    }

    public Especie(ObjectId id, String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> habitatsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador, List<Animal> animales) {
        this.id = id;
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.habitatsDondePuedeVivir = habitatsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
        this.animales = animales;
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

    public List<ObjectId> getHabitatsDondePuedeVivir() {
        return habitatsDondePuedeVivir;
    }

    public void setHabitatsDondePuedeVivir(List<ObjectId> habitatsDondePuedeVivir) {
        this.habitatsDondePuedeVivir = habitatsDondePuedeVivir;
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

    public List<Animal> getAnimales() {
        return animales;
    }

    public void setAnimales(List<Animal> animales) {
        this.animales = animales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public void agregaAnimal(Animal animal) {
        if(animales==null) animales = new ArrayList();
        animales.add(animal);
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
        return "Especie{" + "id=" + id + ", nombreEspanol=" + nombreEspanol + ", nombreCientifico=" + nombreCientifico + ", descripcionGeneral=" + descripcionGeneral + ", habitadsDondePuedeVivir=" + habitatsDondePuedeVivir + ", idZona=" + idZona + ", idCuidador=" + idCuidador + '}';
    }
}
