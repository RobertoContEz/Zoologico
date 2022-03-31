
package objetos;

import java.time.LocalDate;
import java.time.LocalTime;

public class Queja {
    private Itinerario itinerario;
    private LocalDate fecha;
    private LocalTime hora;
    private String queja;
    private String correo;
    private String telefono;

    public Queja(Itinerario itinerario, LocalDate fecha, LocalTime hora, String queja, String correo, String telefono) {
        this.itinerario = itinerario;
        this.fecha = fecha;
        this.hora = hora;
        this.queja = queja;
        this.correo = correo;
        this.telefono = telefono;
    }

    public Itinerario getItinerario() {
        return itinerario;
    }

    public void setItinerario(Itinerario itinerario) {
        this.itinerario = itinerario;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getQueja() {
        return queja;
    }

    public void setQueja(String queja) {
        this.queja = queja;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    
}
