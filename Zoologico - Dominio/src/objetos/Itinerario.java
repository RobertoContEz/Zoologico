package objetos;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa a los itinerarios de recorridos del zoológico. Una
 * abstracción de esta clase contiene todos los datos relevantes del itinerario.
 * En la base de datos, los itinerarios se almacenan en la collección de
 * Itinerarios.
 */
public class Itinerario {

    private ObjectId id;
    private String nombre;
    private List<ObjectId> idsZonasVisitadas;
    private int duracionDelRecorrido;
    private List<LocalTime> diasYHoras;
    private long longitud;
    private int numeroMaximoVisitantes;
    private int numeroEspeciesVisitadas;

    /**
     * Constructor por defecto.
     */
    public Itinerario() {
    }

    /**
     * Inicializa la zona con el id.
     *
     * @param id Id del guía.
     */
    public Itinerario(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa el itinerario con todos los atributos a exepción del id.
     *
     * @param nombre el nombre del recorrido
     * @param idsZonasVisitadas la lista de los ids de las zonas visitadas en el
     * recorrido
     * @param duracionDelRecorrido la duración en minutos del recorrido
     * @param diasYHoras la lista de horas y los días de la semana a las que 
     * puede iniciar el recorrido.
     * @param longitud la longitud de metros del recorrido
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes
     * autorizados por recorrido
     * @param numeroEspeciesVisitadas el número de especies visitadas en el
     * recorrido
     */
    public Itinerario(String nombre, List<ObjectId> idsZonasVisitadas, int duracionDelRecorrido, List<LocalTime> diasYHoras, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas) {
        this.nombre = nombre;
        this.idsZonasVisitadas = idsZonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasYHoras = diasYHoras;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
    }

    /**
     * Inicializa el itinerario con todos los atributos.
     *
     * @param id el id del itinerario
     * @param nombre el nombre del recorrido
     * @param idsZonasVisitadas la lista de los ids de las zonas visitadas en el
     * recorrido
     * @param duracionDelRecorrido la duración en minutos del recorrido
     * @param diasYHoras la lista de horas y los días de la semana a las que 
     * puede iniciar el recorrido.
     * @param longitud la longitud en metros del recorrido
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes
     * autorizados por recorrido
     * @param numeroEspeciesVisitadas el número de especies visitadas en el
     * recorrido
     */
    public Itinerario(ObjectId id, String nombre, List<ObjectId> idsZonasVisitadas, int duracionDelRecorrido, List<LocalTime> diasYHoras, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas) {
        this.id = id;
        this.nombre = nombre;
        this.idsZonasVisitadas = idsZonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasYHoras = diasYHoras;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
    }

    /**
     * Devuelve el id del itinerario.
     *
     * @return el id del itinerario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del itinerario.
     *
     * @param id el id del itinerario
     */
    public void setId(ObjectId id) {
        this.id = id;
    }

    /**
     * Devuelve el nombre del recorrido.
     *
     * @return el nombre del recorrido
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del recorrido.
     *
     * @param nombre el nombre del recorrido
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la duración en minutos del recorrido.
     *
     * @return la duración en minutos del recorrido
     */
    public int getDuracionDelRecorrido() {
        return duracionDelRecorrido;
    }

    /**
     * Establece la duración en minutos del recorrido.
     *
     * @param duracionDelRecorrido la duración en minutos del recorrido
     */
    public void setDuracionDelRecorrido(int duracionDelRecorrido) {
        this.duracionDelRecorrido = duracionDelRecorrido;
    }

    /**
     * Devuelve la lista de los ids de las zonas visitadas en el recorrido.
     *
     * @return la lista de los ids de las zonas visitadas en el recorrido
     */
    public List<ObjectId> getIdsZonasVisitadas() {
        return idsZonasVisitadas;
    }

    /**
     * Establece la lista de los ids de las zonas visitadas en el recorrido.
     *
     * @param zonasVisitadas la lista de los ids de las zonas visitadas en el
     * recorrido
     */
    public void setIdsZonasVisitadas(List<ObjectId> zonasVisitadas) {
        this.idsZonasVisitadas = zonasVisitadas;
    }

    /**
     * Devuelve la lista de horas y los días de la semana a las que puede 
     * iniciar el recorrido.
     *
     * @return la lista de horas y los días de la semana a las que puede iniciar
     * el recorrido.
     */
    public List<LocalTime> getDiasYHoras() {
        return diasYHoras;
    }

    /**
     * Establece la lista de horas y los días de la semana a las que puede 
     * iniciar el recorrido.
     *
     * @param diasYHoras la lista de horas y los días de la semana a las que 
     * puede iniciar el recorrido.
     */
    public void setDiasYHoras(List<LocalTime> diasYHoras) {
        this.diasYHoras = diasYHoras;
    }

    /**
     * Devuelve la longitud en metros del recorrido.
     *
     * @return la longitud en metros del recorrido
     */
    public long getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud en metros del recorrido.
     *
     * @param longitud la longitud en metros del recorrido
     */
    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la máxima cantidad de visitantes autorizados por recorrido.
     *
     * @return la máxima cantidad de visitantes autorizados por recorrido
     */
    public int getNumeroMaximoVisitantes() {
        return numeroMaximoVisitantes;
    }

    /**
     * Establece la máxima cantidad de visitantes autorizados por recorrido.
     *
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes
     * autorizados por recorrido
     */
    public void setNumeroMaximoVisitantes(int numeroMaximoVisitantes) {
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
    }

    /**
     * Devuelve el número de especies visitadas en el recorrido.
     *
     * @return el número de especies visitadas en el recorrido
     */
    public int getNumeroEspeciesVisitadas() {
        return numeroEspeciesVisitadas;
    }

    /**
     * Establece el número de especies visitadas en el recorrido.
     *
     * @param numeroEspeciesVisitadas el número de especies visitadas en el
     * recorrido
     */
    public void setNumeroEspeciesVisitadas(int numeroEspeciesVisitadas) {
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
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
        final Itinerario other = (Itinerario) obj;
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", idsZonasVisitadas=" + idsZonasVisitadas + ", duracionDelRecorrido=" + duracionDelRecorrido + ", diasDelRecorrido=" + ", horasALasQueInicia=" + diasYHoras + ", longitud=" + longitud + ", numeroMaximoVisitantes=" + numeroMaximoVisitantes + ", numeroEspeciesVisitadas=" + numeroEspeciesVisitadas + '}';
    }

}
