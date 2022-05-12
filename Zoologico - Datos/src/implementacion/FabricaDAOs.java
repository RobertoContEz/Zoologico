package implementacion;

import interfaces.IPersistenciaAnimal;
import interfaces.IPersistenciaCuidador;
import interfaces.IPersistenciaEmpleado;
import interfaces.IPersistenciaEspecie;
import interfaces.IPersistenciaGuia;
import interfaces.IPersistenciaHabitat;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaQueja;
import interfaces.IPersistenciaZona;

public class FabricaDAOs {

    public static IPersistenciaAnimal getAnimalesDAO() {
        return new AnimalesDAO(new ConexionBD());
    }

    public static IPersistenciaCuidador getCuidadoresDAO() {
        return new CuidadoresDAO(new ConexionBD());
    }

    public static IPersistenciaEmpleado getEmpleadosDAO() {
        return new EmpleadosDAO(new ConexionBD());
    }

    public static IPersistenciaEspecie getEspeciesDAO() {
        return new EspeciesDAO(new ConexionBD());
    }

    public static IPersistenciaGuia getGuiasDAO() {
        return new GuiasDAO(new ConexionBD());
    }

    public static IPersistenciaHabitat getHabitatsDAO() {
        return new HabitatsDAO(new ConexionBD());
    }

    public static IPersistenciaItinerario getItinerariosDAO() {
        return new ItinerariosDAO(new ConexionBD());
    }

    public static IPersistenciaQueja getQuejasDAO() {
        return new QuejasDAO(new ConexionBD());
    }

    public static IPersistenciaZona getZonaDAO() {
        return new ZonasDAO(new ConexionBD());
    }
    
}
