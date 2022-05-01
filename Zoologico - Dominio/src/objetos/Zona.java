
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

    public Zona() {
    }

    public Zona(ObjectId id) {
        this.id = id;
    }

    public Zona(String ubicacionActual, String nombre, long extension, List<ObjectId> especiesQueTiene) {
        this.ubicacionActual = ubicacionActual;
        this.nombre = nombre;
        this.extension = extension;
        this.especiesQueTiene = especiesQueTiene;
    }

    public Zona(ObjectId id, String ubicacionActual, String nombre, long extension, List<ObjectId> especiesQueTiene) {
        this.id = id;
        this.ubicacionActual = ubicacionActual;
        this.nombre = nombre;
        this.extension = extension;
        this.especiesQueTiene = especiesQueTiene;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public String getUbicacionActual() {
        return ubicacionActual;
    }

    public void setUbicacionActual(String ubicacionActual) {
        this.ubicacionActual = ubicacionActual;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public long getExtension() {
        return extension;
    }

    public void setExtension(long extension) {
        this.extension = extension;
    }

    public List<ObjectId> getEspeciesQueTiene() {
        return especiesQueTiene;
    }

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
