package proyecto;

import java.awt.BorderLayout;
import java.awt.Color;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Tienda extends JFrame implements ActionListener {

    ArrayList<Pelicula> peliculas = new ArrayList();
    ArrayList<Videojuego> videojuegos = new ArrayList();
    ArrayList<Libro> libros = new ArrayList();
    ArrayList<Recurso> inventario = new ArrayList();
    private Usuario usuActual;
    private Login login;
    private ArrendarLibro arrendarLibro;
    private ArrendarPelicula arrendarPelicula;
    private ArrendarVideojuego arrendarVideojuego;
    private JPanel panel;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JButton btnLibro;
    private JButton btnPelicula;
    private JButton btnVideojuego;
    private JButton btnBiblioteca;
    private JButton btnCerrar;

    private JLabel lblBienvenido;

    public Tienda() {

        btnLibro = new JButton("Arrendar Libro");
        btnPelicula = new JButton("Arrendar Pelicula");
        btnVideojuego = new JButton("Arrendar Videojuego");
        btnBiblioteca = new JButton("Mi Biblioteca");
        btnCerrar = new JButton("Cerrar sesion");

        panel = new JPanel();
        panelNorte = new JPanel();
        panelSur = new JPanel();

        panelSur.add(btnCerrar);
        panel.add(btnLibro);
        panel.add(btnPelicula);
        panel.add(btnVideojuego);
        panel.add(btnBiblioteca);

        this.setTitle("Tienda");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(600, 150);
        btnLibro.addActionListener(this);
        btnLibro.setActionCommand("libro");
        btnPelicula.addActionListener(this);
        btnPelicula.setActionCommand("pelicula");
        btnVideojuego.addActionListener(this);
        btnVideojuego.setActionCommand("videojuego");
        btnBiblioteca.addActionListener(this);
        btnBiblioteca.setActionCommand("biblioteca");
        btnCerrar.addActionListener(this);
        btnCerrar.setActionCommand("cerrar");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);        
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("libro")) {
            arrendarLibro.setUsuActual(usuActual);
            arrendarLibro.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("pelicula")) {
            arrendarPelicula.setUsuActual(usuActual);
            arrendarPelicula.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("videojuego")) {
            arrendarVideojuego.setUsuActual(usuActual);
            arrendarVideojuego.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("cerrar")) {
            panelNorte.removeAll();
            login.setVisible(true);
            this.setVisible(false);
        }

    }
    
    public Recurso buscarRecurso(int codigo) {
        Recurso recurso = new Libro();
        for(int i =0; i<inventario.size();i++) {
            if(inventario.get(i).getCodigo() == codigo) {
                recurso = inventario.get(i);
            }
        }        
        return recurso;
    }
    

    public void agregarPelicula(Pelicula p) {
        peliculas.add(p);
        inventario.add(p);
    }

    public void agregarVideojuego(Videojuego v) {
        videojuegos.add(v);
        inventario.add(v);
    }

    public void agregarLibro(Libro l) {
        libros.add(l);
        inventario.add(l);
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    public void setUsuActual(Usuario usuActual) {
        this.usuActual = usuActual;
        lblBienvenido = new JLabel("Bienvenido(a) " + usuActual.getNombre() + " " + usuActual.getApellido() + "!");
        panelNorte.add(lblBienvenido);
    }

    public Usuario getUsuActual() {
        return usuActual;
    }   

    public ArrayList<Pelicula> getPeliculas() {
        return peliculas;
    }

    public ArrayList<Videojuego> getVideojuegos() {
        return videojuegos;
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setArrendarLibro(ArrendarLibro arrendarLibro) {
        this.arrendarLibro = arrendarLibro;
    }

    public void setArrendarPelicula(ArrendarPelicula arrendarPelicula) {
        this.arrendarPelicula = arrendarPelicula;
    }

    public void setArrendarVideojuego(ArrendarVideojuego arrendarVideojuego) {
        this.arrendarVideojuego = arrendarVideojuego;
    }

}
