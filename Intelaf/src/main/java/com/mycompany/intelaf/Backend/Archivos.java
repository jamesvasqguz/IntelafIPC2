/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.Backend;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author jara
 */
public class Archivos {

    Connection cn = ConnectionMysql.conector();
    File subirArchivo = null;
    FileReader fr = null;
    BufferedReader br = null;
    ArrayList cadenaTxt = new ArrayList();
    String tmp = "";
    String errores = "";
    PreparedStatement ps = null;
    ResultSet rs = null;
    int nuevaCantidadProducto;
    int cantidadActual;
    double suma;
    double precioPedido;

    public String subirTxt() {

        javax.swing.JFileChooser jfc = new javax.swing.JFileChooser();
        jfc.showOpenDialog(jfc);
        String path = jfc.getSelectedFile().getAbsolutePath();
        subirArchivo = new File(path);
        try {
            fr = new FileReader(subirArchivo);
            br = new BufferedReader(fr);

            while ((tmp = br.readLine()) != null) {
                cadenaTxt.add(tmp);
            }
            fr.close();

            for (int i = 0; i < cadenaTxt.size(); i++) {
                System.out.println("i: " + i);

                String linea = String.valueOf(cadenaTxt.get(i));
                System.out.println("Linea: " + linea);

                String[] arreglo = linea.split(",");
                System.out.println("Arreglo: " + arreglo[0]);

                if (linea.contains(",,") || linea.contains(", ,")) {
                    System.out.println("Este registro tiene error");
                    errores = linea + "\n" + errores;
                } else {
                    switch (arreglo[0]) {

                        case "TIENDA":
                            System.out.println("Arreglo Inicio: " + arreglo[0]);
                            String nombreTienda = arreglo[1];
                            String direccionTienda = arreglo[2];
                            String codigoTienda = arreglo[3];
                            String telefono1 = arreglo[4];

                            Tienda t = new Tienda(codigoTienda, nombreTienda, direccionTienda, telefono1, "", "", "");

                            System.out.println("nombre: " + nombreTienda + " direccion: "
                                    + direccionTienda + " codigo: " + codigoTienda + " telefono: " + telefono1);

                            String sql1 = "INSERT INTO tienda(id_tienda,nombre,direccion,telefono_1) VALUES(?,?,?,?)";
                            try {

                                ps = cn.prepareStatement(sql1);
                                ps.setString(1, t.getId_tienda());
                                ps.setString(2, t.getNombre());
                                ps.setString(3, t.getDireccion());
                                ps.setString(4, t.getTelefono_1());
                                ps.executeUpdate();
                            } catch (SQLException e) {
                                System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                            }
                            break;

                        case "TIEMPO":
                            String tienda1 = arreglo[1];
                            String tienda2 = arreglo[2];
                            int tiempoPedido = Integer.parseInt(arreglo[3]);

                            Tiempo tiempo = new Tiempo(0, tienda1, tienda2, tiempoPedido);

                            System.out.println("tienda origen: " + tienda1 + " tiendadestino: " + tienda2 + " tiempo en llegar: " + tiempoPedido);

                            String sql2 = "INSERT INTO tiempo VALUES(?,?,?,?)";
                            try {
                                ps = cn.prepareStatement(sql2);
                                ps.setInt(1, 0);
                                ps.setString(2, tiempo.getTienda1());
                                ps.setString(3, tiempo.getTienda2());
                                ps.setInt(4, tiempo.getTiempoPedido());
                                ps.executeUpdate();
                            } catch (SQLException e) {
                                System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                            }
                            break;

                        case "CLIENTE":
                            String nombreCliente = arreglo[1];
                            String nitCliente = arreglo[2];
                            String telefonoCliente = arreglo[3];
                            double creditoCliente = Double.parseDouble(arreglo[4]);

                            Cliente c = new Cliente(0, nombreCliente, nitCliente, telefonoCliente, "", creditoCliente, "", "");

                            System.out.println("nombreCliente: " + nombreCliente + " nitCliente: " + nitCliente + " telefonoCliente: " + telefonoCliente + " creditoCliente: " + creditoCliente);

                            String sql3 = "INSERT INTO cliente (id_cliente,nombre,nit,telefono,credito) VALUES(?,?,?,?,?)";
                            try {
                                ps = cn.prepareStatement(sql3);
                                ps.setInt(1, 0);
                                ps.setString(2, c.getNombreC());
                                ps.setString(3, c.getNitC());
                                ps.setString(4, c.getTelefono());
                                ps.setDouble(5, c.getCreditoC());
                                ps.executeUpdate();
                            } catch (SQLException e) {
                                System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                            }
                            break;

                        case "EMPLEADO":

                            String nombreEmpleado = arreglo[1];
                            String idEmpleado = arreglo[2];
                            String telefonoEmpleado = arreglo[3];
                            String dpiEmpleado = arreglo[4];

                            System.out.println("nombreEmpleado: " + nombreEmpleado + " idEmpleado: " + idEmpleado + " telefonoEmpleado: " + telefonoEmpleado + " dpiEmpleado: " + dpiEmpleado);

                            Empleado empleado = new Empleado(idEmpleado, nombreEmpleado, dpiEmpleado, "", "", "", telefonoEmpleado);

                            String sql4 = "INSERT INTO empleado VALUES(?,?,?,?,?,?,?)";
                            try {
                                ps = cn.prepareStatement(sql4);
                                ps.setString(1, empleado.getIdEmpleado());
                                ps.setString(2, empleado.getNombreEmpleado());
                                ps.setString(3, empleado.getDpiEmpleado());
                                ps.setString(4, "");
                                ps.setString(5, "");
                                ps.setString(6, "");
                                ps.setString(7, empleado.getTelefonoE());
                                ps.executeUpdate();
                            } catch (SQLException e) {
                                System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                            }
                            break;

                        case "PRODUCTO":
                            System.out.println("Arreglo Inicio: " + arreglo[0]);

                            String nombreProducto = arreglo[1];
                            String fabricante = arreglo[2];
                            String codigoProducto = arreglo[3];
                            int cantidad = Integer.parseInt(arreglo[4]);
                            double precio = Double.parseDouble(arreglo[5]);
                            String tiendaProducto = arreglo[6];

                            Producto pcto = new Producto(codigoProducto, nombreProducto, fabricante, cantidad, precio, "", 0);
                            Suministra sms = new Suministra(0, tiendaProducto, codigoProducto,nombreProducto , cantidad);

                            System.out.println("nombreProducto: " + nombreProducto + " fabricante: " + fabricante + " codigoProducto: " + codigoProducto + " cantidad: " + cantidad + " precio: " + precio + " tienda: " + tiendaProducto);

                            String sql7 = "SELECT * FROM suministra WHERE producto=?";
                            try {
                                ps = cn.prepareStatement(sql7);
                                ps.setString(1, pcto.getCodigo());
                                rs = ps.executeQuery();
                                if (rs.next()) {
                                    String sql6 = "INSERT INTO suministra VALUES(?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql6);
                                        ps.setInt(1, 0);
                                        ps.setString(2, sms.getTienda());
                                        ps.setString(3, sms.getNombre());
                                        ps.setString(4, sms.getProducto());
                                        ps.setInt(5, sms.getCantidadT());
                                        ps.executeUpdate();
                                    } catch (SQLException e) {
                                        System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                        JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                                    }
                                    break;
                                } else {

                                    String sql5 = "INSERT INTO producto(codigo_producto,nombre,fabricante,cantidad,precio) VALUES(?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql5);
                                        ps.setString(1, pcto.getCodigo());
                                        ps.setString(2, pcto.getNombreP());
                                        ps.setString(3, pcto.getFabricante());
                                        ps.setInt(4, pcto.getCantidad());
                                        ps.setDouble(5, pcto.getPrecio());
                                        ps.executeUpdate();
                                    } catch (SQLException e) {
                                        System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                        JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                                    }

                                    String sql6 = "INSERT INTO suministra VALUES(?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql6);
                                        ps.setInt(1, 0);
                                        ps.setString(2, sms.getTienda());
                                        ps.setString(3, sms.getNombre());
                                        ps.setString(4, sms.getProducto());
                                        ps.setInt(5, sms.getCantidadT());
                                        ps.executeUpdate();
                                    } catch (SQLException e) {
                                        System.out.println("Error al ingresar los archivos en la base de datos: " + e);
                                        JOptionPane.showMessageDialog(null, "Error al insertar archivos!!!!!");
                                    }
                                    break;
                                }

                            } catch (SQLException e) {
                                System.out.println("Error al actualizar los archivos en la Suministra: " + e);
                            }
                            break;

                        case "PEDIDO":
                            int id_pedido = Integer.parseInt(arreglo[1]);
                            String tiendao = arreglo[2];
                            String tiendad = arreglo[3];
                            String fecha = arreglo[4];
                            String cliente = arreglo[5];
                            String producto = arreglo[6];
                            int cantidadPedido = Integer.parseInt(arreglo[7]);
                            double total = Double.parseDouble(arreglo[8]);
                            double anticipo = Double.parseDouble(arreglo[9]);
                            
                            System.out.println(" " + id_pedido + " " + tiendao + " " + tiendad + " " + fecha + " " + cliente + " " + producto + " " + cantidadPedido + " " + total + " " + anticipo);

                            Pedido pedido = new Pedido(id_pedido, cliente, fecha, tiendao, tiendad, true, total, anticipo,false);

                            String sql8 = "SELECT * FROM pedido WHERE id_pedido=?";
                            try {
                                ps = cn.prepareStatement(sql8);
                                ps.setInt(1, pedido.getPedido());
                                rs = ps.executeQuery();
                                if (rs.next()) {

                                    String sql11 = "SELECT precio FROM producto WHERE codigo_producto=?";
                                    try {
                                        ps = cn.prepareStatement(sql11);
                                        ps.setString(1, producto);
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            precioPedido = rs.getDouble("precio");
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("Error al obtener precio del producto: " + e);
                                    }
                                    suma = precioPedido * cantidadPedido;

                                    Contiene contiene = new Contiene(0, producto, id_pedido, cantidadPedido, suma);

                                    String sql10 = "INSERT INTO contiene VALUES(?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql10);
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

                                    String sql12 = "SELECT * FROM suministra WHERE producto=? AND tienda=?";
                                    try {
                                        ps = cn.prepareStatement(sql12);
                                        ps.setString(1, contiene.getProductoCont());
                                        ps.setString(2, pedido.getTiendaPO());
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            cantidadActual = rs.getInt("cantidad_tienda");
                                            System.out.println("cantidad actual: "+cantidadActual+" Cantidad pedido: "+cantidadPedido);
                                            nuevaCantidadProducto = cantidadActual - cantidadPedido;
                                            System.out.println("Nueva cantidad: "+nuevaCantidadProducto);
                                            try {
                                                ps = cn.prepareStatement("UPDATE suministra SET cantidad_tienda=? WHERE tienda=? AND producto=?");
                                                ps.setInt(1, nuevaCantidadProducto);
                                                ps.setString(2, pedido.getTiendaPO());
                                                ps.setString(3, contiene.getProductoCont());
                                                ps.executeUpdate();
                                            } catch (SQLException e) {
                                                System.out.println("Error al actualizar los productos de cierta tienda: " + e);
                                            }
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("Error al actualizar los archivos en la Suministra: " + e);
                                    }
                                    break;
                                } else {
                                    String sql9 = "INSERT INTO pedido VALUES(?,?,?,?,?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql9);
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

                                    String sql11 = "SELECT precio FROM producto WHERE codigo_producto=?";
                                    try {
                                        ps = cn.prepareStatement(sql11);
                                        ps.setString(1, producto);
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            precioPedido = rs.getDouble("precio");
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("Error al obtener precio del producto: " + e);
                                    }
                                    suma = precioPedido * cantidadPedido;

                                    Contiene contiene = new Contiene(0, producto, id_pedido, cantidadPedido, suma);

                                    String sql10 = "INSERT INTO contiene VALUES(?,?,?,?,?)";
                                    try {
                                        ps = cn.prepareStatement(sql10);
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

                                    String sql12 = "SELECT cantidad_tienda FROM suministra WHERE producto=? AND tienda=?";
                                    try {
                                        ps = cn.prepareStatement(sql12);
                                        ps.setString(1, contiene.getProductoCont());
                                        ps.setString(2, pedido.getTiendaPO());
                                        rs = ps.executeQuery();
                                        if (rs.next()) {
                                            cantidadActual = rs.getInt("cantidad_tienda");
                                            System.out.println("cantidad actual: "+cantidadActual+" Cantidad pedido: "+cantidadPedido);
                                            nuevaCantidadProducto = cantidadActual - cantidadPedido;
                                            System.out.println("Nueva cantidad: "+nuevaCantidadProducto);
                                            try {
                                                ps = cn.prepareStatement("UPDATE suministra SET cantidad_tienda=? WHERE tienda=? AND producto=?");
                                                ps.setInt(1, nuevaCantidadProducto);
                                                ps.setString(2, pedido.getTiendaPO());
                                                ps.setString(3, contiene.getProductoCont());
                                                ps.executeUpdate();
                                            } catch (SQLException e) {
                                                System.out.println("Error al actualizar los productos de cierta tienda: " + e);
                                            }
                                        }
                                    } catch (SQLException e) {
                                        System.out.println("Error al actualizar los archivos en la Suministra: " + e);
                                    }
                                    break;
                                }
                            } catch (SQLException e) {
                                System.out.println("Error al ver si hay registros de pedido: " + e);
                            }
                            break;

                        default:
                            JOptionPane.showMessageDialog(null, "Registro no permitido");
                            break;
                    }

                }
            }

        } catch (Exception e) {
            System.out.println("No se puede leer el archivo: " + e);
        }
        JOptionPane.showMessageDialog(null, "Errores:  " + errores);
        return tmp;
    }
}
/* 
                           
 */
