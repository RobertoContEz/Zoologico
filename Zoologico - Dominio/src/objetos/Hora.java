
package objetos;

import java.time.LocalTime;

public class Hora {
    private LocalTime hora;

    public Hora(LocalTime hora) {
        this.hora = hora;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }
    
}
