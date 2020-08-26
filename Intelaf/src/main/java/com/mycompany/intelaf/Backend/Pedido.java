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
public class Pedido {
    int pedido;
    String clienteP;
    String fechaP;
    String tiendaPO;
    String tiendaPD;
    boolean aTiempo;
    double total;
    double pagoAnt;
    boolean enTienda;

    public Pedido(int pedido, String clienteP, String fechaP, String tiendaPO, String tiendaPD, boolean aTiempo, double total, double pagoAnt, boolean enTienda) {
        this.pedido = pedido;
        this.clienteP = clienteP;
        this.fechaP = fechaP;
        this.tiendaPO = tiendaPO;
        this.tiendaPD = tiendaPD;
        this.aTiempo = aTiempo;
        this.total = total;
        this.pagoAnt = pagoAnt;
        this.enTienda = enTienda;
    }



    public int getPedido() {
        return pedido;
    }

    public void setPedido(int pedido) {
        this.pedido = pedido;
    }

    public String getClienteP() {
        return clienteP;
    }

    public void setClienteP(String clienteP) {
        this.clienteP = clienteP;
    }

    public String getFechaP() {
        return fechaP;
    }

    public void setFechaP(String fechaP) {
        this.fechaP = fechaP;
    }

    public String getTiendaPO() {
        return tiendaPO;
    }

    public void setTiendaPO(String tiendaPO) {
        this.tiendaPO = tiendaPO;
    }

    public String getTiendaPD() {
        return tiendaPD;
    }

    public void setTiendaPD(String tiendaPD) {
        this.tiendaPD = tiendaPD;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public double getPagoAnt() {
        return pagoAnt;
    }

    public void setPagoAnt(double pagoAnt) {
        this.pagoAnt = pagoAnt;
    }

    public boolean isaTiempo() {
        return aTiempo;
    }

    public void setaTiempo(boolean aTiempo) {
        this.aTiempo = aTiempo;
    }

    public boolean isEnTienda() {
        return enTienda;
    }

    public void setEnTienda(boolean enTienda) {
        this.enTienda = enTienda;
    }


    
}
