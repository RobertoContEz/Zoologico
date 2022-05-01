
package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

//Los guias se almacenan en la collección de Empleados
public class Guia extends Empleado {
    private List<ObjectId> itinerarioActual;

    public Guia() {
    }

    public Guia(ObjectId id) {
        super(id);
    }

    public Guia(List<ObjectId> itinerarioActual, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(nombre, direccion, telefono, fechaIngreso);
        this.itinerarioActual = itinerarioActual;
    }

    public Guia(List<ObjectId> itinerarioActual, ObjectId id, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso);
        this.itinerarioActual = itinerarioActual;
    }

    public List<ObjectId> getItinerarioActual() {
        return itinerarioActual;
    }

    public void setItinerarioActual(List<ObjectId> itinerarioActual) {
        this.itinerarioActual = itinerarioActual;
    }
    
    
}
