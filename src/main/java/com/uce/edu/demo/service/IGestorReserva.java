package com.uce.edu.demo.service;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IGestorReserva {
	
	public void realizarReserva(Vuelo vuelo, Integer cantidadAsientos, String cedulaCliente);

}
