
package proyecto;

import java.time.LocalDateTime;



public class Admin extends Usuario{

    public Admin(String nombre, String apellido, String rut, int edad, String contraseña, String correo, LocalDateTime nacimiento) {
        super(nombre, apellido, rut, edad, contraseña, correo, nacimiento, true);
    }
    
}
