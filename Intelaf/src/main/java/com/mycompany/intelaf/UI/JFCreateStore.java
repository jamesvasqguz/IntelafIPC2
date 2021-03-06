/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.UI;

import com.mycompany.intelaf.Backend.ConnectionMysql;
import com.mycompany.intelaf.Backend.Tienda;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.RowFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author jara
 */
public class JFCreateStore extends javax.swing.JFrame {

    /**
     * Creates new form JFCreateStore
     */
    Connection cn = ConnectionMysql.conector();
    PreparedStatement ps;
    Statement st;
    ResultSet rs;
    DefaultTableModel model = new DefaultTableModel();
    TableRowSorter trs;
    String NombreT;
    String DireccionT;
    String CodigoT;
    String TelefonoT1;
    String TelefonoT2;
    String EmailT;
    String HorarioT;

    public JFCreateStore() {
        super("Nueva Tienda");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/logointelaf.png")).getImage());
        initComponents();
        listarTiendas();
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
        txtNombreT = new javax.swing.JTextField();
        txtDireccionT = new javax.swing.JTextField();
        txtCodigoT = new javax.swing.JTextField();
        txtEmailT = new javax.swing.JTextField();
        txtTelefonoT1 = new javax.swing.JTextField();
        txtTelefonoT2 = new javax.swing.JTextField();
        txtHorarioT = new javax.swing.JTextField();
        btnCrearT = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TablaT = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        btnLimpiar = new javax.swing.JButton();
        txtFiltrar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 81, 0));
        jPanel1.setLayout(null);

        jLabel1.setText("Ingrese los datos de la nueva Tienda.");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(100, 20, 270, 19);
        jPanel1.add(txtNombreT);
        txtNombreT.setBounds(10, 70, 210, 31);
        jPanel1.add(txtDireccionT);
        txtDireccionT.setBounds(10, 140, 210, 31);
        jPanel1.add(txtCodigoT);
        txtCodigoT.setBounds(10, 210, 210, 31);
        jPanel1.add(txtEmailT);
        txtEmailT.setBounds(10, 280, 210, 31);
        jPanel1.add(txtTelefonoT1);
        txtTelefonoT1.setBounds(260, 70, 200, 31);
        jPanel1.add(txtTelefonoT2);
        txtTelefonoT2.setBounds(260, 140, 200, 31);
        jPanel1.add(txtHorarioT);
        txtHorarioT.setBounds(260, 210, 200, 31);

        btnCrearT.setText("Crear Tienda");
        btnCrearT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrearTActionPerformed(evt);
            }
        });
        jPanel1.add(btnCrearT);
        btnCrearT.setBounds(260, 270, 90, 60);

        jLabel2.setText("Nombre de la tienda");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(10, 50, 130, 19);

        jLabel3.setText("Direccion");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(10, 120, 170, 19);

        jLabel4.setText("Codigo tienda");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(10, 190, 120, 19);

        jLabel5.setText("Correo Electronico");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(10, 260, 120, 19);

        jLabel6.setText("Tefeno 1");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(260, 50, 100, 19);

        jLabel7.setText("Telefono 2");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(260, 120, 66, 19);

        jLabel8.setText("Horario(Ejemplo: 07:00-18:00)");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(260, 190, 200, 19);

        jLabel9.setText("Listar las Tiendas existentes");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(510, 20, 220, 19);

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);

        TablaT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(TablaT);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(490, 50, 790, 290);

        jLabel10.setText("Filtrar Tabla");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(490, 360, 80, 19);

        btnLimpiar.setText("Limpiar");
        btnLimpiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimpiarActionPerformed(evt);
            }
        });
        jPanel1.add(btnLimpiar);
        btnLimpiar.setBounds(370, 270, 90, 60);

        txtFiltrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtFiltrarActionPerformed(evt);
            }
        });
        txtFiltrar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtFiltrarKeyTyped(evt);
            }
        });
        jPanel1.add(txtFiltrar);
        txtFiltrar.setBounds(580, 360, 190, 31);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1300, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrearTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrearTActionPerformed
        NombreT = txtNombreT.getText().trim();
        DireccionT = txtDireccionT.getText().trim();
        CodigoT = txtCodigoT.getText().trim();
        TelefonoT1 = txtTelefonoT1.getText().trim();
        TelefonoT2 = txtTelefonoT2.getText().trim();
        EmailT = txtEmailT.getText().trim();
        HorarioT = txtHorarioT.getText().trim();

        if (txtNombreT.getText().isEmpty() || txtCodigoT.getText().isEmpty() || txtDireccionT.getText().isEmpty() || txtTelefonoT1.getText().isEmpty()) {
            System.out.println("Debe de llenar los datos requeridos");
        } else {
            Tienda t = new Tienda(CodigoT, NombreT, DireccionT, TelefonoT1, TelefonoT2, EmailT, HorarioT);

            String sql = "SELECT id_tienda FROM tienda WHERE id_tienda=? ";
            try {
                ps = cn.prepareStatement(sql);
                ps.setString(1, t.getId_tienda());
                rs = ps.executeQuery();
                if (rs.next()) {
                    JOptionPane.showMessageDialog(null, "No puedes crear una tienda existente: " + rs.getString("id_tienda"));
                } else {
                    String sql1 = "INSERT INTO tienda VALUES(?,?,?,?,?,?,?)";
                    try {
                        ps = cn.prepareStatement(sql1);
                        ps.setString(1, t.getId_tienda());
                        ps.setString(2, t.getNombre());
                        ps.setString(3, t.getDireccion());
                        ps.setString(4, t.getTelefono_1());
                        ps.setString(5, t.getTelefono_2());
                        ps.setString(6, t.getEmail());
                        ps.setString(7, t.getHorario());
                        ps.executeUpdate();
                        JOptionPane.showMessageDialog(null, "Tienda creada con exito!");
                        limpiarLista();
                        listarTiendas();
                    } catch (SQLException e) {
                        JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                    }

                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "Error al verificar si existe el registro escrito en tienda");
            }
        }
    }//GEN-LAST:event_btnCrearTActionPerformed

    private void btnLimpiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimpiarActionPerformed
        txtNombreT.setText("");
        txtDireccionT.setText("");
        txtCodigoT.setText("");
        txtTelefonoT1.setText("");
        txtTelefonoT2.setText("");
        txtEmailT.setText("");
        txtHorarioT.setText("");
    }//GEN-LAST:event_btnLimpiarActionPerformed

    private void txtFiltrarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtFiltrarKeyTyped

        txtFiltrar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent ky) {
                trs.setRowFilter(RowFilter.regexFilter("(?i)" + txtFiltrar.getText(), 0, 1));
            }
        });
        trs = new TableRowSorter(model);
        TablaT.setRowSorter(trs);
    }//GEN-LAST:event_txtFiltrarKeyTyped

    private void txtFiltrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtFiltrarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtFiltrarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable TablaT;
    private javax.swing.JButton btnCrearT;
    private javax.swing.JButton btnLimpiar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField txtCodigoT;
    private javax.swing.JTextField txtDireccionT;
    private javax.swing.JTextField txtEmailT;
    private javax.swing.JTextField txtFiltrar;
    private javax.swing.JTextField txtHorarioT;
    private javax.swing.JTextField txtNombreT;
    private javax.swing.JTextField txtTelefonoT1;
    private javax.swing.JTextField txtTelefonoT2;
    // End of variables declaration//GEN-END:variables

    private void listarTiendas() {
        String sql = "SELECT id_tienda, nombre, direccion,telefono_1,telefono_2,email,horario FROM tienda";
        rs = getTable(sql);
        model.setColumnIdentifiers(new Object[]{"ID", "Nombre", "Direccion", "Telefono 1", "Telefono 2", "Email", "Horario"});
        try {
            while (rs.next()) {
                model.addRow(new Object[]{rs.getString("id_tienda"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono_1"), rs.getString("telefono_2"), rs.getString("email"), rs.getString("horario")});
            }
            TablaT.setModel(model);
        } catch (SQLException e) {
            System.out.println("Error al ingresar datos a la tabla: " + e);
        }

    }

    public ResultSet getTable(String consulta) {
        try {
            st = cn.createStatement();
            rs = st.executeQuery(consulta);
        } catch (SQLException e) {
            System.out.println("Error al obtener datos para la tabla: " + e);
        }
        return rs;
    }

    public void limpiarLista() {
        model = (DefaultTableModel) TablaT.getModel();
        int a = TablaT.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(model.getRowCount() - 1);
        }
    }
}
