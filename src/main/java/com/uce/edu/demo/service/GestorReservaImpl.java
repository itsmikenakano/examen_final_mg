package com.uce.edu.demo.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.modelo.CompraPasaje;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class GestorReservaImpl implements IGestorReserva{
	
	@Autowired
	private ICompraPasajeService iCompraPasajeService;
	
	@Autowired
	private IVueloService iVueloService;
	
	@Autowired
	private IClienteService iClienteService;

	@Override
	@Transactional(value = TxType.REQUIRES_NEW)
	public void realizarReserva(Vuelo vuelo, Integer cantidadAsientos, String cedulaCliente) {

		List<CompraPasaje> pasajes = new ArrayList<>();
		
		CompraPasaje pasaje = new CompraPasaje();
		pasaje.setCliente(this.iClienteService.buscarPorCedula(cedulaCliente));
		pasaje.setEstado("RES");
		pasaje.setFechaCompra(LocalDateTime.now());
		pasaje.setNumero(vuelo.getNumero());
		
		if(vuelo.getAsientosDisponibles() < cantidadAsientos) {
			throw new RuntimeException();
		}
		
		if(vuelo.getAsientosDisponibles() > cantidadAsientos) {
			pasaje.setCantidadAsientosComprados(cantidadAsientos);
			vuelo.setAsientosOcupados(vuelo.getAsientosOcupados()+cantidadAsientos);
			vuelo.setAsientosDisponibles(vuelo.getAsientosDisponibles()-cantidadAsientos);
		}else{
			pasaje.setCantidadAsientosComprados(vuelo.getAsientosDisponibles());
			vuelo.setAsientosOcupados(vuelo.getAsientosOcupados()+pasaje.getCantidadAsientosComprados());
			vuelo.setAsientosDisponibles(0);
			vuelo.setEstado("ND");
		}
		
		
		pasaje.setVuelo(vuelo);
		pasajes.add(pasaje);
		vuelo.setPasajes(pasajes);
		
		this.iCompraPasajeService.insertar(pasaje);
		
		this.iVueloService.actualizar(vuelo);
		
	}

}
