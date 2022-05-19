package Pruebas;

import implementacion.FabricaDAOs;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;
import objetos.Recorrido;

/**
 *
 * @author pache
 */
public class Pruebas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        List<Recorrido> r = FabricaDAOs.getRecorridosDAO().consultarRecorridosUltimoMes();
        List<LocalDate> fechas = new ArrayList();
        for (Recorrido re : r) {
            System.out.println(re.getFechaHora().toLocalDate());
            fechas.add(re.getFechaHora().toLocalDate());
        }
        fechas = new ArrayList(new HashSet(fechas));
        for (LocalDate fecha : fechas) {
            System.out.println(fecha);
        }
//        List<LocalDateTime> fechas = new ArrayList();
//        fechas.add(LocalDateTime.of(2022, Month.MAY, 12, 5, 30));
//        FabricaDAOs.getItinerariosDAO().agregar(new Itinerario("A",null,1,fechas,0,69,88));
    }
    
}
