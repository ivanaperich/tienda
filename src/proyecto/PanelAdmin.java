package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelAdmin extends JFrame implements ActionListener {

    private Login login;  
    private Usuario usuActual;
    private AgregarPelicula agregarPelicula;
    private AgregarLibro agregarLibro;
    private AgregarVideojuego agregarVideojuego;

    private JPanel panel;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JButton btnLibro;
    private JButton btnPelicula;
    private JButton btnVideojuego;

    private JButton btnCerrar;

    private JLabel lblBienvenido;

    public PanelAdmin() {      

        btnLibro = new JButton("Agregar Libro");
        btnPelicula = new JButton("Agregar Pelicula");
        btnVideojuego = new JButton("Agregar Videojuego");

        btnCerrar = new JButton("Cerrar sesion");

        panel = new JPanel();
        panelNorte = new JPanel();
        panelSur = new JPanel();
        
        panelSur.add(btnCerrar);
        panel.add(btnLibro);
        panel.add(btnPelicula);
        panel.add(btnVideojuego);

        this.setTitle("Administrador");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(600, 150);
        btnLibro.addActionListener(this);
        btnLibro.setActionCommand("agregarLibro");
        btnPelicula.addActionListener(this);
        btnPelicula.setActionCommand("agregarPelicula");
        btnVideojuego.addActionListener(this);
        btnVideojuego.setActionCommand("agregarVideojuego");
        btnCerrar.addActionListener(this);
        btnCerrar.setActionCommand("cerrar");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("agregarLibro")) {
            agregarLibro.setCodigo();
            agregarLibro.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("agregarPelicula")) {
            agregarPelicula.setCodigo();
            agregarPelicula.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("agregarVideojuego")) {
            agregarVideojuego.setCodigo();
            agregarVideojuego.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("cerrar")) {
            panelNorte.removeAll();
            login.setVisible(true);
            this.setVisible(false);
        }
    }

    public void setAgregarPelicula(AgregarPelicula agregarPelicula) {
        this.agregarPelicula = agregarPelicula;
    }

    public void setAgregarLibro(AgregarLibro agregarLibro) {
        this.agregarLibro = agregarLibro;
    }

    public void setAgregarVideojuego(AgregarVideojuego agregarVideojuego) {
        this.agregarVideojuego = agregarVideojuego;
    }

    public void setLogin(Login login) {
        this.login = login;
    }
    
    public void setUsuActual(Usuario usuActual) {
        this.usuActual = usuActual;
        lblBienvenido = new JLabel("Bienvenido(a) " + usuActual.getNombre() + " " + usuActual.getApellido() + "!");
        panelNorte.add(lblBienvenido);
    }
    
    

}
