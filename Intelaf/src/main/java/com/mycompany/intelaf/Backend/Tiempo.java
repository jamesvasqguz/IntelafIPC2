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
public class Tiempo {
    int idTiempo;
    String tienda1;
    String tienda2;
    int tiempoPedido;

    public Tiempo(int idTiempo, String tienda1, String tienda2, int tiempoPedido) {
        this.idTiempo = idTiempo;
        this.tienda1 = tienda1;
        this.tienda2 = tienda2;
        this.tiempoPedido = tiempoPedido;
    }

    public int getIdTiempo() {
        return idTiempo;
    }

    public void setIdTiempo(int idTiempo) {
        this.idTiempo = idTiempo;
    }

    public String getTienda1() {
        return tienda1;
    }

    public void setTienda1(String tienda1) {
        this.tienda1 = tienda1;
    }

    public String getTienda2() {
        return tienda2;
    }

    public void setTienda2(String tienda2) {
        this.tienda2 = tienda2;
    }

    public int getTiempoPedido() {
        return tiempoPedido;
    }

    public void setTiempoPedido(int tiempoPedido) {
        this.tiempoPedido = tiempoPedido;
    }
    
}
