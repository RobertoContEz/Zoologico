
package objetos;

import java.util.List;

public class Habitad {
    private String nombre;
    private Clima tipoClima;
    private Vegetacion tipoVegetacion;
    private List<Continente> continentesDondeSeEncuentra;

    public Habitad(String nombre, Clima tipoClima, Vegetacion tipoVegetacion, List<Continente> continentesDondeSeEncuentra) {
        this.nombre = nombre;
        this.tipoClima = tipoClima;
        this.tipoVegetacion = tipoVegetacion;
        this.continentesDondeSeEncuentra = continentesDondeSeEncuentra;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Clima getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(Clima tipoClima) {
        this.tipoClima = tipoClima;
    }

    public Vegetacion getTipoVegetacion() {
        return tipoVegetacion;
    }

    public void setTipoVegetacion(Vegetacion tipoVegetacion) {
        this.tipoVegetacion = tipoVegetacion;
    }

    public List<Continente> getContinentesDondeSeEncuentra() {
        return continentesDondeSeEncuentra;
    }

    public void setContinentesDondeSeEncuentra(List<Continente> continentesDondeSeEncuentra) {
        this.continentesDondeSeEncuentra = continentesDondeSeEncuentra;
    }
    
    
}
