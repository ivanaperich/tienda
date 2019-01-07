
package proyecto;

public class Libro extends Recurso {
    protected String autor;

    public Libro(String autor, int codigo, String nombre, String tipo) {
        super(codigo, nombre, tipo, false);
        this.autor = autor;
        this.costo = 500; 

    }

    public Libro() {
    }    
    
    @Override
    public String getAutor() {
        return autor;
    }

    

    
    
}
