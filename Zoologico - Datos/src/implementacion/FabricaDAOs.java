package implementacion;

import interfaces.IPersistenciaAnimal;
import interfaces.IPersistenciaCuidador;
import interfaces.IPersistenciaEmpleado;
import interfaces.IPersistenciaEspecie;
import interfaces.IPersistenciaGuia;
import interfaces.IPersistenciaHabitat;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaQueja;
import interfaces.IPersistenciaRecorrido;
import interfaces.IPersistenciaZona;

public class FabricaDAOs {

    private static final ConexionBD conexion = new ConexionBD();

    /**
     * Fabrica el objeto de IPersistenciaAnimal utilizando la conexión a la base
     * de datos.
     *
     * @return AnimalesDAO.
     */
    public static IPersistenciaAnimal getAnimalesDAO() {
        return new AnimalesDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaCuidador utilizando la conexión a la
     * base de datos.
     *
     * @return CuidadoresDAO.
     */
    public static IPersistenciaCuidador getCuidadoresDAO() {
        return new CuidadoresDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaEmpleado utilizando la conexión a la
     * base de datos.
     *
     * @return EmpleadosDAO.
     */
    public static IPersistenciaEmpleado getEmpleadosDAO() {
        return new EmpleadosDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaEspecie utilizando la conexión a la
     * base de datos.
     *
     * @return EspeciesDAO.
     */
    public static IPersistenciaEspecie getEspeciesDAO() {
        return new EspeciesDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaGuia utilizando la conexión a la base
     * de datos.
     *
     * @return GuiasDAO.
     */
    public static IPersistenciaGuia getGuiasDAO() {
        return new GuiasDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaHabitat utilizando la conexión a la
     * base de datos.
     *
     * @return HabitatsDAO.
     */
    public static IPersistenciaHabitat getHabitatsDAO() {
        return new HabitatsDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaItinerario utilizando la conexión a la
     * base de datos.
     *
     * @return ItinerarioDAO.
     */
    public static IPersistenciaItinerario getItinerariosDAO() {
        return new ItinerariosDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaRecorrido utilizando la conexión a la
     * base de datos.
     *
     * @return RecorridosDAO.
     */
    public static IPersistenciaRecorrido getRecorridosDAO() {
        return new RecorridoDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaQueja utilizando la conexión a la base
     * de datos.
     *
     * @return QueJasDAO.
     */
    public static IPersistenciaQueja getQuejasDAO() {
        return new QuejasDAO(conexion);
    }

    /**
     * Fabrica el objeto de IPersistenciaZona utilizando la conexión a la base
     * de datos.
     *
     * @return ZonasDAO.
     */
    public static IPersistenciaZona getZonaDAO() {
        return new ZonasDAO(conexion);
    }

}
