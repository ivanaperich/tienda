
package proyecto;
 
import java.time.LocalDateTime;


public class Arriendo {
    private LocalDateTime fechaInicio; 
    private LocalDateTime fechaFin; 
    private double costo; 
    private Prestable prestable; 

    public Arriendo(double costo, Prestable objPrestable) {
        this.prestable = objPrestable; 
        this.costo = costo;
        this.fechaInicio = LocalDateTime.now(); 
        this.fechaFin = this.fechaInicio.plusDays(prestable.getDias());
    }
    
    
    
}
