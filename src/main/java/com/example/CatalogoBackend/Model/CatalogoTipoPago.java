package com.example.CatalogoBackend.Model;

import java.util.Date;
import java.util.List;

public class CatalogoTipoPago {
	private List<TipoPago> listTipoPago;
    private Date fechaOperacion;
    
    // Constructor
    public CatalogoTipoPago() {}
    
    public CatalogoTipoPago(List<TipoPago> listTipoPago, Date fechaOperacion) {
        this.listTipoPago = listTipoPago;
        this.fechaOperacion = fechaOperacion;
    }
    
    // Getters y Setters
    public List<TipoPago> getListTipoPago() {
        return listTipoPago;
    }

    public void setListTipoPago(List<TipoPago> listTipoPago) {
        this.listTipoPago = listTipoPago;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
    @Override
    public String toString() {
        return "CatalogoTipoPago{" +
                "listTipoPago=" + listTipoPago +
                ", fechaOperacion=" + fechaOperacion +
                '}';
    }

}
