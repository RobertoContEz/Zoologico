package Pruebas;

import implementacion.FabricaDAOs;
import interfaces.IPersistenciaRecorrido;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;
import objetos.Recorrido;
import org.bson.types.ObjectId;

/**
 *
 * @author pache
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        IPersistenciaRecorrido dao = FabricaDAOs.getRecorridosDAO();
        Recorrido recorrido = new Recorrido();
        recorrido.setIdItinerario(new ObjectId("628693f6487f2f148df5564a"));
        recorrido.setIdGuia(new ObjectId("6279ad68c06853939b888b94"));
        recorrido.setNumVistitantes(10);
        dao.agregar(recorrido);
        
        // TODO code application logic here
//        List<Recorrido> r = FabricaDAOs.getRecorridosDAO().consultarRecorridosUltimoMes();
//        List<LocalDate> fechas = new ArrayList();
//        for (Recorrido re : r) {
//            System.out.println(re.getFechaHora().toLocalDate());
//            fechas.add(re.getFechaHora().toLocalDate());
//        }
//        fechas = new ArrayList(new HashSet(fechas));
//        for (LocalDate fecha : fechas) {
//            System.out.println(fecha);
//        }

//        List<LocalDateTime> fechas = new ArrayList();
//        fechas.add(LocalDateTime.of(2022, Month.MAY, 12, 5, 30));
//        FabricaDAOs.getItinerariosDAO().agregar(new Itinerario("A",null,1,fechas,0,69,88));
    }
    
}
