
package proyecto;


public class main {

    public static void main(String[] args) {
       
        Proyecto proyecto = new Proyecto();
        Login login = new Login();
        RegistroUsuario registro = new RegistroUsuario();
        
        login.setProyecto(proyecto);
        login.setRegistro(registro);
        registro.setProyecto(proyecto);
        registro.setLogin(login);
        login.setVisible(true);
              
        
    }
}