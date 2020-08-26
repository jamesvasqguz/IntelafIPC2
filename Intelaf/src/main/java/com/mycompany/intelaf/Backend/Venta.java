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
public class Venta {
    int idVenta;
    String tiendaV;
    String empleadoV;
    String nitV;
    String codigoP;
    int cantidadP;
    double totalV;
    double efectivoV;
    double creditoV;
    String fechaV;

    public Venta(int idVenta, String tiendaV, String empleadoV, String nitV, String codigoP, int cantidadP, double totalV, double efectivoV, double creditoV, String fechaV) {
        this.idVenta = idVenta;
        this.tiendaV = tiendaV;
        this.empleadoV = empleadoV;
        this.nitV = nitV;
        this.codigoP = codigoP;
        this.cantidadP = cantidadP;
        this.totalV = totalV;
        this.efectivoV = efectivoV;
        this.creditoV = creditoV;
        this.fechaV = fechaV;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getTiendaV() {
        return tiendaV;
    }

    public void setTiendaV(String tiendaV) {
        this.tiendaV = tiendaV;
    }

    public String getEmpleadoV() {
        return empleadoV;
    }

    public void setEmpleadoV(String empleadoV) {
        this.empleadoV = empleadoV;
    }

    public String getNitV() {
        return nitV;
    }

    public void setNitV(String nitV) {
        this.nitV = nitV;
    }

    public String getCodigoP() {
        return codigoP;
    }

    public void setCodigoP(String codigoP) {
        this.codigoP = codigoP;
    }

    public int getCantidadP() {
        return cantidadP;
    }

    public void setCantidadP(int cantidadP) {
        this.cantidadP = cantidadP;
    }

    public double getTotalV() {
        return totalV;
    }

    public void setTotalV(double totalV) {
        this.totalV = totalV;
    }

    public double getEfectivoV() {
        return efectivoV;
    }

    public void setEfectivoV(double efectivoV) {
        this.efectivoV = efectivoV;
    }

    public double getCreditoV() {
        return creditoV;
    }

    public void setCreditoV(double creditoV) {
        this.creditoV = creditoV;
    }

    public String getFechaV() {
        return fechaV;
    }

    public void setFechaV(String fechaV) {
        this.fechaV = fechaV;
    }

    
}
