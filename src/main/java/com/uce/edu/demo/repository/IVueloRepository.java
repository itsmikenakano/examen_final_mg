package com.uce.edu.demo.repository;

import java.util.List;

import com.uce.edu.demo.repository.modelo.Vuelo;

public interface IVueloRepository {
	
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fecha);
	
	public Vuelo buscarVueloDisponible(String numeroVuelo);
	
	public void actualizar(Vuelo vuelo);

}
