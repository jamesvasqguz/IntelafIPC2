/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.UI;

import com.mycompany.intelaf.Backend.ConnectionMysql;
import com.mycompany.intelaf.Backend.Contiene;
import com.mycompany.intelaf.Backend.Pedido;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author jara
 */
public class JFOrder extends javax.swing.JFrame {

    static Connection cn = ConnectionMysql.conector();
    static PreparedStatement ps = null;
    static ResultSet rs = null;
    ArrayList<String> tienda = new ArrayList<String>();
    ArrayList<String> productos = new ArrayList<String>();
    DefaultTableModel model = new DefaultTableModel();
    //
    public static int idPedido;
    String tiendaO;
    String tiendaD;
    String nit;
    String fecha;
    String producto;
    static int cantidad;
    static int cantidadDisponible;
    int cantidadEnTienda;
    int nuevaCantidad;
    double total = 0;
    double subTotal;
    double anticipo;
    double creditoA;
    double nuevoCredito;
    double creditoPago;
    double efectivoPago;
    double precioPdt;

    /**
     * Creates new form JFOrder
     */
    public JFOrder() {
        super("Ordenar Pedido");
        this.setIconImage(new ImageIcon(getClass().getResource("/Images/logointelaf.png")).getImage());
        initComponents();
        setSize(1300, 680);
        //
        tiendaD = JFChooseStore.TiendaSelect;
        txtTiendaA.setText(tiendaD);
        txtTiendaA.setEditable(false);
        //
        txtPrecio.setEditable(false);
        //
        tienda = obtenerTienda();
        for (int i = 0; i < tienda.size(); i++) {
            comboTiendas.addItem(tienda.get(i));
        }
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Sub_Total");
        tablaPedidos.setModel(model);
        /*
        
        }*/
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
        comboTiendas = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTiendaA = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        txtNit = new javax.swing.JTextField();
        txtCreditoDis = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        txtAnticipo = new javax.swing.JTextField();
        txtFechaP = new javax.swing.JTextField();
        txtPrecio = new javax.swing.JTextField();
        txtPagoE = new javax.swing.JTextField();
        btnFinalizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaPedidos = new javax.swing.JTable();
        btnAgregar = new javax.swing.JButton();
        comboP = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txtCantD = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();
        jLabel6 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();
        txtPagoCredito = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 81, 0));
        jPanel1.setLayout(null);

        jLabel1.setText("Para realizar su pedido llene los campo siguientes");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(180, 10, 310, 19);

        comboTiendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboTiendasActionPerformed(evt);
            }
        });
        jPanel1.add(comboTiendas);
        comboTiendas.setBounds(330, 60, 240, 31);

        jLabel2.setText("Seleccione la tienda que envia");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(330, 40, 200, 19);

        jLabel3.setText("<html><b><u>S</u> e le cobrara el 25% total de </b><br><b> la comprar para garantizar el pedido.</b></html>");
        jLabel3.setEnabled(false);
        jPanel1.add(jLabel3);
        jLabel3.setBounds(480, 440, 190, 60);

        jLabel4.setText("Precio");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(330, 180, 110, 19);

        jLabel5.setText("Efectivo");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(510, 520, 90, 19);

        jLabel7.setText("NIT *");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(30, 380, 50, 19);

        jLabel8.setText("Fecha(Ejem. año-mes-dia) *");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(30, 520, 190, 19);

        jLabel9.setText("Tienda Actual");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(30, 40, 110, 19);
        jPanel1.add(txtTiendaA);
        txtTiendaA.setBounds(30, 60, 190, 31);

        jLabel11.setText("Producto");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(330, 110, 110, 19);

        jLabel12.setText(" Cantidad Deseada *");
        jPanel1.add(jLabel12);
        jLabel12.setBounds(30, 180, 140, 19);
        jPanel1.add(txtCantidad);
        txtCantidad.setBounds(30, 200, 190, 31);

        txtNit.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtNitMouseClicked(evt);
            }
        });
        jPanel1.add(txtNit);
        txtNit.setBounds(30, 400, 190, 31);
        jPanel1.add(txtCreditoDis);
        txtCreditoDis.setBounds(30, 470, 190, 31);

        jLabel13.setText("Anticipo");
        jPanel1.add(jLabel13);
        jLabel13.setBounds(330, 450, 60, 20);
        jPanel1.add(txtAnticipo);
        txtAnticipo.setBounds(330, 470, 140, 31);
        jPanel1.add(txtFechaP);
        txtFechaP.setBounds(30, 540, 190, 31);
        jPanel1.add(txtPrecio);
        txtPrecio.setBounds(330, 200, 140, 31);
        jPanel1.add(txtPagoE);
        txtPagoE.setBounds(500, 540, 140, 31);

        btnFinalizar.setText("Finalizar Pedido");
        btnFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFinalizarActionPerformed(evt);
            }
        });
        jPanel1.add(btnFinalizar);
        btnFinalizar.setBounds(200, 590, 140, 40);

        tablaPedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tablaPedidos);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(630, 40, 560, 402);

        btnAgregar.setText("Agregar al Pedido");
        btnAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarActionPerformed(evt);
            }
        });
        jPanel1.add(btnAgregar);
        btnAgregar.setBounds(160, 260, 230, 40);

        comboP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboPActionPerformed(evt);
            }
        });
        jPanel1.add(comboP);
        comboP.setBounds(330, 130, 240, 31);

        jLabel10.setText("Cantidad Disponible");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(30, 110, 130, 19);
        jPanel1.add(txtCantD);
        txtCantD.setBounds(30, 130, 190, 31);

        jLabel14.setText("Cuando termine de agregar los articulos finalize el pedido, llenando los siguientes campos.");
        jPanel1.add(jLabel14);
        jLabel14.setBounds(30, 360, 560, 19);

        jCheckBox1.setText("Ver Credito Disponible");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });
        jPanel1.add(jCheckBox1);
        jCheckBox1.setBounds(30, 440, 170, 21);

        jLabel6.setText("Total *");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(330, 380, 60, 19);
        jPanel1.add(txtTotal);
        txtTotal.setBounds(330, 400, 140, 31);
        jPanel1.add(txtPagoCredito);
        txtPagoCredito.setBounds(330, 540, 140, 31);

        jLabel15.setText("Pagar con Credito");
        jPanel1.add(jLabel15);
        jLabel15.setBounds(330, 520, 120, 19);

        jButton1.setText("Regresar ");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(360, 590, 140, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1200, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 650, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        if (txtNit.getText().isEmpty()) {
            txtNit.setText("");
        } else {
            nit = txtNit.getText();
            creditoActual();
            txtNit.setEditable(false);
        }
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private void comboPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboPActionPerformed
        if (comboP.getItemCount() != 0) {
            producto = String.valueOf(comboP.getSelectedItem().toString());
            checarCantidad();
            txtCantD.setEditable(false);
        }
    }//GEN-LAST:event_comboPActionPerformed

    private void btnAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarActionPerformed
        if (txtCantidad.getText().isEmpty() || Integer.parseInt(txtCantidad.getText()) > Integer.parseInt(txtCantD.getText())) {
            JOptionPane.showMessageDialog(null, "Ingresar la cantidad que desea pedir o La cantidad que ingreso es mayor a la disponible!");
        } else {
            comboTiendas.setEnabled(false);
            precioProducto();
            txtPrecio.setText(String.valueOf(precioPdt));
            System.out.println("precio: " + precioPdt);

            cantidad = Integer.parseInt(txtCantidad.getText());
            System.out.println("cantidad: " + cantidad);

            subTotal = precioPdt * cantidad;
            System.out.println("suma: " + subTotal);
            agregar();
            sumar();
            total = Double.parseDouble(txtTotal.getText());
            anticipo = total * (0.25);
            txtAnticipo.setText(String.valueOf(anticipo));
        }
    }//GEN-LAST:event_btnAgregarActionPerformed

    private void btnFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFinalizarActionPerformed
        if (txtNit.getText().isEmpty() || txtFechaP.getText().isEmpty() || txtAnticipo.getText().isEmpty() || txtTotal.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe de llenar los campos obligatorios");
        } else {
            if (Double.parseDouble(txtPagoCredito.getText()) > Double.parseDouble(txtCreditoDis.getText())) {
                JOptionPane.showMessageDialog(null, "No puede ingresar el una cantidad mayor a la que tiene disponible!");
            } else {
                creditoPago = Double.parseDouble(txtPagoCredito.getText());
                efectivoPago = anticipo - creditoPago;
                txtPagoE.setText(String.valueOf(efectivoPago));
                fecha = txtFechaP.getText();
                actualizarCredito();
                hacerPedido();
            }

        }
        /*

        System.out.println("Anticipo: " + anticipo);
        hacerPedido();
         */
    }//GEN-LAST:event_btnFinalizarActionPerformed

    private void txtNitMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtNitMouseClicked

    }//GEN-LAST:event_txtNitMouseClicked

    private void comboTiendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboTiendasActionPerformed
        tiendaO = String.valueOf(comboTiendas.getSelectedItem());
        comboP.removeAllItems();
        productos = obtenerProducto();
        for (int i = 0; i < productos.size(); i++) {
            comboP.addItem(productos.get(i));
        }
    }//GEN-LAST:event_comboTiendasActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregar;
    private javax.swing.JButton btnFinalizar;
    private javax.swing.JComboBox<String> comboP;
    private javax.swing.JComboBox<String> comboTiendas;
    private javax.swing.JButton jButton1;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
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
    private javax.swing.JTable tablaPedidos;
    private javax.swing.JTextField txtAnticipo;
    private javax.swing.JTextField txtCantD;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtCreditoDis;
    private javax.swing.JTextField txtFechaP;
    private javax.swing.JTextField txtNit;
    private javax.swing.JTextField txtPagoCredito;
    private javax.swing.JTextField txtPagoE;
    private javax.swing.JTextField txtPrecio;
    private javax.swing.JTextField txtTiendaA;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
