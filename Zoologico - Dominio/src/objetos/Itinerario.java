
package objetos;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

/**
 * Esta clase representa a los itinerarios de recorridos del zoológico.
 * Una abstracción de esta clase contiene todos los datos relevantes del itinerario.
 * En la base de datos, los itinerarios se almacenan en la collección de Itinerarios.
 */
public class Itinerario {
    private ObjectId id;
    private String nombre;
    private List<ObjectId> idsZonasVisitadas;
    private int duracionDelRecorrido;
    private List<String> diasDelRecorrido;
    private List<LocalTime> horasALasQueInicia;
    private long longitud;
    private int numeroMaximoVisitantes;
    private int numeroEspeciesVisitadas;
    private List<Queja> quejas;

    /**
     * Constructor por defecto.
     */
    public Itinerario() {
    }
    
    /**
     * Inicializa la zona con el id.
     * @param id Id del guía.
     */
    public Itinerario(ObjectId id) {
        this.id = id;
    }

    /**
     * Inicializa el itinerario con todos los atributos a exepción del id.
     * @param nombre el nombre del recorrido
     * @param idsZonasVisitadas la lista de los ids de las zonas visitadas en el recorrido
     * @param duracionDelRecorrido la duración en horas del recorrido
     * @param diasDelRecorrido la lista de los días de la semana en los que se ofrece el recorrido
     * @param horasALasQueInicia la lista de horas día a las que puede inicial el recorrido
     * @param longitud la longitud de metros del recorrido
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes autorizados por recorrido
     * @param numeroEspeciesVisitadas el número de especies visitadas en el recorrido
     * @param quejas la lista de quejas enviadas sobre el recorrido
     */
    public Itinerario(String nombre, List<ObjectId> idsZonasVisitadas, int duracionDelRecorrido, List<String> diasDelRecorrido, List<LocalTime> horasALasQueInicia, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas, List<Queja> quejas) {
        this.nombre = nombre;
        this.idsZonasVisitadas = idsZonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasDelRecorrido = diasDelRecorrido;
        this.horasALasQueInicia = horasALasQueInicia;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
        this.quejas = quejas;
    }

    /**
     * Inicializa el itinerario con todos los atributos.
     * @param id el id del itinerario
     * @param nombre el nombre del recorrido
     * @param idsZonasVisitadas la lista de los ids de las zonas visitadas en el recorrido
     * @param duracionDelRecorrido la duración en horas del recorrido
     * @param diasDelRecorrido la lista de los días de la semana en los que se ofrece el recorrido
     * @param horasALasQueInicia la lista de horas día a las que puede inicial el recorrido
     * @param longitud la longitud en metros del recorrido
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes autorizados por recorrido
     * @param numeroEspeciesVisitadas el número de especies visitadas en el recorrido
     * @param quejas la lista de quejas enviadas sobre el recorrido
     */
    public Itinerario(ObjectId id, String nombre, List<ObjectId> idsZonasVisitadas, int duracionDelRecorrido, List<String> diasDelRecorrido, List<LocalTime> horasALasQueInicia, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas, List<Queja> quejas) {
        this.id = id;
        this.nombre = nombre;
        this.idsZonasVisitadas = idsZonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasDelRecorrido = diasDelRecorrido;
        this.horasALasQueInicia = horasALasQueInicia;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
        this.quejas = quejas;
    }

    /**
     * Devuelve el id del itinerario.
     * @return el id del itinerario
     */
    public ObjectId getId() {
        return id;
    }

    /**
     * Establece el id del itinerario.
     * @param id el id del itinerario
     */
    public void setId(ObjectId id) {
        this.id = id;
        if(quejas != null) for (Queja queja : quejas) {
            queja.setIdItinerario(id);
        }
    }

    /**
     * Devuelve el nombre del recorrido.
     * @return el nombre del recorrido
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del recorrido.
     * @param nombre el nombre del recorrido
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la duración en horas del recorrido.
     * @return la duración en horas del recorrido
     */
    public int getDuracionDelRecorrido() {
        return duracionDelRecorrido;
    }

    /**
     * Establece la duración en horas del recorrido.
     * @param duracionDelRecorrido la duración en horas del recorrido
     */
    public void setDuracionDelRecorrido(int duracionDelRecorrido) {
        this.duracionDelRecorrido = duracionDelRecorrido;
    }

