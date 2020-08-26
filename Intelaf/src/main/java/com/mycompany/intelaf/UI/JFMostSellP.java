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
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jara
 */
public class JFMostSellP extends javax.swing.JFrame {

    Connection cn = ConnectionMysql.conector();
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();

    /**
     * Creates new form JFMostSellP
     */
    public JFMostSellP() {
        super("10 Productos Mas Vendidos!");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/logointelaf.png")).getImage());
        initComponents();
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        listarMP();
        initComponents();
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
        tablaM = new javax.swing.JTable();
        btnExp = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setLayout(null);

        tablaM.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaM);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(50, 30, 810, 390);

        btnExp.setText("Exportar HTML");
        btnExp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExpActionPerformed(evt);
            }
        });
        jPanel1.add(btnExp);
        btnExp.setBounds(380, 450, 130, 27);

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

    private void btnExpActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExpActionPerformed
        try {
            generar(model);
        } catch (IOException ex) {
            Logger.getLogger(JFOrderInCome.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btnExpActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnExp;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaM;
    // End of variables declaration//GEN-END:variables
    private void listarMP() {
        String sql = "SELECT cantidad_venta, codigo_producto from venta GROUP BY cantidad_venta ORDER BY cantidad_venta LIMIT 10";
        model.setColumnIdentifiers(new Object[]{"Producto", "Cantidad"});
        try {
            ps = cn.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("codigo_producto"), rs.getInt("cantidad_venta")});
            }
            tablaM.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al ingresar datos a la tabla: " + e);
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
        fichero.write("<h2>Listado de los diez productos más vendidos en un intervalo de tiempo.</h2>");
        fichero.write("<table border='1'>");
        fichero.write("<tr>\n"
                + "\n"
                + "    <th>Producto</th>\n"
                + "\n"
                + "    <th>Cantidad</th>\n"
                + "\n"
                + "  </tr>\n");

        for (int i = 0; i < 10; i++) {
        }
        int filas = tablaM.getRowCount();
        for (int i = 0; i < filas; i++) {
            fichero.write("<tr>");
            int columnas = tablaM.getColumnCount();
            for (int j = 0; j < columnas; j++) {
                fichero.write("<th>" + tablaM.getValueAt(i, j) + "</th>");
            }
            fichero.write("</tr>");
        }
        fichero.write("</table>");
        fichero.write("</body>");
        fichero.write("</html>");
        fichero.close();
    }
}
