/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.Backend;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jara
 */
public class ConnectionMysql {

    public static Connection cn;
    private static final String driver = "com.mysql.jdbc.Driver";
    private static final String user = "grimbold";
    private static final String password = "asdf1234";
    private static final String url = "jdbc:mysql://localhost:3306/intelaf_1";
    // Funcion que va conectarse a mi bd de mysql

    public static Connection conector() {
        // Reseteamos a null la conexion a la bd
        try {
            Class.forName(driver);
            // Nos conectamos a la bd
            cn = (Connection) DriverManager.getConnection(url, user, password);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (cn != null) {
                System.out.println("Conexion establecida");
            }
            return cn;
        } // Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e) {
            System.out.println("Error de conexion" + e);
        }
        return (null);
    }

}
