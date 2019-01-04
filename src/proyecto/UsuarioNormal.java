
package proyecto;

import java.util.Calendar;


public class UsuarioNormal extends Usuario {

    public UsuarioNormal(String nombre, String apellido, String rut, int edad, String contraseña, String correo, Calendar nacimiento) {
        super(nombre, apellido, rut, edad, contraseña, correo, nacimiento, false);
    }
    
    
}