private ArrayList<String> obtenerTienda() {
        ArrayList<String> lista = new ArrayList<String>();
        String sql = "SELECT id_tienda FROM tienda WHERE id_tienda<>?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, JFChooseStore.TiendaSelect);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista.add(rs.getString("id_tienda"));
            }
            JOptionPane.showMessageDialog(null, "Listado de las tiendas: " + lista);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las tiendas: " + e);
        }
        return lista;
    }

    private ArrayList<String> obtenerProducto() {
        ArrayList<String> lista1 = new ArrayList<String>();
        String sql = "SELECT producto FROM suministra WHERE tienda=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, tiendaO);
            rs = ps.executeQuery();
            while (rs.next()) {
                lista1.add(rs.getString("producto"));
            }
            JOptionPane.showMessageDialog(null, "Listado de las tiendas: " + lista1);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudieron obtener las tiendas: " + e);
        }
        return lista1;
    }

    private void checarCantidad() {
        String sql = "SELECT cantidad_tienda FROM suministra WHERE tienda=? AND producto=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setString(1, tiendaO);
            ps.setString(2, producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                cantidadDisponible = rs.getInt("cantidad_tienda");
                txtCantD.setText(String.valueOf(cantidadDisponible));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se puede obtener la cantidad de la tienda seleccionada");
        }
    }

    /*public void tiempoET() {
        String sql1 = "SELECT tiempo_pedido FROM tiempo WHERE (tienda_1=? AND tienda_2=?) OR (tienda_2=? AND tienda_1=?)";
        try {
            ps = cn.prepareStatement(sql1);
            ps.setString(1, tiendaO);
            ps.setString(2, tiendaD);
            ps.setString(3, tiendaD);
            ps.setString(4, tiendaO);
            rs = ps.executeQuery();
            if (rs.next()) {
                tiempoET = rs.getInt("tiempo_pedido");
                txtTET.setText(String.valueOf(tiempoET));
            } else {
                JOptionPane.showMessageDialog(null, "No hay tiempo: ");
            }
        } catch (SQLException e) {
        }
    }*/
    private void creditoActual() {
        String sql1 = "SELECT credito FROM cliente WHERE nit=? ";
        try {
            ps = cn.prepareStatement(sql1);
            ps.setString(1, nit);
            rs = ps.executeQuery();
            if (rs.next()) {
                creditoA = rs.getDouble("credito");
                txtCreditoDis.setText(String.valueOf(creditoA));
            } else {
                JOptionPane.showMessageDialog(null, "No se encontro credito del cliente");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al intentar obtener el credito del cliente");
        }
    }

    private void actualizarCredito() {
        nuevoCredito = creditoA - creditoPago;
        String sql = "UPDATE cliente SET credito=? WHERE nit=?";
        try {
            ps = cn.prepareStatement(sql);
            ps.setDouble(1, nuevoCredito);
            ps.setString(2, nit);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Se actualizo el credito del cliente");

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Fallo al intentar actualizar el credito del cliente");
        }
    }

    private void precioProducto() {
        String sql1 = "SELECT precio FROM producto WHERE codigo_producto=?";
        try {
            ps = cn.prepareStatement(sql1);
            ps.setString(1, producto);
            rs = ps.executeQuery();
            if (rs.next()) {
                precioPdt = rs.getDouble("precio");
                JOptionPane.showMessageDialog(null, "SE ENCONTRO EL PRECIO DEL PRODUCTO: " + precioPdt);
            } else {
                JOptionPane.showMessageDialog(null, "NO SE ENCONTRO EL PRECIO DEL PRODUCTO");
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "FALLO AL INTENTAR OBTENER EL PRECIO" + e);
        }

    }

    private void agregar() {
        String arreglo[] = new String[3];
        arreglo[0] = producto;
        arreglo[1] = String.valueOf(cantidad);
        arreglo[2] = String.valueOf(subTotal);
        model.addRow(arreglo);
    }

    private double sumar() {
        int column = tablaPedidos.getRowCount();
        double sum = 0;
        for (int i = 0; i < column; i++) {
            sum += Double.valueOf((tablaPedidos.getValueAt(i, 2).toString()));
        }
        txtTotal.setText(String.valueOf(sum));
        return sum;
    }

    public void hacerPedido() {
        Pedido pedido = new Pedido(0, nit, fecha, tiendaO, tiendaD, true, total, anticipo, false);
        String sql = "INSERT INTO pedido VALUES(?,?,?,?,?,?,?,?,?)";
        try {
            ps = cn.prepareStatement(sql);
            ps.setInt(1, pedido.getPedido());
            ps.setString(2, pedido.getClienteP());
            ps.setDate(3, Date.valueOf(pedido.getFechaP()));
            ps.setString(4, pedido.getTiendaPO());
            ps.setString(5, pedido.getTiendaPD());
            ps.setBoolean(6, pedido.isaTiempo());
            ps.setDouble(7, pedido.getTotal());
            ps.setDouble(8, pedido.getPagoAnt());
            ps.setBoolean(9, pedido.isEnTienda());
            ps.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Error al ingresar los archivos de pedido en la base de datos: " + e);
            JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
        }

        String sql2 = "SELECT id_pedido FROM pedido WHERE nit_cliente=? AND fecha_pedido=? AND tienda_origen=? AND tienda_destino=?";
        try {
            ps = cn.prepareStatement(sql2);
            ps.setString(1, pedido.getClienteP());
            ps.setDate(2, Date.valueOf(pedido.getFechaP()));
            ps.setString(3, pedido.getTiendaPO());
            ps.setString(4, pedido.getTiendaPD());
            rs = ps.executeQuery();
            if (rs.next()) {
                idPedido = rs.getInt("id_pedido");
                JOptionPane.showMessageDialog(null, "Pedido numero: "+idPedido);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ID Pedido del cliente: " + idPedido);
        }

        int fila = model.getRowCount();
        String pdct;
        String cnt;
        String sm;
        for (int i = 0; i < fila; i++) {
            pdct = (String)model.getValueAt(i, 0);
            JOptionPane.showMessageDialog(null, "producto: "+pdct);
            cnt = (String)model.getValueAt(i, 1);
            JOptionPane.showMessageDialog(null, "cantidad: "+cnt);
            sm = (String) model.getValueAt(i, 2);          
            JOptionPane.showMessageDialog(null, "suma: "+sm);
            
            Contiene contiene = new Contiene(0, pdct, idPedido, Integer.parseInt(cnt), Double.parseDouble(sm));
            String sql3 = "INSERT INTO contiene VALUES(?,?,?,?,?)";
            try {
                ps = cn.prepareStatement(sql3);
                ps.setInt(1, 0);
                ps.setString(2, contiene.getProductoCont());
                ps.setInt(3, contiene.getPedidoCont());
                ps.setInt(4, contiene.getCantidadCont());
                ps.setDouble(5, contiene.getSumaCont());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
            }
            String sql5="SELECT cantidad_tienda FROM suministra WHERE tienda=? AND producto=?";
            try {
                ps = cn.prepareStatement(sql5);
                ps.setString(1, pedido.getTiendaPO());
                ps.setString(2, pdct);
                rs = ps.executeQuery();
                if (rs.next()) {
                    cantidadEnTienda = rs.getInt("cantidad_tienda");
                    JOptionPane.showMessageDialog(null, "Cantidad del producto: "+cantidadEnTienda);
                    JOptionPane.showMessageDialog(null, "Tienda del producto: "+pedido.getTiendaPO());
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, "No se puede obtener la cantidad actual en tienda");
            }
            String sql4 = "UPDATE suministra SET cantidad_tienda=? WHERE tienda=? AND producto=?";
            nuevaCantidad = cantidadEnTienda - Integer.parseInt(cnt);
            System.out.println("Nueva cantidad: " + nuevaCantidad);
            try {
                ps = cn.prepareStatement(sql4);
                ps.setInt(1, nuevaCantidad);
                ps.setString(2, pedido.getTiendaPO());
                ps.setString(3, contiene.getProductoCont());
                ps.executeUpdate();
            } catch (SQLException e) {
                System.out.println("Error al actualizar los productos de cierta tienda: " + e);
            }
            JOptionPane.showMessageDialog(null, "Tienda donde se extra los articulos: "+pedido.getTiendaPO());
        }
    }
}
