
package proyecto;
 
import java.time.LocalDateTime;


public class Arriendo {
    private LocalDateTime fechaInicio; 
    private LocalDateTime fechaFin; 
    private int costo; 
    private Recurso recurso; 

    public Arriendo(int costo, Recurso recurso, long dias) {
        this.recurso = recurso; 
        this.costo = costo;
        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = fechaInicio.plusDays(dias);
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public int getCosto() {
        return costo;
    }

    public Recurso getRecurso() {
        return recurso;
    }    
    
    
}
