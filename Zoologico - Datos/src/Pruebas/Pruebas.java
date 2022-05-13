package Pruebas;

import implementacion.FabricaDAOs;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import objetos.Guia;
import objetos.Itinerario;

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
        List<Guia> guias = FabricaDAOs.getGuiasDAO().consultarTodos();
        for (Guia guia : guias) {
            System.out.println(guia);
        }
//        List<LocalDateTime> fechas = new ArrayList();
//        fechas.add(LocalDateTime.of(2022, Month.MAY, 12, 5, 30));
//        FabricaDAOs.getItinerariosDAO().agregar(new Itinerario("A",null,1,fechas,0,69,88));
    }
    
}
