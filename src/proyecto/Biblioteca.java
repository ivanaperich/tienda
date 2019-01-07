package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.format.DateTimeFormatter;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Biblioteca extends JFrame implements ActionListener {

    private Tienda tienda;
    private Usuario usuActual;
    private JTable tabla;
    private DefaultTableModel model;
    private JPanel panelSur;

    private JButton btnVolver;

    public Biblioteca() {
        this.setLayout(new BorderLayout());
        this.setSize(800, 200);

        String titulos[] = {"TIPO", "CODIGO", "NOMBRE", "FECHA INICIO", "FECHA FIN", "COSTO"};
        Object[][] datos = {};
        tabla = new JTable(new DefaultTableModel(datos, titulos));
        tabla.setEnabled(false);
        model = (DefaultTableModel) tabla.getModel();
        panelSur = new JPanel();

        btnVolver = new JButton("Volver");
        JScrollPane scrollPane = new JScrollPane(tabla);

        btnVolver.addActionListener(this);
        btnVolver.setActionCommand("volver");

        panelSur.add(btnVolver);
        this.setTitle("Mi Biblioteca");
        this.add(panelSur, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("volver")) {
            tienda.setVisible(true);
            this.setVisible(false);
        }
    }

    public void setInformacion() {  
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        model.setRowCount(0);
        List<Arriendo> arriendos = usuActual.getArriendos();
        for (int i = 0; i < arriendos.size(); i++) {
            Object[] data = new Object[6];
            data[0] = arriendos.get(i).getRecurso().getTipo();
            data[1] = arriendos.get(i).getRecurso().getCodigo();
            data[2] = arriendos.get(i).getRecurso().getNombre();
            data[3] = arriendos.get(i).getFechaInicio().format(formato);
            data[4] = arriendos.get(i).getFechaFin().format(formato);
            data[5] = arriendos.get(i).getCosto();
            model.addRow(data);
        }
        tabla.setModel(model);
    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

    public void setUsuActual(Usuario usuActual) {
        this.usuActual = usuActual;
    }

}
