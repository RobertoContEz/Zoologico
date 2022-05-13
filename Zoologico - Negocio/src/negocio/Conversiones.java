package negocio;

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
}
