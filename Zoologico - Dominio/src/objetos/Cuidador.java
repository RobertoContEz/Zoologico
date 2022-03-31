
package objetos;

import java.util.Date;
import java.util.List;

public class Cuidador extends Empleado{
    private List<Especie> especiesExperto;
    private List<Especie> especiesBasicas;
    private List<Especie> especiesActuales;
    private List<Especie> listadoDeEspeciesCuidadas;

    public Cuidador(List<Especie> especiesExperto, List<Especie> especiesBasicas, List<Especie> especiesActuales, List<Especie> listadoDeEspeciesCuidadas, String idEmpleado, String nombre, String direccion, Long telefono, Date fechaIngreso) {
        super(idEmpleado, nombre, direccion, telefono, fechaIngreso);
        this.especiesExperto = especiesExperto;
        this.especiesBasicas = especiesBasicas;
        this.especiesActuales = especiesActuales;
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }


    public List<Especie> getEspeciesExperto() {
        return especiesExperto;
    }

    public void setEspeciesExperto(List<Especie> especiesExperto) {
        this.especiesExperto = especiesExperto;
    }

    public List<Especie> getEspeciesBasicas() {
        return especiesBasicas;
    }

    public void setEspeciesBasicas(List<Especie> especiesBasicas) {
        this.especiesBasicas = especiesBasicas;
    }

    public List<Especie> getEspeciesActuales() {
        return especiesActuales;
    }

    public void setEspeciesActuales(List<Especie> especiesActuales) {
        this.especiesActuales = especiesActuales;
    }

    public List<Especie> getListadoDeEspeciesCuidadas() {
        return listadoDeEspeciesCuidadas;
    }

    public void setListadoDeEspeciesCuidadas(List<Especie> listadoDeEspeciesCuidadas) {
        this.listadoDeEspeciesCuidadas = listadoDeEspeciesCuidadas;
    }
    
    
    
}
