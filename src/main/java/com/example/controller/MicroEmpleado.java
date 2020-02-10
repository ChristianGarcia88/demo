package com.example.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.logging.Logger;

import javax.servlet.http.HttpServletResponse;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Dao.DaoCliente;
import com.example.Entity.Cliente;
import com.example.Entity.Factura;
import com.example.Excepciones.Mensajes;
import com.example.utilerias.Fechas;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/index")
public class MicroEmpleado  {
	

	
	@Autowired
	private  Fechas fechaActual;
	@Autowired
	private  DaoCliente   daoCliente;
	public  MicroEmpleado  (DaoCliente  daoCliente) {
		
		this.daoCliente=  daoCliente;
		
	}
	
	
	@GetMapping("/cliente/{id}")
	public  ResponseEntity<Cliente>  consultarCliente( @PathVariable ("id")  Integer id) {
		
		Cliente  cliente =daoCliente.search(id);
		 
		
		return new  ResponseEntity<Cliente>(cliente, HttpStatus.OK);
		
	}
	
	
	
	@GetMapping("/clientes")
	public  ResponseEntity<List<Cliente>>  listarClientes(/*@RequestHeader("Content-Type") String  header*/){
		
		//System.out.println(header + "--------------------------------------------------------------------------------------------------------------------------");
		
		return   new ResponseEntity<>(daoCliente.listClient(),HttpStatus.OK);
		
	}


	
	@PostMapping("/clienteRegistro")
	public ResponseEntity<Mensajes>   registroCliente(@RequestBody Cliente cliente  ) throws ParseException{
		
	daoCliente.add(cliente);
	
	
	
	  
		return new ResponseEntity<Mensajes>(  new  Mensajes ("Creado Exitoso", HttpStatus.CREATED, fechaActual.fechaActual()),HttpStatus.OK);
		
	}
	 

	
	@DeleteMapping("/borrar/{id}")	
	public ResponseEntity <?> borrar (@PathVariable("id") Integer id) {
	
		daoCliente.delete(id);

		
		
		
		return  new ResponseEntity<Mensajes>(new Mensajes("Borrado exitoso", HttpStatus.ACCEPTED, fechaActual.fechaActual()) ,HttpStatus.ACCEPTED);
		//return  ResponseEntity.ok(new Mensajes("borrado exitoso", HttpStatus.ACCEPTED, fechaActual.fechaActual() )); segunda forma
	}
	
	
	@PutMapping("/update")
	public  ResponseEntity<Mensajes>  update(  @RequestBody Cliente cliente) {
		
		//System.out.println(cliente.getM_idcliente() + " " +   cliente.getM_nombrePersona());
		
		Cliente c =daoCliente.update(cliente);
		 if (c==null) {		return    new ResponseEntity<Mensajes>(new Mensajes("Actualizacion Erronea", HttpStatus.NOT_FOUND,fechaActual.fechaActual()), HttpStatus.NOT_FOUND);
			}
		return   new  ResponseEntity<Mensajes>(new Mensajes("Actualizacion Exitosa", HttpStatus.ACCEPTED,fechaActual.fechaActual()),  HttpStatus.ACCEPTED);
		
	}
	
	@HystrixCommand(fallbackMethod = "otroMetodo")
	@GetMapping("/consultafacturasHixtrix/{idCliente}")
	public  ResponseEntity<?> getFacturasHitrix(@PathVariable("idCliente")  Integer  idCliente) {
		
		
	
		
		
		return new ResponseEntity<List<Factura>>(daoCliente.consultarFacturas(idCliente), HttpStatus.ACCEPTED);
		
		
		
	}
	
	
	public  ResponseEntity<?> otroMetodo( Integer  idCliente){
	
		//return new ResponseEntity<Mensajes[]>( new Mensajes[] { new Mensajes("no hay Usuario", HttpStatus.BAD_GATEWAY, fechaActual.fechaActual())},HttpStatus.BAD_GATEWAY);
		
		//return   (ResponseEntity<?>) Arrays.asList( new Mensajes("no hay Usuario", HttpStatus.BAD_GATEWAY, fechaActual.fechaActual()));
	return  (ResponseEntity<?>) Arrays.asList ( new Factura(0,  new Cliente(),0F ,new Date()));
	}
	
	@DeleteMapping("/delete/user/{id}")
	public  ResponseEntity<?> deleteFromUser(@PathVariable("id") Integer id ){
		
		daoCliente.delete(id);
		
		
		
		return new ResponseEntity<Mensajes>( new Mensajes("Todo eliminado en cascada", HttpStatus.ACCEPTED, fechaActual.fechaActual()),HttpStatus.ACCEPTED);
		
	}


	
}
