package com.example.CatalogoBackend.Model;
import java.util.List;
import java.util.Map;

public class Catalogo {
	
	//private List<Object> lCatalogos;
	private List<Map<String, Object>> lCatalogos;
    private String fechaOperacion;
    private String fechaActual;

	// Constructor vacío
    public Catalogo() {}
    
    // Constructor con parámetros
    public Catalogo(List<Map<String, Object>> lCatalogos, String fechaOperacion, String fechaActual) {
        this.lCatalogos = lCatalogos;
        this.fechaOperacion = fechaOperacion;
        this.fechaActual = fechaActual;
    }
    
    
    
    // Getters y Setters
    public List<Map<String, Object>> getlCatalogos() {
        return lCatalogos;
    }

    public void setlCatalogos(List<Map<String, Object>> lCatalogos) {
        this.lCatalogos = lCatalogos;
    }
    

    public String getFechaOperacion() {
        return fechaOperacion;
    }

    public void setFechaOperacion(String fechaOperacion) {
        this.fechaOperacion = fechaOperacion;
    }
    
    public String getFechaActual() {
		return fechaActual;
	}

	public void setFechaActual(String fechaActual) {
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
    
}
