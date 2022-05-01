
package objetos;

import java.time.LocalTime;
import java.util.List;
import java.util.Objects;
import org.bson.types.ObjectId;

//Collección el la BD: Itinerarios
public class Itinerario {
    private ObjectId id;
    private String nombre;
    private List<ObjectId> zonasVisitadas;
    private int duracionDelRecorrido;
    private List<String> diasDelRecorrido;
    private List<LocalTime> horasALasQueInicia;
    private long longitud;
    private int numeroMaximoVisitantes;
    private int numeroEspeciesVisitadas;
    private List<Queja> quejas;

    public Itinerario() {
    }

    public Itinerario(ObjectId id) {
        this.id = id;
    }

    public Itinerario(String nombre, List<ObjectId> zonasVisitadas, int duracionDelRecorrido, List<String> diasDelRecorrido, List<LocalTime> horasALasQueInicia, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas, List<Queja> quejas) {
        this.nombre = nombre;
        this.zonasVisitadas = zonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasDelRecorrido = diasDelRecorrido;
        this.horasALasQueInicia = horasALasQueInicia;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
        this.quejas = quejas;
    }

    public Itinerario(ObjectId id, String nombre, List<ObjectId> zonasVisitadas, int duracionDelRecorrido, List<String> diasDelRecorrido, List<LocalTime> horasALasQueInicia, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas, List<Queja> quejas) {
        this.id = id;
        this.nombre = nombre;
        this.zonasVisitadas = zonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasDelRecorrido = diasDelRecorrido;
        this.horasALasQueInicia = horasALasQueInicia;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
        this.quejas = quejas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getDuracionDelRecorrido() {
        return duracionDelRecorrido;
    }

    public void setDuracionDelRecorrido(int duracionDelRecorrido) {
        this.duracionDelRecorrido = duracionDelRecorrido;
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
    }

    public List<ObjectId> getZonasVisitadas() {
        return zonasVisitadas;
    }

    public void setZonasVisitadas(List<ObjectId> zonasVisitadas) {
        this.zonasVisitadas = zonasVisitadas;
    }

    public List<String> getDiasDelRecorrido() {
        return diasDelRecorrido;
    }

    public void setDiasDelRecorrido(List<String> diasDelRecorrido) {
        this.diasDelRecorrido = diasDelRecorrido;
    }

    public List<LocalTime> getHorasALasQueInicia() {
        return horasALasQueInicia;
    }

    public void setHorasALasQueInicia(List<LocalTime> horasALasQueInicia) {
        this.horasALasQueInicia = horasALasQueInicia;
    }

    public long getLongitud() {
        return longitud;
    }

    public void setLongitud(long longitud) {
        this.longitud = longitud;
    }

    public int getNumeroMaximoVisitantes() {
        return numeroMaximoVisitantes;
    }

    public void setNumeroMaximoVisitantes(int numeroMaximoVisitantes) {
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
    }

    public int getNumeroEspeciesVisitadas() {
        return numeroEspeciesVisitadas;
    }

    public void setNumeroEspeciesVisitadas(int numeroEspeciesVisitadas) {
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
    }

    public List<Queja> getQuejas() {
        return quejas;
    }

    public void setQuejas(List<Queja> quejas) {
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
        return "Itinerario{" + "id=" + id + ", nombre=" + nombre + ", zonasVisitadas=" + zonasVisitadas + ", duracionDelRecorrido=" + duracionDelRecorrido + ", diasDelRecorrido=" + diasDelRecorrido + ", horasALasQueInicia=" + horasALasQueInicia + ", longitud=" + longitud + ", numeroMaximoVisitantes=" + numeroMaximoVisitantes + ", numeroEspeciesVisitadas=" + numeroEspeciesVisitadas + '}';
    }
    
}
