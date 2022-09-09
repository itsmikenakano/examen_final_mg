package com.uce.edu.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uce.edu.demo.repository.modelo.ReservaSencillo;
import com.uce.edu.demo.repository.modelo.Vuelo;
import com.uce.edu.demo.service.IGestorReserva;
import com.uce.edu.demo.service.IVueloService;

@Controller
@RequestMapping("/vuelos")
public class VueloController {
	
	@Autowired
	private IVueloService iVueloService;
	
	@Autowired
	private IGestorReserva iGestorReserva;
	
	@GetMapping("/buscarVuelos")
	public String buscarVuelosDisponibles(Vuelo vuelo) {
		
		return "vistaBusqueda";
		
	}
	
	@GetMapping("/vuelosDisponibles")
	public String mostrarVuelosDisponibles(Vuelo vuelo, Model modelo) {
		List<Vuelo> vuelos = this.iVueloService.buscarVuelosDisponibles(vuelo.getOrigen(), vuelo.getDestino(), vuelo.getFecha());
		modelo.addAttribute("vuelos", vuelos);
		return "vistaListaVuelos";
	}
	
	@GetMapping("/buscarVuelo")
	public String buscarVueloDisponible(Vuelo vuelo) {
		
		return "vistaBusquedaVuelo";
		
	}
	
	@GetMapping("/vueloDisponible")
	public String reservarVueloDisponible(Vuelo vuelo, Model modelo) {
		Vuelo v = this.iVueloService.buscarVueloDisponible(vuelo.getNumero());
		modelo.addAttribute("vueloDis", v);
		modelo.addAttribute("reserva", new ReservaSencillo());
		
		return "vistaVueloDisponible";
		
	}
	
	@PostMapping("/reservar")
	public String reservar(ReservaSencillo reserva) {
		Vuelo v = this.iVueloService.buscarVueloDisponible(reserva.getNumero());
		this.iGestorReserva.realizarReserva(v, reserva.getCantidadAsientos(), reserva.getCedulaCliente());
		
		return "redirect:/vuelos/buscarVuelo";
		
	}


}
