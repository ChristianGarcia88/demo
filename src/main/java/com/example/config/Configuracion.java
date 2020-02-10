package com.example.config;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.Proxy.Type;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.example.utilerias.Fechas;

@Configuration
public class Configuracion {
	
	
	@Value("${contenedor.llamado}")
	public  String contenedor;
	
	@Bean 
	public  Fechas  fechaActual() {

		return new  Fechas();
		
	}
	
	@Bean
	public RestTemplate restTemplate() {
	    SimpleClientHttpRequestFactory requestFactory = new SimpleClientHttpRequestFactory();

	    Proxy proxy= new Proxy(Type.HTTP, new InetSocketAddress(contenedor, 1234));
	    requestFactory.setProxy(proxy);
	    return new RestTemplate(requestFactory);
	   // return new RestTemplate();
	}
}
