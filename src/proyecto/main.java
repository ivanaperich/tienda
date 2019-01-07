
package proyecto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class main {        
    public static void main(String[] args) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse("12/07/1998", formato); 

        Admin usuAdmin = new Admin("Valentina","García","200164695",20,"vale1","v.garcia06@ufromail.cl",fecha);        
        Admin usuAdmin1 = new Admin("Ivana","Perich","200802780",20,"ivana1","i.perich01@ufromail.cl",fecha);
        Admin usuAdmin2 = new Admin("Cesar","Matus","198638676",20,"cesar1","c.matus09@ufromail.cl",fecha);        

        Tienda tienda = new Tienda();
        Biblioteca biblioteca = new Biblioteca();
        Proyecto proyecto = new Proyecto();
        Login login = new Login();
        RegistroUsuario registro = new RegistroUsuario();
        PanelAdmin admin = new PanelAdmin();
        PanelArriendo arriendo = new PanelArriendo();
        AgregarLibro agregarLibro = new AgregarLibro();
        AgregarPelicula agregarPelicula = new AgregarPelicula();
        AgregarVideojuego agregarVideojuego = new AgregarVideojuego();
        ArrendarLibro arrendarLibro = new ArrendarLibro();
        ArrendarPelicula arrendarPelicula = new ArrendarPelicula();
        ArrendarVideojuego arrendarVideojuego = new ArrendarVideojuego();
        
        proyecto.agregarUsuario(usuAdmin); 
        proyecto.agregarUsuario(usuAdmin1); 
        proyecto.agregarUsuario(usuAdmin2); 
                
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
        
        arriendo.setTienda(tienda);
        arriendo.setArrendarLibro(arrendarLibro);
        arriendo.setArrendarPelicula(arrendarPelicula);
        arriendo.setArrendarVideojuego(arrendarVideojuego);
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
        arrendarLibro.setArriendo(arriendo);
        arrendarPelicula.setTienda(tienda);
        arrendarPelicula.setArriendo(arriendo);
        arrendarVideojuego.setTienda(tienda);
        arrendarVideojuego.setArriendo(arriendo);
        
        tienda.setLogin(login);
        tienda.setArrendarLibro(arrendarLibro);
        tienda.setArrendarPelicula(arrendarPelicula);
        tienda.setArrendarVideojuego(arrendarVideojuego);
        tienda.setBiblioteca(biblioteca);
        biblioteca.setTienda(tienda);
        login.setVisible(true);
        
        
    }
}