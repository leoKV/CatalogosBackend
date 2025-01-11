package com.example.CatalogoBackend.Model;

public class TipoCuenta {

	private int tipocuentaid;
	private String descripcion;
	
	public TipoCuenta(int tipocuentaid, String descripcion) {
		this.tipocuentaid = tipocuentaid;
		this.descripcion = descripcion;
	}
	
	public int getTipoCuentaId() {
		return tipocuentaid;
	}
	public void setTipoCuentaId(int tipocuentaid) {
		this.tipocuentaid = tipocuentaid;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	 @Override
	 public String toString() {
	        return "TipoCuenta{" +
	                "tipocuentaid=" + tipocuentaid +
	                ", descripcion='" + descripcion + '\'' +
	                '}';
	 }
	
	
}
