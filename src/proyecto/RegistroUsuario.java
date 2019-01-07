package proyecto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
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

    private JPasswordField txtContraseña;
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
        txtContraseña = new JPasswordField();

        lblCorreo = new JLabel("CORREO: ");
        txtCorreo = new JTextField();

        lblNacimiento = new JLabel("FECHA NACIMIENTO (dd/MM/yyyy): ");
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
        this.setSize(450, 400);

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
            UsuarioNormal usu = new UsuarioNormal(txtNombre.getText(), txtApellido.getText(), txtRut.getText(), calculaEdad(formatoFecha(txtNacimiento.getText())), txtContraseña.getText(), txtCorreo.getText(), formatoFecha(txtNacimiento.getText()));
            proyecto.agregarUsuario(usu);
            JOptionPane.showMessageDialog(null, "Usuario creado", "Nuevo usuario", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatos();
            this.setVisible(false);
            login.setVisible(true);
        } else if (ae.getActionCommand().equals("volver")) {
            limpiarDatos();
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

    public LocalDate formatoFecha(String strFecha) {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate fecha = LocalDate.parse(strFecha, formato);     
        
        return fecha;
    }

    private int calculaEdad(LocalDate fechaNac) {
        LocalDate today = LocalDate.now();

        int difAños = today.getYear() - fechaNac.getYear();
        int difMeses = today.getMonthValue() - fechaNac.getMonthValue();
        int diffDias = today.getDayOfMonth() - fechaNac.getDayOfMonth();

        
        if (difMeses < 0 || (difMeses == 0 && diffDias < 0)) {
            difAños--;
        }
        return difAños;
    }

}
