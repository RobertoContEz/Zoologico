
package objetos;

import java.time.LocalDate;
import java.time.LocalTime;
import org.bson.types.ObjectId;

//Las quejas se almacenan en la collección de Itinerarios como un documento anidado
public class Queja {
    private ObjectId id;
    private LocalDate fecha;
    private LocalTime hora;
    private String queja;
    private String correo;
    private String telefono;

    public Queja() {
    }

    public ObjectId getId() {
        return id;
    }

    public void setId(ObjectId id) {
        this.id = id;
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
