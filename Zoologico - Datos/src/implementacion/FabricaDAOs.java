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
    
    private static final ConexionBD conexion = new ConexionBD();

    public static IPersistenciaAnimal getAnimalesDAO() {
        return new AnimalesDAO(conexion);
    }

    public static IPersistenciaCuidador getCuidadoresDAO() {
        return new CuidadoresDAO(conexion);
    }

    public static IPersistenciaEmpleado getEmpleadosDAO() {
        return new EmpleadosDAO(conexion);
    }

    public static IPersistenciaEspecie getEspeciesDAO() {
        return new EspeciesDAO(conexion);
    }

    public static IPersistenciaGuia getGuiasDAO() {
        return new GuiasDAO(conexion);
    }

    public static IPersistenciaHabitat getHabitatsDAO() {
        return new HabitatsDAO(conexion);
    }

    public static IPersistenciaItinerario getItinerariosDAO() {
        return new ItinerariosDAO(conexion);
    }

    public static IPersistenciaQueja getQuejasDAO() {
        return new QuejasDAO(conexion);
    }

    public static IPersistenciaZona getZonaDAO() {
        return new ZonasDAO(conexion);
    }
    
}
