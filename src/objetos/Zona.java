
package objetos;

import java.util.List;

public class Zona {
    private String ubicacionActual;
    private String nombre;
    private long extension;
    private List<Especie> especiesQueTiene;

    public Zona(String ubicacionActual, String nombre, long extension, List<Especie> cantidadEspeciesQueTiene) {
        this.ubicacionActual = ubicacionActual;
        this.nombre = nombre;
        this.extension = extension;
        this.especiesQueTiene = cantidadEspeciesQueTiene;
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

    public List<Especie> getCantidadEspeciesQueTiene() {
        return especiesQueTiene;
    }

    public void setCantidadEspeciesQueTiene(List<Especie> cantidadEspeciesQueTiene) {
        this.especiesQueTiene = cantidadEspeciesQueTiene;
    }
    
    
}
