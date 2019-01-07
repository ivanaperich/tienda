package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArrendarPelicula extends JFrame implements ActionListener {

    private Tienda tienda;
    private PanelArriendo arriendo;
    private Usuario usuActual;
    private JTable tabla;
    private DefaultTableModel model;
    private JPanel panelSur;

    private JButton btnArrendar;
    private JButton btnVolver;

    public ArrendarPelicula() {

        this.setLayout(new BorderLayout());
        this.setSize(400, 400);

        String titulos[] = {"CODIGO", "NOMBRE", "GENERO", "PRESTADO"};
        Object[][] datos = {};
        tabla = new JTable(new DefaultTableModel(datos, titulos));
        tabla.setEnabled(false);
        model = (DefaultTableModel) tabla.getModel();
        panelSur = new JPanel();

        btnVolver = new JButton("Volver");
        btnArrendar = new JButton("Arrendar");
        JScrollPane scrollPane = new JScrollPane(tabla);

        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");
        btnArrendar.addActionListener(this);
        btnArrendar.setActionCommand("arrendar");

        panelSur.add(btnArrendar);
        panelSur.add(btnVolver);
        this.setTitle("Peliculas");
        this.add(panelSur, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void setInformacion() {
        model.setRowCount(0);
        List<Pelicula> peliculas = tienda.getPeliculas();
        for (int i = 0; i < peliculas.size(); i++) {
            Object[] data = new Object[4];
            data[0] = peliculas.get(i).getCodigo();
            data[1] = peliculas.get(i).getNombre();
            data[2] = peliculas.get(i).getGenero();
            data[3] = peliculas.get(i).isPrestado();
            model.addRow(data);
        }
        tabla.setModel(model);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("arrendar")) {
            arriendo.setUsuActual(usuActual);
            arriendo.setVisible(true);
        } else if (ae.getActionCommand().equals("volver")) {
            tienda.setVisible(true);
            this.setVisible(false);
        }
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setArriendo(PanelArriendo arriendo) {
        this.arriendo = arriendo;
    }

    public void setUsuActual(Usuario usuActual) {
        this.usuActual = usuActual;
    }
    
    

}
