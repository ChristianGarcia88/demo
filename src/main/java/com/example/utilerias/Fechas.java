package com.example.utilerias;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class Fechas {
	
	public  Fechas() {}
	
	
	
	public String  fechaActual() {
		
		SimpleDateFormat   fecha1= new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		Calendar  fecha= Calendar.getInstance();
		String  fechaString=	fecha1.format(fecha.getTime());
		
		
		
		return fechaString;
		
	}
	
	
	
	
	

}
