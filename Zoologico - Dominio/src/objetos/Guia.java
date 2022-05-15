package objetos;

import java.util.ArrayList;
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

    private List<ObjectId> idsItinerariosActuales;

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
     * @param fechaIngreso Fecha de ingreso del guía.
     */
    public Guia(List<ObjectId> itinerariosActuales, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(nombre, direccion, telefono, fechaIngreso, "Guía");
        this.idsItinerariosActuales = itinerariosActuales;
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
        super(id, nombre, direccion, telefono, fechaIngreso, "Guía");
        this.idsItinerariosActuales = itinerariosActuales;
    }

    /**
     * Devuelve la lista de los ids de los itinerarios actuales del guía.
     *
     * @return la lista de los ids de los itinerarios actuales del guía
     */
    public List<ObjectId> getIdsItinerariosActuales() {
        return idsItinerariosActuales;
    }

    /**
     * Establece la lista de los ids de los itinerarios actuales del guía.
     *
     * @param idsItinerariosActuales la lista de los ids de los itinerarios actuales
     * del guía
     */
    public void setIdsItinerariosActuales(List<ObjectId> idsItinerariosActuales) {
        this.idsItinerariosActuales = idsItinerariosActuales;
    }
    
    /**
     * Añade un itinerario a la lista de itinerarios del guía.
     * 
     * @param idItinerario itinerario nuevo
     */
    public void agregaItinerario(ObjectId idItinerario) {
        if (idsItinerariosActuales == null) {
            idsItinerariosActuales = new ArrayList();
        }
        idsItinerariosActuales.add(idItinerario);
    }

    @Override
    public String toString() {
        return super.toString() + " Guia{" + "itinerariosActuales=" + idsItinerariosActuales + '}';
    }

}
