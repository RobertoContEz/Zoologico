
package objetos;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

//Collección el la BD: Zonas
public class Zona {
    private ObjectId id;
    private String ubicacionActual;
    private String nombre;
    private long extension;
    private List<ObjectId> especiesQueTiene;

    /**
     * Constructor por defecto.
     */
    public Zona() {
    }

    /**
     * Inicializa la queja con el id.
     * @param id Id del guía.
     */
    public Zona(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa la zona con todos los atributos a exepción del id.
     * @param ubicacionActual la descripción de la ubicación de la zona
     * @param nombre el nombre de la zona
     * @param extension la extensión de terreno de la zona, en metros cruadrados
     * @param especiesQueTiene la lista de ids de las especies distintas que contiene la zona
     */
    public Zona(String ubicacionActual, String nombre, long extension, List<ObjectId> especiesQueTiene) {
        this.ubicacionActual = ubicacionActual;
        this.nombre = nombre;
        this.extension = extension;
        this.especiesQueTiene = especiesQueTiene;
    }

    /**
     * Inicializa la zona con todos los atributos.
     * @param id el id de la zona
     * @param ubicacionActual la descripción de la ubicación de la zona
     * @param nombre el nombre de la zona
     * @param extension la extensión de terreno de la zona, en metros cruadrados
     * @param especiesQueTiene la lista de ids de las especies distintas que contiene la zona
     */
    public Zona(ObjectId id, String ubicacionActual, String nombre, long extension, List<ObjectId> especiesQueTiene) {
        this.id = id;
        this.ubicacionActual = ubicacionActual;
        this.nombre = nombre;
        this.extension = extension;
        this.especiesQueTiene = especiesQueTiene;
    }

    /**
     * Devuelve el id de la zona.
     * @return el id de la zona
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id de la zona.
     * @param id el id de la zona
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve la descripción de la ubicación de la zona.
     * @return la descripción de la ubicación de la zona
     */
    public String getUbicacionActual() {
        return ubicacionActual;
    }

    /**
     * Establece la descripción de la ubicación de la zona.
     * @param ubicacionActual la descripción de la ubicación de la zona
     */
    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    /**
     * Devuelve el nombre de la zona.
     * @return el nombre de la zona
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre de la zona.
     * @param nombre el nombre de la zona
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la extensión de terreno de la zona, en metros cruadrados.
     * @return la extensión de terreno de la zona, en metros cruadrados
     */
    public long getExtension() {
        return extension;
    }

    /**
     * Establece la extensión de terreno de la zona, en metros cruadrados.
     * @param extension la extensión de terreno de la zona, en metros cruadrados
     */
    public void setExtension(long extension) {
        this.extension = extension;
    }

    /**
     * Devuelve la lista de ids de las especies distintas que contiene la zona.
     * @return la lista de ids de las especies distintas que contiene la zona
     */
    public List<ObjectId> getEspeciesQueTiene() {
        return especiesQueTiene;
    }

    /**
     * Establece la lista de ids de las especies distintas que contiene la zona.
     * @param especiesQueTiene la lista de ids de las especies distintas que contiene la zona
     */
    public void setEspeciesQueTiene(List<ObjectId> especiesQueTiene) {
        this.especiesQueTiene = especiesQueTiene;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + Objects.hashCode(this.id);
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
        final Zona other = (Zona) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Zona{" + "id=" + id + ", ubicacionActual=" + ubicacionActual + ", nombre=" + nombre + ", extension=" + extension + ", especiesQueTiene=" + especiesQueTiene + '}';
    }

}
