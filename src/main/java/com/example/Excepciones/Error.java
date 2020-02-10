package com.example.Excepciones;

public class Error {
	
	private  String  mensaje;
	private Integer  codigo;
	private  String status;
	
	
	public  Error(String  mensaje,  Integer codigo, String  status) {
		
		this.mensaje= mensaje;
		this.codigo= codigo;
		this.status= status;
		
		
		
	}


	public String getMensaje() {
		return mensaje;
	}


	public Integer getCodigo() {
		return codigo;
	}


	public String getStatus() {
		return status;
	}


	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}


	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}


	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
	
	

}
