
package objetos;

import java.util.Date;
import java.util.List;

public class Guia extends Empleado {
    private List<Itinerario> itinerarioActual;

    public Guia(List<Itinerario> itinerarioActual, String idEmpleado, String nombre, String direccion, Long telefono, Date fechaIngreso) {
        super(idEmpleado, nombre, direccion, telefono, fechaIngreso);
        this.itinerarioActual = itinerarioActual;
    }

    public List<Itinerario> getItinerarioActual() {
        return itinerarioActual;
    }

    public void setItinerarioActual(List<Itinerario> itinerarioActual) {
        this.itinerarioActual = itinerarioActual;
    }
    
    
}
