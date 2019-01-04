package proyecto;




import java.util.ArrayList;
import java.util.Date;

public class Proyecto {
    ArrayList<Usuario> usuarios = new ArrayList();

    public Proyecto() {
    }

    public void agregarUsuario(String nombre, String apellido, String rut, int edad, String contraseña, String correo, Date nacimiento, String tipo) {
        usuarios.add(new Usuario(nombre, apellido, rut, edad, contraseña, correo, nacimiento, tipo));
    }

    public boolean login(String rut, String contraseña) {
        boolean resp = false;
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut) && usuarios.get(i).getContraseña().equals(contraseña)) {
                resp = true;
            }
        }
        return resp;
    }

    public Usuario buscarUsuario(String rut) {
        Usuario u = new Usuario();
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut)) {
                u = usuarios.get(i);
            }
        }
        return u;
    }
    
    public void eliminarUsuario(String rut){
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getRut().equals(rut)){
                usuarios.remove(usuarios.get(i));
            }            
        }
    }
}