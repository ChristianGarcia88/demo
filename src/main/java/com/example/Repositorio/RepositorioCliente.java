package com.example.Repositorio;




import org.springframework.data.repository.CrudRepository;

import com.example.Entity.Cliente;




public interface RepositorioCliente  extends  CrudRepository<Cliente, Integer>{
	


}
