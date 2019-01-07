
package proyecto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class main {
        static Admin usuAdmin = null; 
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("12/07/1998", formato); 
        usuAdmin = new Admin("Valentina","Garcia","20016469-5",20,"vale1","v.garcia06@ufromail.cl",fecha); 
        usuAdmin = new Admin("Ivana","Perich","20080278-0",20,"ivana1","i.perich01@ufromail.cl",fecha);
        usuAdmin = new Admin("Cesar","Matus","19863867-6",20,"cesar1","c.matus09@ufromail.cl",fecha);
        
        Tienda tienda = new Tienda();
        Proyecto proyecto = new Proyecto();
        Login login = new Login();
        RegistroUsuario registro = new RegistroUsuario();
        PanelAdmin admin = new PanelAdmin();
        AgregarLibro agregarLibro = new AgregarLibro();
        AgregarPelicula agregarPelicula = new AgregarPelicula();
        AgregarVideojuego agregarVideojuego = new AgregarVideojuego();
        ArrendarLibro arrendarLibro = new ArrendarLibro();
        ArrendarPelicula arrendarPelicula = new ArrendarPelicula();
        ArrendarVideojuego arrendarVideojuego = new ArrendarVideojuego();
        
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
        agregarLibro.setArrendarLibro(arrendarLibro);
        agregarPelicula.setTienda(tienda);
        agregarPelicula.setAdmin(admin);
        agregarPelicula.setArrendarPelicula(arrendarPelicula);
        agregarVideojuego.setTienda(tienda);
        agregarVideojuego.setAdmin(admin);
        agregarVideojuego.setArrendarVideojuego(arrendarVideojuego);
        arrendarLibro.setTienda(tienda);
        arrendarPelicula.setTienda(tienda);
        arrendarVideojuego.setTienda(tienda);
        
        tienda.setLogin(login);
        tienda.setArrendarLibro(arrendarLibro);
        tienda.setArrendarPelicula(arrendarPelicula);
        tienda.setArrendarVideojuego(arrendarVideojuego);
        login.setVisible(true);              
        
    }
}