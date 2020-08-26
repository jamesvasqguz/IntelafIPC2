/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.intelaf.Backend;

/**
 *
 * @author jara
 */
public class Empleado {
    String idEmpleado;
    String nombreEmpleado;
    String dpiEmpleado;
    String nitEmpleado;
    String emailE;
    String direccionE;
    String telefonoE;

    public Empleado(String idEmpleado, String nombreEmpleado, String dpiEmpleado, String nitEmpleado, String emailE, String direccionE, String telefonoE) {
        this.idEmpleado = idEmpleado;
        this.nombreEmpleado = nombreEmpleado;
        this.dpiEmpleado = dpiEmpleado;
        this.nitEmpleado = nitEmpleado;
        this.emailE = emailE;
        this.direccionE = direccionE;
        this.telefonoE = telefonoE;
    }

    public String getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(String idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getNombreEmpleado() {
        return nombreEmpleado;
    }

    public void setNombreEmpleado(String nombreEmpleado) {
        this.nombreEmpleado = nombreEmpleado;
    }

    public String getDpiEmpleado() {
        return dpiEmpleado;
    }

    public void setDpiEmpleado(String dpiEmpleado) {
        this.dpiEmpleado = dpiEmpleado;
    }

    public String getNitEmpleado() {
        return nitEmpleado;
    }

    public void setNitEmpleado(String nitEmpleado) {
        this.nitEmpleado = nitEmpleado;
    }

    public String getEmailE() {
        return emailE;
    }

    public void setEmailE(String emailE) {
        this.emailE = emailE;
    }

    public String getDireccionE() {
        return direccionE;
    }

    public void setDireccionE(String direccionE) {
        this.direccionE = direccionE;
    }

    public String getTelefonoE() {
        return telefonoE;
    }

    public void setTelefonoE(String telefonoE) {
        this.telefonoE = telefonoE;
    }
    
}
