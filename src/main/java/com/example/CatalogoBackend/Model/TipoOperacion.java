package com.example.CatalogoBackend.Model;

public class TipoOperacion {
	private int tipooperacionid;
	private String descripcion;
	
	public TipoOperacion(int tipooperacionid, String descripcion) {
		this.tipooperacionid = tipooperacionid;
		this.descripcion = descripcion;
	}
	
	public int getTipoOperacionId() {
		return tipooperacionid;
	}
	public void setTipoOperacionId(int tipooperacionid) {
		this.tipooperacionid = tipooperacionid;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	 @Override
	 public String toString() {
	        return "TipoOperacion{" +
	                "tipooperacionid=" + tipooperacionid +
	                ", descripcion='" + descripcion + '\'' +
	                '}';
	 }
}
