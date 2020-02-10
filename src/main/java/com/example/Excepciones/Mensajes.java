package com.example.Excepciones;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.springframework.http.HttpStatus;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Mensajes {
	
	private  String mensaje;
	private  HttpStatus  codigo;
	private String fecha ;
	
	public Mensajes() {}
	
	
	
	public  Mensajes (String mensaje, HttpStatus codigo, String fecha) {
		
		this.mensaje=mensaje;
		this.codigo=codigo;
	    this.fecha=  fecha;
		
		
	}
	public String getMensaje() {
		return mensaje;
		
	}
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
	public HttpStatus getCodigo() {
		return codigo;
	}
	public void setCodigo(HttpStatus codigo) {
		this.codigo = codigo;
	}
	public String getFecha()  {

		
	
		return fecha;
		
		
	}
	public void setFecha(String fecha)  {
		
	
		this.fecha = fecha;
	}
	

}
