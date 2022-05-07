
package objetos;

import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Esta clase representa a los especímenes animales del zoológico.
 * Una abstracción de esta clase contiene todos los datos relevantes del animal.
 * En la base de datos, los animales se almacenan en la collección de Especies como un documento anidado.
 */
public class Animal {
    private ObjectId id;
    private String nombre;
    private char sexo;
    private int edad;
    private ObjectId idEspecie;

    /**
     * Constructor por defecto.
     */
    public Animal() {
    }

    /**
     * Inicializa el animal con el id.
     * @param id Id del animal.
     */
    public Animal(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa el animal con todos los atributos a exepción del id.
     * @param nombre Nombre del animal.
     * @param sexo Caracter que representa el sexo del animal.
     * @param edad Edad en años del animal.
     * @param idEspecie Id de la especie del animal.
     */
    public Animal(String nombre, char sexo, int edad, ObjectId idEspecie) {
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idEspecie = idEspecie;
    }

    /**
     * Inicializa el animal con todos los atributos.
     * @param id Id del animal.
     * @param nombre Nombre del animal.
     * @param sexo Caracter que representa el sexo del animal.
     * @param edad Edad en años del animal.
     * @param idEspecie Id de la especie del animal.
     */
    public Animal(ObjectId id, String nombre, char sexo, int edad, ObjectId idEspecie) {
        this.id = id;
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
        this.idEspecie = idEspecie;
    }

    /**
     * Devuelve el id del animal.
     * @return el id del animal.
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del animal.
     * @param id el nuevo id del animal.
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del animal.
     * @return el nombre del animal.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del animal.
     * @param nombre el nuevo nombre del animal.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el sexo del animal.
     * @return el caracter representante del sexo del animal.
     */
    public char getSexo() {
        return sexo;
    }

    /**
     * Establece el sexo del animal.
     * @param sexo el caracter representante del sexo del animal.
     */
    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    /**
     * Devuelve la edad del animal.
     * @return la edad en años del animal.
     */
    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del animal.
     * @param edad la nueva edad en años del animal.
     */
    public void setEdad(int edad) {
        this.edad = edad;
    }

    /**
     * Devuelve la id de la especie del animal.
     * @return la id de la especie del animal.
     */
    public ObjectId getIdEspecie() {
        return idEspecie;
    }

    /**
     * Establece la id de la especie del animal.
     * @param idEspecie la nueva id de la especie del animal.
     */
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
