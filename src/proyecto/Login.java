package proyecto;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {

    private Proyecto proyecto;
    private RegistroUsuario registro;
    private Tienda tienda;
    private PanelAdmin admin;
    private JButton btnIngresar;
    private JButton btnRegistrar;

    private JLabel lblRut;
    private JLabel lblContraseña;

    private JTextField txtRut;
    private JTextField txtContraseña;

    private JPanel panel;
    private JPanel panelSur;

    public Login() {

        panel = new JPanel(new GridLayout(2, 2));
        panelSur = new JPanel(new GridLayout(1, 2));

        lblRut = new JLabel("Rut (sin puntos ni guion): ");
        txtRut = new JTextField("");

        lblContraseña = new JLabel("Contraseña: ");
        txtContraseña = new JPasswordField("");
        btnIngresar = new JButton("Ingresar");
        btnRegistrar = new JButton("Registrar");

        panel.add(lblRut);
        panel.add(txtRut);

        panel.add(lblContraseña);
        panel.add(txtContraseña);

        panelSur.add(btnRegistrar);
        panelSur.add(btnIngresar);

        this.setTitle("Login");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);
        this.setSize(300, 120);
        btnIngresar.addActionListener(this);
        btnRegistrar.addActionListener(this);
        btnIngresar.setActionCommand("ingresar");
        btnRegistrar.setActionCommand("registrar");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("ingresar")) {
            if (proyecto.login(txtRut.getText(), txtContraseña.getText())) {
                Usuario usuActual = proyecto.buscarUsuario(txtRut.getText());
                if (usuActual.getEsAdmin()) {
                    admin.setUsuActual(usuActual);
                    admin.setVisible(true);
                    this.setVisible(false);
                } else {
                    tienda.setUsuActual(usuActual);
                    tienda.setVisible(true);
                    this.setVisible(false);
                }
                limpiarDatos();
            } else {
                JOptionPane.showMessageDialog(null, "Usuario y/o contraseña incorrecto(s)", "ERROR", JOptionPane.ERROR_MESSAGE);
            }
        } else if (ae.getActionCommand().equals("registrar")) {
            registro.setVisible(true);
            this.setVisible(false);

        }
    }
    
    public void limpiarDatos() {
        txtRut.setText("");
        txtContraseña.setText("");
              
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public void setRegistro(RegistroUsuario registro) {
        this.registro = registro;
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setAdmin(PanelAdmin admin) {
        this.admin = admin;
    }
    
    

}
