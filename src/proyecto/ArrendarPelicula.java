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
        List<Recurso> inventario = tienda.getInventario();
        for (int i = 0; i < inventario.size(); i++) {
            Object[] datos = new Object[4];
            if (inventario.get(i).getTipo().equals("Pelicula")) {
                datos[0] = inventario.get(i).getCodigo();
                datos[1] = inventario.get(i).getNombre();
                datos[2] = inventario.get(i).getGenero();
                if (inventario.get(i).isPrestado()) {
                    datos[3] = "SI";
                } else {
                    datos[3] = "NO";
                }
                model.addRow(datos);
            }
        }
        tabla.setModel(model);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("arrendar")) {
            arriendo.setUsuActual(usuActual);
            arriendo.setTipoRecurso("Pelicula");
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
