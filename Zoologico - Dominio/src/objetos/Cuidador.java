package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

/**
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 * 
 * Esta clase representa a los empleados cuidadores del zoológico. Una
 * abstracción de esta clase contiene todos los datos relevantes del cuidador.
 * En la base de datos, los cuidadores se almacenan en la collección de
 * Empleados.
 */
public class Cuidador extends Empleado {

    private List<ObjectId> especiesExperto;
    private List<ObjectId> especiesBasicas;
    private List<ObjectId> especiesActuales;
    private List<ObjectId> listadoDeEspeciesCuidadas;

    /**
     * Constructor por defecto.
     */
    public Cuidador() {
    }

    /**
     * Inicializa el cuidador con el id.
     *
     * @param id Id del cuidador.
     */
    public Cuidador(ObjectId id) {
        super(id);
    }

    /**
     * Inicializa el cuidador con todos los atributos a exepción del id.
     *
     * @param especiesExperto Lista de especies en las que se especializa el
     * cuidador.
     * @param especiesBasicas Lista de especies en las que el cuidador tiene
     * conocimiento básico.
     * @param especiesActuales Lista de especies de las cuales el cuidador está
     * a cargo actualmente.
     * @param listadoDeEspeciesCuidadas Lista de especies que el cuidador ya ha
     * cuidado anteriormente.
     * @param nombre Nombre del cuidador.
     * @param direccion Domicilio del cuidador.
     * @param telefono Teléfono del cuidador.
     * @param fechaIngreso Fecha de ingreso del cuidador como empleado.
     */
    public Cuidador(List<ObjectId> especiesExperto, List<ObjectId> especiesBasicas, List<ObjectId> especiesActuales, List<ObjectId> listadoDeEspeciesCuidadas, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(nombre, direccion, telefono, fechaIngreso, "Cuidador");
        this.especiesExperto = especiesExperto;
        this.especiesBasicas = especiesBasicas;
        this.especiesActuales = especiesActuales;
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    /**
     * Inicializa el cuidador con todos los atributos.
     *
     * @param especiesExperto Lista de especies en las que se especializa el
     * cuidador.
     * @param especiesBasicas Lista de especies en las que el cuidador tiene
     * conocimiento básico.
     * @param especiesActuales Lista de especies de las cuales el cuidador está
     * a cargo actualmente.
     * @param listadoDeEspeciesCuidadas Lista de especies que el cuidador ya ha
     * cuidado anteriormente.
     * @param id Id del cuidador.
     * @param nombre Nombre del cuidador.
     * @param direccion Domicilio del cuidador.
     * @param telefono Teléfono del cuidador.
     * @param fechaIngreso Fecha de ingreso del cuidador como empleado.
     */
    public Cuidador(List<ObjectId> especiesExperto, List<ObjectId> especiesBasicas, List<ObjectId> especiesActuales, List<ObjectId> listadoDeEspeciesCuidadas, ObjectId id, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso, "Cuidador");
        this.especiesExperto = especiesExperto;
        this.especiesBasicas = especiesBasicas;
        this.especiesActuales = especiesActuales;
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    /**
     * Devuelve la listas de especies en las que el cuidador es experto.
     *
     * @return lista de especies en las que el cuidador es experto.
     */
    public List<ObjectId> getEspeciesExperto() {
        return especiesExperto;
    }

    /**
     * Establece la listas de especies en las que el cuidador es experto.
     *
     * @param especiesExperto lista de especies en las que el cuidador es
     * experto.
     */
    public void setEspeciesExperto(List<ObjectId> especiesExperto) {
        this.especiesExperto = especiesExperto;
    }

    /**
     * Devuelve la lista de especies en las que el cuidador tiene conocimiento
     * básico.
     *
     * @return lista de especies en las que el cuidador tiene conocimiento
     * básico
     */
    public List<ObjectId> getEspeciesBasicas() {
        return especiesBasicas;
    }

    /**
     * Establece la lista de especies en las que el cuidador tiene conocimiento
     * básico.
     *
     * @param especiesBasicas lista de especies en las que el cuidador tiene
     * conocimiento básico
     */
    public void setEspeciesBasicas(List<ObjectId> especiesBasicas) {
        this.especiesBasicas = especiesBasicas;
    }

    /**
     * Devuelve la lista de especies de las cuales el cuidador está a cargo
     * actualmente.
     *
     * @return lista de especies de las cuales el cuidador está a cargo
     * actualmente
     */
    public List<ObjectId> getEspeciesActuales() {
        return especiesActuales;
    }

    /**
     * Establece la lista de especies de las cuales el cuidador está a cargo
     * actualmente.
     *
     * @param especiesActuales lista de especies de las cuales el cuidador está
     * a cargo actualmente
     */
    public void setEspeciesActuales(List<ObjectId> especiesActuales) {
        this.especiesActuales = especiesActuales;
    }

    /**
     * Devuelve el listado de las especies a las que el cuidador ha cuidado
     * anteriormente.
     *
     * @return listado de las especies a las que el cuidador ha cuidado
     * anteriormente
     */
    public List<ObjectId> getListadoDeEspeciesCuidadas() {
        return listadoDeEspeciesCuidadas;
    }

    /**
     * Establece el listado de las especies a las que el cuidador ha cuidado
     * anteriormente.
     *
     * @param listadoDeEspeciesCuidadas listado de las especies a las que el
     * cuidador ha cuidado anteriormente
     */
    public void setListadoDeEspeciesCuidadas(List<ObjectId> listadoDeEspeciesCuidadas) {
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    @Override
    public String toString() {
        return super.toString() + " Cuidador{" + "especiesExperto=" + especiesExperto + ", especiesBasicas=" + especiesBasicas + ", especiesActuales=" + especiesActuales + ", listadoDeEspeciesCuidadas=" + listadoDeEspeciesCuidadas + '}';
    }

}
