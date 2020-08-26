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
public class Contiene {
    int idContiene;
    String productoCont;
    int pedidoCont;
    int cantidadCont;
    double sumaCont;

    public Contiene(int idContiene, String productoCont, int pedidoCont, int cantidadCont, double sumaCont) {
        this.idContiene = idContiene;
        this.productoCont = productoCont;
        this.pedidoCont = pedidoCont;
        this.cantidadCont = cantidadCont;
        this.sumaCont = sumaCont;
    }

    public int getIdContiene() {
        return idContiene;
    }

    public void setIdContiene(int idContiene) {
        this.idContiene = idContiene;
    }

    public String getProductoCont() {
        return productoCont;
    }

    public void setProductoCont(String productoCont) {
        this.productoCont = productoCont;
    }

    public int getPedidoCont() {
        return pedidoCont;
    }

    public void setPedidoCont(int pedidoCont) {
        this.pedidoCont = pedidoCont;
    }

    public int getCantidadCont() {
        return cantidadCont;
    }

    public void setCantidadCont(int cantidadCont) {
        this.cantidadCont = cantidadCont;
    }

    public double getSumaCont() {
        return sumaCont;
    }

    public void setSumaCont(double sumaCont) {
        this.sumaCont = sumaCont;
    }
    
}
