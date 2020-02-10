package com.example.Dao;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import com.example.Entity.Cliente;
import com.example.Entity.Factura;
import com.example.Excepciones.Mensajes;
import com.example.InterfaceMethods.ICliente;
import com.example.Repositorio.RepositorioCliente;




@Component
public class DaoCliente   implements ICliente  {
	
	
	@Value("${contenedor.llamado}")
	private String texto;
	
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private  RepositorioCliente  repoClient;

	
	private Logger log= LogManager.getLogger(DaoCliente.class);

	@Override
	public void add(Cliente cliente) {
			
		repoClient.save(cliente);
		
		
		restTemplate.postForEntity("http://"+texto+ ":"+ "1234/facturas/crear", cliente, Mensajes.class);
		
		
	}

	  @Transactional
	  @Modifying(clearAutomatically = true)
	public void delete(Integer id) {
		Map<String, String>  map=   new HashMap<>();
		map.put("id", Integer.toString(id));
		log.info("Antes de  rest");
		
	 restTemplate.delete("http://"+texto+":"+"1234/facturas/delete/factura/user/{id}", map);
	  log.info("despues de resttemplate");
	  repoClient.deleteById(id);   
		
	}

	@Override
	public Cliente search(Integer id) {
	  Optional<Cliente> cliente=	 repoClient.findById(id);
		return cliente.get();
	}

	@Override
	public List<Cliente> listClient() {
		
		return (List<Cliente>) repoClient.findAll();
	}
	
	
@Override
public  Cliente  update(Cliente cliente) {
	
    
     
	return repoClient.save(cliente);
	
}


public List<Factura>  consultarFacturas (Integer  usuarioId)  throws  NoSuchElementException  {
	
	Map<String, Integer>  mapa= new HashMap<>();
	mapa.put("idcliente", usuarioId);
	
	
 List<Factura>  facturas= Arrays.asList( restTemplate.getForObject("http://localhost:1234/facturas/factura/cliente/{idcliente}", Factura[].class, mapa));
 
 /*if (facturas== null) {
	 System.out.println("no hay facturas con este id  cliente ");
	 throw  new  NoSuchElementException("no facturas con este id ");

	 
 }*/
	
	return facturas;
	
}

public String getTexto() {
	return texto;
}

public void setTexto(String texto) {
	this.texto = texto;
}



	
}
