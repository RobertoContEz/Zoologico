
package objetos;

import java.util.Date;
import java.util.List;
import org.bson.types.ObjectId;

//Los cuidadores se almacenan en la collección de Empleados
public class Cuidador extends Empleado{
    private List<ObjectId> especiesExperto;
    private List<ObjectId> especiesBasicas;
    private List<ObjectId> especiesActuales;
    private List<ObjectId> listadoDeEspeciesCuidadas;

    public Cuidador() {
    }

    public Cuidador(ObjectId id) {
        super(id);
    }

    public Cuidador(List<ObjectId> especiesExperto, List<ObjectId> especiesBasicas, List<ObjectId> especiesActuales, List<ObjectId> listadoDeEspeciesCuidadas, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(nombre, direccion, telefono, fechaIngreso);
        this.especiesExperto = especiesExperto;
        this.especiesBasicas = especiesBasicas;
        this.especiesActuales = especiesActuales;
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    public Cuidador(List<ObjectId> especiesExperto, List<ObjectId> especiesBasicas, List<ObjectId> especiesActuales, List<ObjectId> listadoDeEspeciesCuidadas, ObjectId id, String nombre, String direccion, String telefono, Date fechaIngreso) {
        super(id, nombre, direccion, telefono, fechaIngreso);
        this.especiesExperto = especiesExperto;
        this.especiesBasicas = especiesBasicas;
        this.especiesActuales = especiesActuales;
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    public List<ObjectId> getEspeciesExperto() {
        return especiesExperto;
    }

    public void setEspeciesExperto(List<ObjectId> especiesExperto) {
        this.especiesExperto = especiesExperto;
    }

    public List<ObjectId> getEspeciesBasicas() {
        return especiesBasicas;
    }

    public void setEspeciesBasicas(List<ObjectId> especiesBasicas) {
        this.especiesBasicas = especiesBasicas;
    }

    public List<ObjectId> getEspeciesActuales() {
        return especiesActuales;
    }

    public void setEspeciesActuales(List<ObjectId> especiesActuales) {
        this.especiesActuales = especiesActuales;
    }

    public List<ObjectId> getListadoDeEspeciesCuidadas() {
        return listadoDeEspeciesCuidadas;
    }

    public void setListadoDeEspeciesCuidadas(List<ObjectId> listadoDeEspeciesCuidadas) {
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }

    
    
}
