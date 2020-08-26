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
public class Suministra {
    int idSuministro;
    String tienda;
    String producto;
    String nombre;
    int cantidadT;

    public Suministra(int idSuministro, String tienda, String producto, String nombre, int cantidadT) {
        this.idSuministro = idSuministro;
        this.tienda = tienda;
        this.producto = producto;
        this.nombre = nombre;
        this.cantidadT = cantidadT;
    }

    public int getIdSuministro() {
        return idSuministro;
    }

    public void setIdSuministro(int idSuministro) {
        this.idSuministro = idSuministro;
    }

    public String getTienda() {
        return tienda;
    }

    public void setTienda(String tienda) {
        this.tienda = tienda;
    }

    public String getProducto() {
        return producto;
    }

    public void setProducto(String producto) {
        this.producto = producto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadT() {
        return cantidadT;
    }

    public void setCantidadT(int cantidadT) {
        this.cantidadT = cantidadT;
    }


}
