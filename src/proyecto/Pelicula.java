
package proyecto;


public class Pelicula extends Recurso {
    
    private String genero;

    public Pelicula(String genero, int codigo, String nombre, String tipo, boolean prestado) {
        super(codigo, nombre, tipo, prestado);
        this.genero = genero;
    }    
}
