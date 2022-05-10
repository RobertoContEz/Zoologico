package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa a los empleados guias del zoológico. Una abstracción de
 * esta clase contiene todos los datos relevantes del guía. En la base de datos,
 * los guias se almacenan en la collección de guías.
 */
public class Guia extends Empleado {

    private List<ObjectId> itinerariosActuales;

    /**
     * Constructor por defecto.
     */
    public Guia() {
    }

    /**
     * Inicializa el guía con el id.
     *
     * @param id Id del guía.
     */
    public Guia(ObjectId id) {
        super(id);
    }

    /**
     * Inicializa el guía con todos los atributos a exepción del id.
     *
     * @param itinerariosActuales Lista de los ids de los itinerarios actuales del
     * guía.
     * @param nombre Nombre del guía.
     * @param direccion Domicilio del guía.
     * @param telefono Teléfono del guía.
     * @param fechaIngreso Fecha de ingreso del guía como guía.
     */
    public Guia(List<ObjectId> itinerariosActuales, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(nombre, direccion, telefono, fechaIngreso);
        this.itinerariosActuales = itinerariosActuales;
    }

    /**
     * Inicializa el guía con todos los atributos.
     *
     * @param itinerariosActuales Lista de los ids de los itinerarios actuales del
     * guía.
     * @param id Id del guía.
     * @param nombre Nombre del guía.
     * @param direccion Domicilio del guía.
     * @param telefono Teléfono del guía.
     * @param fechaIngreso Fecha de ingreso del guía.
     */
    public Guia(List<ObjectId> itinerariosActuales, ObjectId id, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso);
        this.itinerariosActuales = itinerariosActuales;
    }

    /**
     * Devuelve la lista de los ids de los itinerarios actuales del guía.
     *
     * @return la lista de los ids de los itinerarios actuales del guía
     */
    public List<ObjectId> getItinerariosActuales() {
        return itinerariosActuales;
    }

    /**
     * Establece la lista de los ids de los itinerarios actuales del guía.
     *
     * @param itinerarioActual la lista de los ids de los itinerarios actuales
     * del guía
     */
    public void setItinerariosActuales(List<ObjectId> itinerariosActuales) {
        this.itinerariosActuales = itinerariosActuales;
    }

    @Override
    public String toString() {
        return super.toString() + " Guia{" + "itinerarioActual=" + itinerariosActuales + '}';
    }

}
