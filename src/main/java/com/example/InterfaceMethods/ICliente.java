package com.example.InterfaceMethods;

import java.util.List;

import com.example.Entity.Cliente;

public interface ICliente {
	
	
  void add( Cliente cliente);
  void  delete (Integer  id );
  Cliente  search(Integer id );
  List<Cliente>  listClient ();	  
  Cliente update(Cliente cliente);

}
