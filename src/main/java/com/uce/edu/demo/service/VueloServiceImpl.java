package com.uce.edu.demo.service;

import java.util.List;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.IVueloRepository;
import com.uce.edu.demo.repository.modelo.Vuelo;

@Service
public class VueloServiceImpl implements IVueloService{
	
	@Autowired
	private IVueloRepository iVueloRepository;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fecha) {
		return this.iVueloRepository.buscarVuelosDisponibles(origen, destino, fecha);
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarVueloDisponible(String numeroVuelo) {
		// TODO Auto-generated method stub
		return this.iVueloRepository.buscarVueloDisponible(numeroVuelo);
	}

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void actualizar(Vuelo vuelo) {
		// TODO Auto-generated method stub
		this.iVueloRepository.actualizar(vuelo);
	}

}
