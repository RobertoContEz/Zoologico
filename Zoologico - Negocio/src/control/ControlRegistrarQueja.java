package control;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaItinerario;
import interfaces.IPersistenciaRecorrido;
import java.util.List;
import objetos.Recorrido;

/**
 *
 * @author R.Pacheco, R.Contreras, E.Villagrana y G.Gaxiola
 *
 * TODO: Documentar clase
 */
public class ControlRegistrarQueja {

    public Recorrido recuperarRecorridos(String nombre) {
        IPersistenciaRecorrido daoRecorrido = FabricaDAOs.getRecorridosDAO();
        IPersistenciaItinerario daoItinerario = FabricaDAOs.getItinerariosDAO();
        List<Recorrido> lista = daoRecorrido.consultarRecorridosUltimoMes();

        for (Recorrido recorrido : lista) {
            String nombreItinearario = daoItinerario.consultar(recorrido.getIdItinerario()).getNombre();
            if (nombreItinearario.equals(nombre)) {
                return recorrido;
            }
        }
        return null;
    }

}
