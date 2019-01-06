package proyecto;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ArrendarLibro extends JFrame implements ActionListener {

    private Tienda tienda;
    private JTable tabla;
    private DefaultTableModel model;
    private JPanel panelSur;

    private JButton btnArrendar;
    private JButton btnVolver;

    public ArrendarLibro() {
        
        this.setLayout(new BorderLayout());
        this.setSize(400, 400);

        String titulos[] = {"CODIGO", "NOMBRE", "AUTOR", "PRESTADO"};
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
        this.setTitle("Libros");
        this.add(panelSur, BorderLayout.SOUTH);
        this.add(scrollPane, BorderLayout.CENTER);

        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
     

    public void setInformacion() {
        model.setRowCount(0);
        List<Libro> libros = tienda.getLibros();
        for (int i = 0; i < libros.size(); i++) {
            Object[] data = new Object[4];
            data[0] = libros.get(i).getCodigo();
            data[1] = libros.get(i).getNombre();
            data[2] = libros.get(i).getAutor();
            data[3] = libros.get(i).isPrestado();
            model.addRow(data);
           
        }
        tabla.setModel(model);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getActionCommand().equals("arrendar")) {
            
        } else if (ae.getActionCommand().equals("volver")) {
            tienda.setVisible(true);
            this.setVisible(false);            
        }

    }

    public void setTienda(Tienda tienda) {
        this.tienda = tienda;
    }

}
