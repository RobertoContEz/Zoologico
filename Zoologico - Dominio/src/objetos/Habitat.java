package objetos;

import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa a los distintos tipos de hábitats naturales del mundo.
 * Se almacenan para representar en el sistema información útil para la gestión
 * de los animales del zoológico. Una abstracción de esta clase contiene todos
 * los datos relevantes del tipo de hábitat. En la base de datos, los hábitats
 * se almacenan en la collección de Hábitats.
 */
public class Habitat {

    private ObjectId id;
    private String nombre;
    private String tipoClima;
    private String tipoVegetacion;
    private List<String> continentesDondeSeEncuentra;

    /**
     * Constructor por defecto.
     */
    public Habitat() {
    }

    /**
     * Inicializa el hábitad con el id.
     *
     * @param id Id del habitad
     */
    public Habitat(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa el hábitat con todos los atributos a exepción del id.
     *
     * @param nombre el nombre del hábitat
     * @param tipoClima el tipo de clima del hábitat
     * @param tipoVegetacion el tipo de vegetación del hábitat
     * @param continentesDondeSeEncuentra la lista de los nombres de los
     * continentes donde se encuentra el hábitat
     */
    public Habitat(String nombre, String tipoClima, String tipoVegetacion, List<String> continentesDondeSeEncuentra) {
        this.nombre = nombre;
        this.tipoClima = tipoClima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentesDondeSeEncuentra = continentesDondeSeEncuentra;
    }

    /**
     * Inicializa el hábitat con todos los atributos.
     *
     * @param id el id del hábitat
     * @param nombre el nombre del hábitat
     * @param tipoClima el tipo de clima del hábitat
     * @param tipoVegetacion el tipo de vegetación del hábitat
     * @param continentesDondeSeEncuentra la lista de los nombres de los
     * continentes donde se encuentra el hábitat
     */
    public Habitat(ObjectId id, String nombre, String tipoClima, String tipoVegetacion, List<String> continentesDondeSeEncuentra) {
        this.id = id;
        this.nombre = nombre;
        this.tipoClima = tipoClima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentesDondeSeEncuentra = continentesDondeSeEncuentra;
    }

    /**
     * Devuelve el id del hábitat.
     *
     * @return el id del hábitat
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del hábitat.
     *
     * @param id el id del hábitat
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del hábitat.
     *
     * @return el nombre del hábitat
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del hábitat.
     *
     * @param nombre el nombre del hábitat
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve el tipo de clima del hábitat.
     *
     * @return el tipo de clima del hábitat
     */
    public String getTipoClima() {
        return tipoClima;
    }

    /**
     * Establece el tipo de clima del hábitat.
     *
     * @param tipoClima el tipo de clima del hábitat
     */
    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    /**
     * Devuelve el tipo de vegetación del hábitat.
     *
     * @return el tipo de vegetación del hábitat
     */
    public String getTipoVegetacion() {
        return tipoVegetacion;
    }

    /**
     * Establece el tipo de vegetación del hábitat.
     *
     * @param tipoVegetacion el tipo de vegetación del hábitat
     */
    public void setTipoVegetacion(String tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }

    /**
     * Devuelve la lista de los nombres de los continentes donde se encuentra el
     * hábitat.
     *
     * @return la lista de los nombres de los continentes donde se encuentra el
     * hábitat
     */
    public List<String> getContinentesDondeSeEncuentra() {
        return continentesDondeSeEncuentra;
    }

    /**
     * Establece la lista de los nombres de los continentes donde se encuentra
     * el hábitat.
     *
     * @param continentesDondeSeEncuentra la lista de los nombres de los
     * continentes donde se encuentra el hábitat
     */
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
        final Habitat other = (Habitat) obj;
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
