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
import javax.swing.JTextField;

public class PanelArriendo extends JFrame implements ActionListener {

    private Tienda tienda;
    private Usuario usuActual;
    private ArrendarLibro arrendarLibro;
    private ArrendarPelicula arrendarPelicula;
    private ArrendarVideojuego arrendarVideojuego;
    private String tipoRecurso;

    private JPanel panel;
    private JPanel panelNorte;
    private JPanel panelSur;
    private JButton btnArrendar;
    private JButton btnCancelar;
    private JButton btnCosto;

    private JLabel lblCodigo;
    private JLabel lblDias;
    private JLabel lblCosto;

    private JTextField txtCodigo;
    private JTextField txtDias;
    private JTextField txtCosto;

    public PanelArriendo() {
        lblCodigo = new JLabel("INGRESE CODIGO: ");
        txtCodigo = new JTextField();

        lblDias = new JLabel("INGRESE CANTIDAD DIAS: ");
        txtDias = new JTextField();

        lblCosto = new JLabel("COSTO TOTAL: ");
        txtCosto = new JTextField();
        txtCosto.setEditable(false);

        btnArrendar = new JButton("Arrendar");
        btnCancelar = new JButton("Cancelar");
        btnCosto = new JButton("Calcular costo");

        panel = new JPanel();
        panelNorte = new JPanel(new GridLayout(2, 1));
        panelSur = new JPanel();

        panelSur.add(btnArrendar);
        panelSur.add(btnCancelar);

        panel.add(btnCosto);
        panelNorte.add(lblCodigo);
        panelNorte.add(lblDias);
        panelNorte.add(lblCosto);

        panelNorte.add(txtCodigo);
        panelNorte.add(txtDias);
        panelNorte.add(txtCosto);

        this.setTitle("Arrendar");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelNorte, BorderLayout.NORTH);
        this.add(panelSur, BorderLayout.SOUTH);

        this.setSize(500, 150);
        btnArrendar.addActionListener(this);
        btnArrendar.setActionCommand("arrendar");
        btnCancelar.addActionListener(this);
        btnCancelar.setActionCommand("cancelar");
        btnCosto.addActionListener(this);
        btnCosto.setActionCommand("costo");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocation(420, 420);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("arrendar")) {
            Recurso recurso = tienda.buscarRecurso(Integer.parseInt(txtCodigo.getText()));
            int dias = Integer.parseInt(txtDias.getText());
            if (recurso.getCodigo() != Integer.parseInt(txtCodigo.getText()) || !recurso.getTipo().equals(tipoRecurso)) {
                JOptionPane.showMessageDialog(null, "Codigo incorrecto", "ERROR", JOptionPane.ERROR_MESSAGE);
            } else {
                if (!recurso.isPrestado()) {
                    tienda.eliminarRecurso(recurso);
                    recurso.prestar();
                    usuActual.setArriendo(new Arriendo(calcularCosto(dias, recurso), recurso, dias));
                    tienda.agregarRecurso(recurso);
                    arrendarPelicula.setInformacion();
                    arrendarLibro.setInformacion();
                    arrendarVideojuego.setInformacion();
                    JOptionPane.showMessageDialog(null, "Recurso arrendado", "Arriendo realizado con éxito", JOptionPane.INFORMATION_MESSAGE);
                    this.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(null, "Producto ya prestado", "ERROR", JOptionPane.ERROR_MESSAGE);
                }
            }
            limpiarDatos();
        } else if (ae.getActionCommand().equals("costo")) {
            Recurso recurso = tienda.buscarRecurso(Integer.parseInt(txtCodigo.getText()));
            int dias = Integer.parseInt(txtDias.getText());
            txtCosto.setText(String.valueOf(calcularCosto(dias, recurso)));
        } else if (ae.getActionCommand().equals("cancelar")) {
            limpiarDatos();
            this.setVisible(false);
        }
    }

    public int calcularCosto(int dias, Recurso recurso) {
        return recurso.getCosto() * dias;
    }

    public void limpiarDatos() {
        txtCodigo.setText("");
        txtDias.setText("");
        txtCosto.setText("");
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setUsuActual(Usuario usuActual) {
        this.usuActual = usuActual;
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

    public void setTipoRecurso(String tipoRecurso) {
        this.tipoRecurso = tipoRecurso;
    }   

}
