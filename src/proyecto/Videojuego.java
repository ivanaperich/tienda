
package proyecto;


public class Videojuego extends Recurso {
    private String desarrollador;

    public Videojuego(String desarrollador, int codigo, String nombre, String tipo) {
        super(codigo, nombre, tipo, false);
        this.desarrollador = desarrollador;
        

    }   

    public String getDesarrollador() {
        return desarrollador;
    }
    
    
}
