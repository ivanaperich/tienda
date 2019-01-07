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

public class AgregarPelicula extends JFrame implements ActionListener {

    private Tienda tienda;
    private PanelAdmin admin;
    private ArrendarPelicula arrendarPelicula;
    
    private JLabel lblCodigo;
    private JLabel lblNombre;
    private JLabel lblGenero;

    private JTextField txtCodigo;
    private JTextField txtNombre;
    private JTextField txtGenero;

    private JButton btnAgregar;
    private JButton btnVolver;

    private JPanel panel;
    private JPanel panelSur;

    public AgregarPelicula() {
        lblCodigo = new JLabel("CODIGO: ");
        txtCodigo = new JTextField();
        txtCodigo.setEditable(false);

        lblNombre = new JLabel("NOMBRE: ");
        txtNombre = new JTextField();

        lblGenero = new JLabel("GENERO: ");
        txtGenero = new JTextField();

        btnAgregar = new JButton("Agregar");
        btnVolver = new JButton("Volver");

        panel = new JPanel(new GridLayout(4, 2));
        panelSur = new JPanel();

        panelSur.add(btnAgregar);
        panelSur.add(btnVolver);

        panel.add(lblCodigo);
        panel.add(txtCodigo);

        panel.add(lblNombre);
        panel.add(txtNombre);

        panel.add(lblGenero);
        panel.add(txtGenero);

        this.setTitle("Agregar Pelicula");
        this.add(panel, BorderLayout.CENTER);
        this.add(panelSur, BorderLayout.SOUTH);
        this.setSize(500, 500);

        btnAgregar.addActionListener(this);
        btnAgregar.setActionCommand("agregar");
        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("agregar")) {
            tienda.agregarRecurso(new Pelicula(txtGenero.getText(), (tienda.inventario.size()+1), txtNombre.getText(), "Pelicula")); 
            arrendarPelicula.setInformacion();
            JOptionPane.showMessageDialog(null, "Pelicula agregada", "Nueva Pelicula", JOptionPane.INFORMATION_MESSAGE);
            limpiarDatos();
            admin.setVisible(true);
            this.setVisible(false);
        } else if (ae.getActionCommand().equals("volver")) {
            admin.setVisible(true);
            this.setVisible(false);
        }

    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setAdmin(PanelAdmin admin) {
        this.admin = admin;
    }   

    public void setArrendarPelicula(ArrendarPelicula arrendarPelicula) {
        this.arrendarPelicula = arrendarPelicula;
    }
    
    public void setCodigo() {
        this.txtCodigo.setText(String.valueOf((tienda.inventario.size()+1)));
    }
    
    public void limpiarDatos() {
        txtCodigo.setText("");
        txtNombre.setText("");
        txtGenero.setText("");        
    }

}
