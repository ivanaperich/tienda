
package proyecto;
 
import java.time.LocalDateTime;


public class Arriendo {
    private LocalDateTime fechaInicio; 
    private LocalDateTime fechaFin; 
    private double costo; 
    private Recurso recurso; 

    public Arriendo(double costo, Recurso recurso, long dias) {
        this.recurso = recurso; 
        this.costo = costo;
        this.fechaInicio = LocalDateTime.now();
        this.fechaFin = fechaInicio.plusDays(dias);
    }
    
    
    
}
