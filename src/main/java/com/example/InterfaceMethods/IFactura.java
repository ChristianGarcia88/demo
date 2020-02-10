package com.example.InterfaceMethods;

import java.util.List;

import com.example.Entity.Factura;

public interface IFactura {
	
	
	void  addFactura (Factura factura);
	Factura  searchFactura(Integer id);
	List<Factura>  searchAll();
	void  eliminarFactura (Integer id );
}
