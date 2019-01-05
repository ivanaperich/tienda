
package proyecto;


import java.time.LocalDate;




public class Usuario {
    private String nombre;
    private String apellido;
    private String rut;
    private int edad;
    private String contraseña;
    private String correo;    
    private LocalDate nacimiento; 
    private Boolean esAdmin;

    public Usuario() {
    }    

    public Usuario(String nombre, String apellido, String rut, int edad, String contraseña, String correo, LocalDate nacimiento, Boolean esAdmin) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.rut = rut;
        this.edad = edad;
        this.contraseña = contraseña;
        this.correo = correo;
        this.nacimiento = nacimiento;
        this.esAdmin = esAdmin;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }    

    public Boolean getEsAdmin() {
        return esAdmin;
    }

    public void setEsAdmin(Boolean esAdmin) {
        this.esAdmin = esAdmin;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }
    
    
    
    
}
