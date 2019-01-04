
package proyecto;


import java.util.Date;

public class Usuario {
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;
    private String contraseña;
    private String correo;    
    private Date nacimiento; 
    private String tipo;

    public Usuario() {
    }    

    public Usuario(String nombre, String apellido, String rut, int edad, String contraseña, String correo, Date nacimiento, String tipo) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.edad = edad;
        this.contraseña = contraseña;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
