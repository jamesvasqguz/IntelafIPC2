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
public class Cliente {
    int idCliente;
    String nombreC;
    String nitC;
    String telefono;
    String dpiC;
    double creditoC;
    String emailC;
    String direccionC;

    public Cliente(int idCliente, String nombreC, String nitC, String telefono, String dpiC, double creditoC, String emailC, String direccionC) {
        this.idCliente = idCliente;
        this.nombreC = nombreC;
        this.nitC = nitC;
        this.telefono = telefono;
        this.dpiC = dpiC;
        this.creditoC = creditoC;
        this.emailC = emailC;
        this.direccionC = direccionC;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreC() {
        return nombreC;
    }

    public void setNombreC(String nombreC) {
        this.nombreC = nombreC;
    }

    public String getNitC() {
        return nitC;
    }

    public void setNitC(String nitC) {
        this.nitC = nitC;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDpiC() {
        return dpiC;
    }

    public void setDpiC(String dpiC) {
        this.dpiC = dpiC;
    }

    public double getCreditoC() {
        return creditoC;
    }

    public void setCreditoC(double creditoC) {
        this.creditoC = creditoC;
    }

    public String getEmailC() {
        return emailC;
    }

    public void setEmailC(String emailC) {
        this.emailC = emailC;
    }

    public String getDireccionC() {
        return direccionC;
    }

    public void setDireccionC(String direccionC) {
        this.direccionC = direccionC;
    }
    
}
