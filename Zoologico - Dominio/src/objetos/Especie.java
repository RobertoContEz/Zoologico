
package objetos;

import java.util.List;

public class Especie {
    private String idEspecie;
    private String nombreEspañol;
    private String nombreCientifico;
    private String descripcionGeneral;
    private List<Habitad> habitadsDondePuedeVivir;
    private Zona zonaDeUbicacion;
    private Cuidador cuidadorActual;

    public Especie(String idEspecie, String nombreEspañol, String nombreCientifico, String descripcionGeneral, List<Habitad> habitadsDondePuedeVivir, Zona zonaDeUbicacion, Cuidador cuidadorActual) {
        this.idEspecie = idEspecie;
        this.nombreEspañol = nombreEspañol;
        this.nombreCientifico = nombreCientifico;
        this.descripcionGeneral = descripcionGeneral;
        this.habitadsDondePuedeVivir = habitadsDondePuedeVivir;
        this.zonaDeUbicacion = zonaDeUbicacion;
        this.cuidadorActual = cuidadorActual;
    }

    public String getIdEspecie() {
        return idEspecie;
    }

    public void setIdEspecie(String idEspecie) {
        this.idEspecie = idEspecie;
    }

    public String getNombreEspañol() {
        return nombreEspañol;
    }

    public void setNombreEspañol(String nombreEspañol) {
        this.nombreEspañol = nombreEspañol;
    }

    public String getNombreCientifico() {
        return nombreCientifico;
    }

    public void setNombreCientifico(String nombreCientifico) {
        this.nombreCientifico = nombreCientifico;
    }

    public String getDescripcionGeneral() {
        return descripcionGeneral;
    }

    public void setDescripcionGeneral(String descripcionGeneral) {
        this.descripcionGeneral = descripcionGeneral;
    }

    public List<Habitad> getHabitadsDondePuedeVivir() {
        return habitadsDondePuedeVivir;
    }

    public void setHabitadsDondePuedeVivir(List<Habitad> habitadsDondePuedeVivir) {
        this.habitadsDondePuedeVivir = habitadsDondePuedeVivir;
    }

    public Zona getZonaDeUbicacion() {
        return zonaDeUbicacion;
    }

    public void setZonaDeUbicacion(Zona zonaDeUbicacion) {
        this.zonaDeUbicacion = zonaDeUbicacion;
    }

    public Cuidador getCuidadorActual() {
        return cuidadorActual;
    }

    public void setCuidadorActual(Cuidador cuidadorActual) {
        this.cuidadorActual = cuidadorActual;
    }
    
    
}