    /**
     * Devuelve la lista de los ids de las zonas visitadas en el recorrido.
     * @return la lista de los ids de las zonas visitadas en el recorrido
     */
    public List<ObjectId> getIdsZonasVisitadas() {
        return idsZonasVisitadas;
    }

    /**
     * Establece la lista de los ids de las zonas visitadas en el recorrido.
     * @param zonasVisitadas la lista de los ids de las zonas visitadas en el recorrido
     */
    public void setIdsZonasVisitadas(List<ObjectId> zonasVisitadas) {
        this.idsZonasVisitadas = zonasVisitadas;
    }

    /**
     * Devuelve la lista de los días de la semana en los que se ofrece el recorrido.
     * @return la lista de los días de la semana en los que se ofrece el recorrido
     */
    public List<String> getDiasDelRecorrido() {
        return diasDelRecorrido;
    }

    /**
     * Establece la lista de los días de la semana en los que se ofrece el recorrido.
     * @param diasDelRecorrido la lista de los días de la semana en los que se ofrece el recorrido
     */
    public void setDiasDelRecorrido(List<String> diasDelRecorrido) {
        this.diasDelRecorrido = diasDelRecorrido;
    }

    /**
     * Devuelve la lista de horas día a las que puede inicial el recorrido.
     * @return la lista de horas día a las que puede inicial el recorrido
     */
    public List<LocalTime> getHorasALasQueInicia() {
        return horasALasQueInicia;
    }

    /**
     * Establece la lista de horas día a las que puede inicial el recorrido.
     * @param horasALasQueInicia la lista de horas día a las que puede inicial el recorrido
     */
    public void setHorasALasQueInicia(List<LocalTime> horasALasQueInicia) {
        this.horasALasQueInicia = horasALasQueInicia;
    }

    /**
     * Devuelve la longitud en metros del recorrido.
     * @return la longitud en metros del recorrido
     */
    public long getLongitud() {
        return longitud;
    }

    /**
     * Establece la longitud en metros del recorrido.
     * @param longitud la longitud en metros del recorrido
     */
    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    /**
     * Devuelve la máxima cantidad de visitantes autorizados por recorrido.
     * @return la máxima cantidad de visitantes autorizados por recorrido
     */
    public int getNumeroMaximoVisitantes() {
        return numeroMaximoVisitantes;
    }

    /**
     * Establece la máxima cantidad de visitantes autorizados por recorrido.
     * @param numeroMaximoVisitantes la máxima cantidad de visitantes autorizados por recorrido
     */
    public void setNumeroMaximoVisitantes(int numeroMaximoVisitantes) {
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
    }

    /**
     * Devuelve el número de especies visitadas en el recorrido.
     * @return el número de especies visitadas en el recorrido
     */
    public int getNumeroEspeciesVisitadas() {
        return numeroEspeciesVisitadas;
    }

    /**
     * Establece el número de especies visitadas en el recorrido.
     * @param numeroEspeciesVisitadas el número de especies visitadas en el recorrido
     */
    public void setNumeroEspeciesVisitadas(int numeroEspeciesVisitadas) {
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
    }

    /**
     * Devuelve la lista de quejas enviadas sobre el recorrido.
     * @return la lista de quejas enviadas sobre el recorrido
     */
    public List<Queja> getQuejas() {
        return quejas;
    }

    /**
     * Establece la lista de quejas enviadas sobre el recorrido.
     * @param quejas la lista de quejas enviadas sobre el recorrido
     */
    public void setQuejas(List<Queja> quejas) {
        if(quejas != null) for (Queja queja : quejas) {
            queja.setIdItinerario(id);
        }
        this.quejas = quejas;
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
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", idsZonasVisitadas=" + idsZonasVisitadas + ", duracionDelRecorrido=" + duracionDelRecorrido + ", diasDelRecorrido=" + diasDelRecorrido + ", horasALasQueInicia=" + horasALasQueInicia + ", longitud=" + longitud + ", numeroMaximoVisitantes=" + numeroMaximoVisitantes + ", numeroEspeciesVisitadas=" + numeroEspeciesVisitadas + '}';
    }
    
}
