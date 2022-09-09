package com.uce.edu.demo.repository.modelo;

public class ReservaSencillo {

	private String numero;

	private Integer cantidadAsientos;

	private String cedulaCliente;
	
	

	public ReservaSencillo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReservaSencillo(String numero, Integer cantidadAsientos, String cedulaCLiente) {
		super();
		this.numero = numero;
		this.cantidadAsientos = cantidadAsientos;
		this.cedulaCliente = cedulaCLiente;
	}

	// SET Y GET
	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Integer getCantidadAsientos() {
		return cantidadAsientos;
	}

	public void setCantidadAsientos(Integer cantidadAsientos) {
		this.cantidadAsientos = cantidadAsientos;
	}

	public String getCedulaCliente() {
		return cedulaCliente;
	}

	public void setCedulaCliente(String cedulaCLiente) {
		this.cedulaCliente = cedulaCLiente;
	}

}
