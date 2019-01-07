
package proyecto;


public abstract class Recurso implements Prestable{
    private int codigo;
    private String nombre;
    private String tipo;
    private boolean prestado; 
    protected int costo;


    public Recurso(int codigo, String nombre, String tipo, boolean prestado) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.tipo = tipo;
        this.prestado = prestado;
    }

    public Recurso() {
    }
    
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;

    }   
    
    public String getAutor() {
        return "";
    }  
    
    public String getDesarrollador() {
        return "";
    } 
    
    public String getGenero() {
        return "";
    }  

    
    @Override
    public void prestar() {
        if (this.prestado == false) {
            this.prestado = true;
        }
    }

    @Override
    public void devolver() {
        if (this.prestado == true) {
            this.prestado = false;
        }
    }
}