
package proyecto;


public class Pelicula extends Recurso {
    
    private String genero;

    public Pelicula(String genero, int codigo, String nombre, String tipo) {
        super(codigo, nombre, tipo, false);
        this.genero = genero;     

    }    

    public String getGenero() {
        return genero;
    }
    
    
}
