package proyecto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RegistroUsuario extends JFrame implements ActionListener {

    private Proyecto proyecto;
    private Login login;

    private JLabel lblRut;
    private JLabel lblNombre;
    private JLabel lblApellido;
    
    private JLabel lblContraseña;
    private JLabel lblCorreo;
    private JLabel lblNacimiento;

    private JTextField txtRut;
    private JTextField txtNombre;
    private JTextField txtApellido;
    
    private JTextField txtContraseña;
    private JTextField txtCorreo;
    private JTextField txtNacimiento;

    private JButton btnRegistrar;
    private JButton btnVolver;

    private JPanel panel;
    private JPanel panelSur;

    public RegistroUsuario() {
        lblRut = new JLabel("RUT: ");
        txtRut = new JTextField();

        lblNombre = new JLabel("NOMBRE: ");
        txtNombre = new JTextField();

        lblApellido = new JLabel("APELLIDO: ");
        txtApellido = new JTextField();        

        lblContraseña = new JLabel("CONTRASEÑA: ");
        txtContraseña = new JTextField();

        lblCorreo = new JLabel("CORREO: ");
        txtCorreo = new JTextField();

        lblNacimiento = new JLabel("FECHA NACIMIENTO (dd/MM/yyy): ");
        txtNacimiento = new JTextField();

        btnRegistrar = new JButton("Registrar");
        btnVolver = new JButton("Volver");

        panel = new JPanel(new GridLayout(7, 2, 0, 0));
        panelSur = new JPanel();

        panelSur.add(btnRegistrar);
        panelSur.add(btnVolver);

        panel.add(lblRut);
        panel.add(txtRut);

        panel.add(lblNombre);
        panel.add(txtNombre);

        panel.add(lblApellido);
        panel.add(txtApellido);    

        panel.add(lblContraseña);
        panel.add(txtContraseña);

        panel.add(lblCorreo);
        panel.add(txtCorreo);

        panel.add(lblNacimiento);
        panel.add(txtNacimiento);
        this.setTitle("Registrar Usuario");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);
        this.setSize(500, 500);

        btnRegistrar.addActionListener(this);
        btnRegistrar.setActionCommand("registrar");
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("registrar")) {            
            proyecto.agregarUsuario(new UsuarioNormal(txtNombre.getText(), txtApellido.getText(), txtRut.getText(), calculaEdad(formatoFecha(txtNacimiento.getText())), txtContraseña.getText(), txtCorreo.getText(), formatoFecha(txtNacimiento.getText())));
            JOptionPane.showMessageDialog(null, "Usuario creado", "Nuevo usuario", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatos();
            this.setVisible(false);
            login.setVisible(true);
        } else if (ae.getActionCommand().equals("volver")) {
            login.setVisible(true);
            this.setVisible(false);
        }

    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void limpiarDatos() {
        txtRut.setText("");
        txtNombre.setText("");
        txtApellido.setText("");
        txtContraseña.setText("");
        txtCorreo.setText("");
        txtNacimiento.setText("");
    }

    public Calendar formatoFecha(String strFecha) {
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        Date fecha = null;
        try {

            fecha = formato.parse(strFecha);

        } catch (ParseException ex) {

            ex.printStackTrace();

        }
        Calendar cal = Calendar.getInstance();
        cal.setTime(fecha);
        return cal;

    }

    private int calculaEdad(Calendar fechaNac) {
        Calendar today = Calendar.getInstance();

        int difAños = today.get(Calendar.YEAR) - fechaNac.get(Calendar.YEAR);
        int difMeses = today.get(Calendar.MONTH) - fechaNac.get(Calendar.MONTH);
        int diffDias = today.get(Calendar.DAY_OF_MONTH) - fechaNac.get(Calendar.DAY_OF_MONTH);

        //Si está en ese año pero todavía no los ha cumplido
        if (difMeses < 0 || (difMeses == 0 && diffDias < 0)) {
            difAños = difAños - 1;
        }
        return difAños;
    }

}
