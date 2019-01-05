
package proyecto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class main {

    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("12/07/1998", formato); 
        Admin usuAdmin = new Admin("Valentina","Garcia","20016469-5",20,"vale1","v.garcia06@ufromail.cl",fecha);
        
        Tienda tienda = new Tienda();
        Proyecto proyecto = new Proyecto();
        Login login = new Login();
        RegistroUsuario registro = new RegistroUsuario();
        PanelAdmin admin = new PanelAdmin();
        AgregarLibro agregarLibro = new AgregarLibro();
        AgregarPelicula agregarPelicula = new AgregarPelicula();
        AgregarVideojuego agregarVideojuego = new AgregarVideojuego();
        proyecto.agregarUsuario(usuAdmin);
        login.setProyecto(proyecto);
        login.setRegistro(registro);
        login.setAdmin(admin);
        login.setTienda(tienda);
        
        registro.setProyecto(proyecto);
        registro.setLogin(login);
        
        admin.setAgregarLibro(agregarLibro);
        admin.setAgregarPelicula(agregarPelicula);
        admin.setAgregarVideojuego(agregarVideojuego);
        admin.setLogin(login);
        
        agregarLibro.setTienda(tienda);
        agregarLibro.setAdmin(admin);
        agregarPelicula.setTienda(tienda);
        agregarPelicula.setAdmin(admin);
        agregarVideojuego.setTienda(tienda);
        agregarVideojuego.setAdmin(admin);
        
        tienda.setLogin(login);
        login.setVisible(true);              
        
    }
}