
package proyecto;

import java.util.Calendar;


public class Admin extends Usuario{

    public Admin(String nombre, String apellido, String rut, int edad, String contraseña, String correo, Calendar nacimiento) {
        super(nombre, apellido, rut, edad, contraseña, correo, nacimiento, true);
    }
    
}
