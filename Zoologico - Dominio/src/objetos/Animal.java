
package objetos;

import java.util.Objects;
import org.bson.types.ObjectId;

//Los animales se almacenan en la collección de Especies como un documento anidado
public class Animal {
    private ObjectId id;
    private String nombre;
    private char sexo;
    private int edad;
    private ObjectId idEspecie;

    public Animal() {
    }

    public Animal(ObjectId id) {
        this.id = id;
    }

    public Animal(String nombre, char sexo, int edad, ObjectId idEspecie) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idEspecie = idEspecie;
    }

    public Animal(ObjectId id, String nombre, char sexo, int edad, ObjectId idEspecie) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idEspecie = idEspecie;
    }

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

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public ObjectId getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(ObjectId idEspecie) {
        this.idEspecie = idEspecie;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.id);
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
        final Animal other = (Animal) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Animal{" + "id=" + id + ", nombre=" + nombre + ", sexo=" + sexo + ", edad=" + edad + ", idEspecie=" + idEspecie + '}';
    }

}
