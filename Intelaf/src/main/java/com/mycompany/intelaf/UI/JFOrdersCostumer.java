/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.UI;

import com.mycompany.intelaf.Backend.ConnectionMysql;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jara
 */
public class JFOrdersCostumer extends javax.swing.JFrame {

    Connection cn = ConnectionMysql.conector();
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    String nit;

    /**
     * Creates new form JFOrdersCostumer
     */
    public JFOrdersCostumer() {
        super("Pedidos realizados por un cliente y en transito");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/logointelaf.png")).getImage());
        initComponents();
        setSize(900, 550);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidosC = new javax.swing.JTable();
        btnEx = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtCliente = new javax.swing.JTextField();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 81, 0));
        jPanel1.setLayout(null);

        tablaPedidosC.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPedidosC);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 62, 840, 370);

        btnEx.setText("Exportar HTML");
        btnEx.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExActionPerformed(evt);
            }
        });
        jPanel1.add(btnEx);
        btnEx.setBounds(360, 440, 190, 27);

        jLabel1.setText("Ingrese el NIT del Cliente");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(170, 20, 180, 19);
        jPanel1.add(txtCliente);
        txtCliente.setBounds(360, 10, 250, 31);

        jCheckBox1.setText("Ver Listado");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(630, 10, 110, 30);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnExActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExActionPerformed
        try {
            generar(model);
        } catch (IOException ex) {
            Logger.getLogger(JFOrderInCome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (txtCliente.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Ingrese el NIT del cliente!");
        } else {
            nit = txtCliente.getText();
            limpiarLista();
            listarOCC();
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEx;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaPedidosC;
    private javax.swing.JTextField txtCliente;
    // End of variables declaration//GEN-END:variables

    private void listarOCC() {
        String sql = "select * from pedido where nit_cliente=? and en_tienda=0;";
        model.setColumnIdentifiers(new Object[]{"ID Pedido", "NIT Cliente", "Fecha", "Total"});
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, nit);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getInt("id_pedido"), rs.getString("nit_cliente"), rs.getDate("fecha_pedido"), rs.getDouble("total")});
            }
            tablaPedidosC.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al ingresar datos a la tabla: " + e);
        }
    }

    public void limpiarLista() {
        model = (DefaultTableModel) tablaPedidosC.getModel();
        int a = tablaPedidosC.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(model.getRowCount() - 1);
        }
    }

    public void generar(DefaultTableModel model) throws IOException {
        FileWriter fichero = new FileWriter("/home/jara/NetBeansProjects/IntelafIPC2/Reporte.html");
        fichero.write("<!DOCTYPE HTML5>");
        fichero.write(" <html>");
        fichero.write("<head>");
        fichero.write("<title>Reportes</title>");
        fichero.write("<meta charset='utf-8'>");
        fichero.write("</head>");
        fichero.write("<body>");
        fichero.write("<h2>Listado de todos los pedidos en curso de un cliente.</h2>");
        fichero.write("<table border='1'>");
        fichero.write("<tr>\n"
                + "\n"
                + "    <th>ID Pedido</th>\n"
                + "\n"
                + "    <th>NIT Cliente</th>\n"
                + "\n"
                + "    <th>Fecha</th>\n"
                + "\n"
                + "    <th>Total</th>\n"
                + "\n"
                + "  </tr>\n");
        for (int i = 0; i < 10; i++) {
        }
        int filas = tablaPedidosC.getRowCount();
        for (int i = 0; i < filas; i++) {
            fichero.write("<tr>");
            int columnas = tablaPedidosC.getColumnCount();
            for (int j = 0; j < columnas; j++) {
                fichero.write("<th>" + tablaPedidosC.getValueAt(i, j) + "</th>");
            }
            fichero.write("</tr>");
        }
        fichero.write("</table>");
        fichero.write("</body>");
        fichero.write("</html>");
        fichero.close();
    }
}