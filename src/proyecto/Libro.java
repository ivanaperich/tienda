
package proyecto;

public class Libro extends Recurso {
    protected String autor;

    public Libro(String autor, int codigo, String nombre, String tipo) {
        super(codigo, nombre, tipo, false);
        this.autor = autor;    

    }

    public Libro() {
    }    
    
    @Override
    public String getAutor() {
        return autor;
    }

    @Override
    public int getCosto() {
        return 500;
    }

    

    
    
}
