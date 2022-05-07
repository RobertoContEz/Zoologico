
package objetos;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Esta clase representa a las distintas especies animales del zoológico.
 * Una abstracción de esta clase contiene todos los datos relevantes de la especie.
 * En la base de datos, las especies se almacenan en la collección de Especies.
 */
public class Especie {
    private ObjectId id;
    private String nombreEspanol;
    private String nombreCientifico;
    private String descripcionGeneral;
    private List<ObjectId> idsHabitatsDondePuedeVivir;
    private ObjectId idZona;
    private ObjectId idCuidador;
    private List<Animal> animales;

    /**
     * Constructor por defecto.
     */
    public Especie() {
    }

    /**
     * Inicializa la especie con el id.
     * @param id Id de la especie.
     */
    public Especie(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa la especie con todos los atributos a exepción del id.
     * @param nombreEspanol nombre común en español de la especie
     * @param nombreCientifico nombre científico de la especie
     * @param descripcionGeneral descripción general de la especie
     * @param idsHabitatsDondePuedeVivir lista de los ids de los habitads naturales donde la especie puede vivir 
     * @param idZona id de la zona del zoológico en la que se encuentra la especie
     * @param idCuidador id del cuidador que se encarga de la especie
     * @param animales lista de los especimenes animales de la especie presentes en el zoológico
     */
    public Especie(String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> idsHabitatsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador, List<Animal> animales) {
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.idsHabitatsDondePuedeVivir = idsHabitatsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
        this.animales = animales;
    }

    /**
     * Inicializa la especie con todos los atributos.
     * @param id id de la especie
     * @param nombreEspanol nombre común en español de la especie
     * @param nombreCientifico nombre científico de la especie
     * @param descripcionGeneral descripción general de la especie
     * @param idsHabitatsDondePuedeVivir lista de los ids de los habitads naturales donde la especie puede vivir 
     * @param idZona id de la zona del zoológico en la que se encuentra la especie
     * @param idCuidador id del cuidador que se encarga de la especie
     * @param animales lista de los especimenes animales de la especie presentes en el zoológico
     */
    public Especie(ObjectId id, String nombreEspanol, String nombreCientifico, String descripcionGeneral, List<ObjectId> idsHabitatsDondePuedeVivir, ObjectId idZona, ObjectId idCuidador, List<Animal> animales) {
        this.id = id;
        this.nombreEspanol = nombreEspanol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.idsHabitatsDondePuedeVivir = idsHabitatsDondePuedeVivir;
        this.idZona = idZona;
        this.idCuidador = idCuidador;
        this.animales = animales;
    }

    /**
     * Devuelve el id del la especie.
     * @return el id de la especie
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id de la especie.
     * @param id el id de la especie
     */
    public void setId(ObjectId id) {
        this.id = id;
        if(animales != null) for (Animal animal : animales) {
            animal.setIdEspecie(id);
        }
    }

    /**
     * Devuelve el nombre común en español de la especie.
     * @return nombre el común en español de la especie
     */
    public String getNombreEspanol() {
        return nombreEspanol;
    }

    /**
     * Establece el nombre común en español de la especie.
     * @param nombreEspanol nombre el común en español de la especie
     */
    public void setNombreEspanol(String nombreEspanol) {
        this.nombreEspanol = nombreEspanol;
    }

    /**
     * Devuelve el nombre científico de la especie.
     * @return el nombre científico de la especie
     */
    public String getNombreCientifico() {
        return nombreCientifico;
    }

    /**
     * Establece el nombre científico de la especie 
     * @param nombreCientifico el nombre científico de la especie 
     */
    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    /**
     * Devuelve la descripción de la especie.
     * @return la descripción de la especie
     */
    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    /**
     * Establece la descripción de la especie.
     * @param descripcionGeneral la descripción de la especie
     */
    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    /**
     * Devuelve la lista de los ids de los habitads naturales donde la especie puede vivir.
     * @return la lista de los ids de los habitads naturales donde la especie puede vivir
     */
    public List<ObjectId> getIdsHabitatsDondePuedeVivir() {
        return idsHabitatsDondePuedeVivir;
    }

    /**
     * Establece la lista de los ids de los habitads naturales donde la especie puede vivir
     * @param idsHabitatsDondePuedeVivir la lista de los ids de los habitads naturales donde la especie puede vivir
     */
    public void setIdsHabitatsDondePuedeVivir(List<ObjectId> idsHabitatsDondePuedeVivir) {
        this.idsHabitatsDondePuedeVivir = idsHabitatsDondePuedeVivir;
    }

    /**
     * Devuelve el id de la zona del zoológico en la que se encuentra la especie.
     * @return el id de la zona del zoológico en la que se encuentra la especie
     */
    public ObjectId getIdZona() {
        return idZona;
    }

    /**
     * Establece el id de la zona del zoológico en la que se encuentra la especie.
     * @param idZona el id de la zona del zoológico en la que se encuentra la especie
     */
    public void setIdZona(ObjectId idZona) {
        this.idZona = idZona;
    }

    /**
     * Devuelve el id del cuidador encargado de la especie.
     * @return el id del cuidador encargado de la especie
     */
    public ObjectId getIdCuidador() {
        return idCuidador;
    }

    /**
     * Establece el id del cuidador encargado de la especie.
     * @param idCuidador el id del cuidador encargado de la especie
     */
    public void setIdCuidador(ObjectId idCuidador) {
        this.idCuidador = idCuidador;
    }

    /**
     * Devuelve la lista de los especimenes animales de la especie presentes en el zoológico.
     * @return la lista de los especimenes animales de la especie presentes en el zoológico
     */
    public List<Animal> getAnimales() {
        return animales;
    }

    /**
     * Establece la lista de los especimenes animales de la especie presentes en el zoológico.
     * @param animales la lista de los especimenes animales de la especie presentes en el zoológico
     */
    public void setAnimales(List<Animal> animales) {
        if(animales != null) for (Animal animal : animales) {
            animal.setIdEspecie(id);
        }
        this.animales = animales;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + Objects.hashCode(this.id);
        return hash;
    }

    public void agregaAnimal(Animal animal) {
        if(animal != null) animal.setId(id);
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
        return "Especie{" + "id=" + id + ", nombreEspanol=" + nombreEspanol + ", nombreCientifico=" + nombreCientifico + ", descripcionGeneral=" + descripcionGeneral + ", habitadsDondePuedeVivir=" + idsHabitatsDondePuedeVivir + ", idZona=" + idZona + ", idCuidador=" + idCuidador + '}';
    }
}
