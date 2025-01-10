package com.example.CatalogoBackend.Model;

public class TipoPago {
	
	private int tipopagoid;
    private String descripcion;
    private String aceptacion;
    
    public TipoPago(int tipopagoid, String descripcion, String aceptacion) {
        this.tipopagoid = tipopagoid;
        this.descripcion = descripcion;
        this.aceptacion = aceptacion;
    }
    
    public int getTipopagoid() {
        return tipopagoid;
    }

    public void setTipopagoid(int tipopagoid) {
        this.tipopagoid = tipopagoid;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getAceptacion() {
        return aceptacion;
    }

    public void setAceptacion(String aceptacion) {
        this.aceptacion = aceptacion;
    }
    
    @Override
    public String toString() {
        return "TipoPago{" +
                "tipopagoid=" + tipopagoid +
                ", descripcion='" + descripcion + '\'' +
                ", aceptacion='" + aceptacion + '\'' +
                '}';
    }

}
