
package objetos;

import java.util.List;

public class Itinerario {
    private String nombre;
    private List<Zona> zonasVisitadas;
    private int duracionDelRecorrido;
    private List<Dia> diasDelRecorrido;
    private List<Hora> horasALasQueInicia;
    private long longitud;
    private int numeroMaximoVisitantes;
    private int numeroEspeciesVisitadas;

    public Itinerario(String nombre, List<Zona> zonasVisitadas, int duracionDelRecorrido, List<Dia> diasDelRecorrido, List<Hora> horasALasQueInicia, long longitud, int numeroMaximoVisitantes, int numeroEspeciesVisitadas) {
        this.nombre = nombre;
        this.zonasVisitadas = zonasVisitadas;
        this.duracionDelRecorrido = duracionDelRecorrido;
        this.diasDelRecorrido = diasDelRecorrido;
        this.horasALasQueInicia = horasALasQueInicia;
        this.longitud = longitud;
        this.numeroMaximoVisitantes = numeroMaximoVisitantes;
        this.numeroEspeciesVisitadas = numeroEspeciesVisitadas;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Zona> getZonasVisitadas() {
        return zonasVisitadas;
    }

    public void setZonasVisitadas(List<Zona> zonasVisitadas) {
        this.zonasVisitadas = zonasVisitadas;
    }

    public int getDuracionDelRecorrido() {
        return duracionDelRecorrido;
    }

    public void setDuracionDelRecorrido(int duracionDelRecorrido) {
        this.duracionDelRecorrido = duracionDelRecorrido;
    }

    public List<Dia> getDiasDelRecorrido() {
        return diasDelRecorrido;
    }

    public void setDiasDelRecorrido(List<Dia> diasDelRecorrido) {
        this.diasDelRecorrido = diasDelRecorrido;
    }

    public List<Hora> getHorasALasQueInicia() {
        return horasALasQueInicia;
    }

    public void setHorasALasQueInicia(List<Hora> horasALasQueInicia) {
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
    
    
    
}
