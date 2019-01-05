
package proyecto;

public class Libro extends Recurso {
    private String autor;

    public Libro(String autor, int codigo, String nombre, String tipo, boolean prestado) {
        super(codigo, nombre, tipo, prestado);
        this.autor = autor;
    }

    
    
}
