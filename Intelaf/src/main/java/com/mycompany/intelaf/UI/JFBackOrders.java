/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.UI;

import com.mycompany.intelaf.Backend.ConnectionMysql;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.ImageIcon;
import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jara
 */
public class JFBackOrders extends javax.swing.JFrame {
    Connection cn = ConnectionMysql.conector();
    PreparedStatement ps;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    String tienda;

    /**
     * Creates new form JFBackOrders
     */
    public JFBackOrders() {
        super("Pedidos Atrasados");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/logointelaf.png")).getImage());
        initComponents();
        setSize(900,500);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        tienda = JFChooseStore.TiendaSelect;
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
        jLabel1 = new javax.swing.JLabel();
        txtFecha = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnEx = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 81, 0));
        jPanel1.setLayout(null);

        jLabel1.setText("Ingresar Fecha: ");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(120, 20, 130, 19);
        jPanel1.add(txtFecha);
        txtFecha.setBounds(270, 20, 230, 31);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(40, 80, 820, 360);

        btnEx.setText("Exportar HTML ");
        jPanel1.add(btnEx);
        btnEx.setBounds(280, 450, 250, 27);

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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEx;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField txtFecha;
    // End of variables declaration//GEN-END:variables
public int DiasTardados(int dia, int mes, int anio) {
        int dias = 0;

        Calendar FechaSalida = Calendar.getInstance();
        FechaSalida.set(anio, mes - 1, dia);
        FechaSalida.set(Calendar.HOUR, 0);
        FechaSalida.set(Calendar.HOUR_OF_DAY, 0);
        FechaSalida.set(Calendar.MINUTE, 0);
        FechaSalida.set(Calendar.SECOND, 0);

        String FechaActual = txtFecha.getText();
        String[] fechaSeparada = FechaActual.split("/");
        int diaS = Integer.parseInt(fechaSeparada[0]);
        int mesS = Integer.parseInt(fechaSeparada[1]);
        int anioS = Integer.parseInt(fechaSeparada[2]);
        Calendar FechaHoy = Calendar.getInstance();
        FechaHoy.set(anioS, mesS - 1, diaS);
        FechaHoy.set(Calendar.HOUR, 0);
        FechaHoy.set(Calendar.HOUR_OF_DAY, 0);
        FechaHoy.set(Calendar.MINUTE, 0);
        FechaHoy.set(Calendar.SECOND, 0);

        long finMS = FechaHoy.getTimeInMillis();
        long inicioMS = FechaSalida.getTimeInMillis();

        dias = (int) ((finMS - inicioMS) / (1000 * 60 * 60 * 24));
        return dias;
    }

}
