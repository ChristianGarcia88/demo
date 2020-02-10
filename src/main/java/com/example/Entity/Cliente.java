package com.example.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name ="Proyecto_Cliente")
public class Cliente {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private  Integer m_idcliente;
	
	@Column(name = "nombre_Persona")
	private   String   m_nombrePersona;
	
	@Column(name = "apellido_Persona")
	private  String  m_apellidoPersona;
	
	
	
	public Integer getM_idcliente() {
		return m_idcliente;
	}



	public void setM_idcliente(Integer m_idcliente) {
		this.m_idcliente = m_idcliente;
	}



	public String getM_nombrePersona() {
		return m_nombrePersona;
	}



	public void setM_nombrePersona(String m_nombrePersona) {
		this.m_nombrePersona = m_nombrePersona;
	}



	public String getM_apellidoPersona() {
		return m_apellidoPersona;
	}



	public void setM_apellidoPersona(String m_apellidoPersona) {
		this.m_apellidoPersona = m_apellidoPersona;
	}



	public Integer getEdad() {
		return edad;
	}



	public void setEdad(Integer edad) {
		this.edad = edad;
	}



	@Column(name="edad")
	private Integer  edad;
	
	
	
	public Cliente() {
		
		
		
		
	}
	
	
	
	

}
