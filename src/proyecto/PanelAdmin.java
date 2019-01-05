package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class PanelAdmin extends JFrame implements ActionListener {

    private Login login;   

    private JPanel panel;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JButton btnLibro;
    private JButton btnPelicula;
    private JButton btnVideojuego;

    private JButton btnCerrar;

    private JLabel lblBienvenido;

    public PanelAdmin() {
        lblBienvenido = new JLabel("Bienvenido!");

        btnLibro = new JButton("Agregar Libro");
        btnPelicula = new JButton("Agregar Pelicula");
        btnVideojuego = new JButton("Agregar Videojuego");

        btnCerrar = new JButton("Cerrar sesion");

        panel = new JPanel();
        panelNorte = new JPanel();
        panelSur = new JPanel();

        panelNorte.add(lblBienvenido);
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
        btnVideojuego.setActionCommand("agregarJuego");
        btnCerrar.addActionListener(this);
        btnCerrar.setActionCommand("cerrar");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("agregarLibro")) {

        } else if (ae.getActionCommand().equals("agregarPelicula")) {

        } else if (ae.getActionCommand().equals("agregarJuego")) {

        } else if (ae.getActionCommand().equals("cerrar")) {
            login.setVisible(true);
            this.setVisible(false);
        }
    }

}
