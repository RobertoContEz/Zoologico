package negocio;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 * TODO: Documentar clase
 */
public class Conversiones {
    public static String horaATexto(LocalDateTime hora) {
        int h = hora.getHour();
        int m = hora.getMinute();
        return (h<10?"0":"")+String.valueOf(h) + ":" + (m<10?"0":"")+String.valueOf(m);
    }
    
    public static String horaATexto(LocalTime hora) {
        int h = hora.getHour();
        int m = hora.getMinute();
        return (h<10?"0":"")+String.valueOf(h) + ":" + (m<10?"0":"")+String.valueOf(m);
    }
    
    public static LocalTime textoAHora(String texto) {
        String[] t = texto.split(":");
        return LocalTime.of(Integer.parseInt(t[0]), Integer.parseInt(t[1]));
    }
    
    public static String fechaATexto(LocalDate fecha) {
        int mes = fecha.getMonthValue();
        int dia = fecha.getDayOfMonth();
        String diaSemana = "";
        
        switch(fecha.getDayOfWeek().getValue()) {
            case 1: diaSemana = "Lunes"; break;
            case 2: diaSemana = "Martes"; break;
            case 3: diaSemana = "Miercoles"; break;
            case 4: diaSemana = "Jueves"; break;
            case 5: diaSemana = "Viernes"; break;
            case 6: diaSemana = "Sabado"; break;
            case 7: diaSemana = "Domingo"; break;
        }
        
        return diaSemana + " " + (dia<10?"0":"")+String.valueOf(dia) + (mes<10?"0":"")+String.valueOf(mes);
    }
    
    
}
