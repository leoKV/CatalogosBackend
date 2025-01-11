package com.example.CatalogoBackend.Model;

import java.util.Date;
import java.util.List;

public class Catalogo {
	
	private List<Object> lCatalogos;
    private Date fechaOperacion;
    private Date fechaActual;

	// Constructor vacío
    public Catalogo() {}
    
    // Constructor con parámetros
    public Catalogo(List<Object> lCatalogos, Date fechaOperacion, Date fechaActual) {
        this.lCatalogos = lCatalogos;
        this.fechaOperacion = fechaOperacion;
        this.fechaActual = fechaActual;
    }
    
    // Getters y Setters
    public List<Object> getlCatalogos() {
        return lCatalogos;
    }

    public void setlCatalogos(List<Object> lCatalogos) {
        this.lCatalogos = lCatalogos;
    }

    public Date getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(Date fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
    public Date getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(Date fechaActual) {
		this.fechaActual = fechaActual;
	}
    
    @Override
    public String toString() {
        return "Catalogo{" +
                "lCatalogos=" + lCatalogos +
                ", fechaOperacion='" + fechaOperacion + '\'' +
                ", fechaActual='" + fechaActual + '\'' +
                '}';
    }
    
    /*
    public String toString() {
        return "Catalogo{" +
                "lCatalogos=" + lCatalogos +
                ", fechaOperacion=" + fechaOperacion +
                ", fechaActual=" + fechaActual +
                '}';
    }
    */

}
