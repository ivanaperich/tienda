
package proyecto;

public class Libro extends Recurso {
    private String autor;

    public Libro(String autor, int codigo, String nombre, String tipo) {
        super(codigo, nombre, tipo, false);
        this.autor = autor;
        this.costo = 500; 
    }

    public String getAutor() {
        return autor;
    }

    

    
    
}
