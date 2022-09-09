package com.uce.edu.demo.repository.modelo;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@NamedQuery(name = "buscarVuelosDisponibles", query = "SELECT v FROM Vuelo v JOIN v.avion a WHERE v.origen= :datoOrigen AND v.destino= :datoDestino AND v.fecha= :datoFecha")

@Entity
@Table(name = "vuelo")
public class Vuelo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vuel_id_seq")
	@SequenceGenerator(name = "vuel_id_seq", sequenceName = "vuel_id_seq", allocationSize = 1)
	@Column(name = "vuel_id")
	private Integer id;

	@Column(name = "vuel_numero")
	private String numero;

	@Column(name = "vuel_fecha")
	private String fecha;

	@Column(name = "vuel_asientos_disponibles")
	private Integer asientosDisponibles;

	@Column(name = "vuel_asientos_ocupados")
	private Integer asientosOcupados;

	@Column(name = "vuel_valor_asiento")
	private BigDecimal valorAsiento;

	@Column(name = "vuel_estado")
	private String estado;

	@Column(name = "vuel_origen")
	private String origen;

	@Column(name = "vuel_destino")
	private String destino;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "avio_id")
	private Avion avion;

	@OneToMany(mappedBy = "vuelo")
	private List<CompraPasaje> pasajes;

	// SET Y GET
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public Integer getAsientosDisponibles() {
		return asientosDisponibles;
	}

	public void setAsientosDisponibles(Integer asientosDisponibles) {
		this.asientosDisponibles = asientosDisponibles;
	}

	public Integer getAsientosOcupados() {
		return asientosOcupados;
	}

	public void setAsientosOcupados(Integer asientosOcupados) {
		this.asientosOcupados = asientosOcupados;
	}

	public BigDecimal getValorAsiento() {
		return valorAsiento;
	}

	public void setValorAsiento(BigDecimal valorAsiento) {
		this.valorAsiento = valorAsiento;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getOrigen() {
		return origen;
	}

	public void setOrigen(String origen) {
		this.origen = origen;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public Avion getAvion() {
		return avion;
	}

	public void setAvion(Avion avion) {
		this.avion = avion;
	}

	public List<CompraPasaje> getPasajes() {
		return pasajes;
	}

	public void setPasajes(List<CompraPasaje> pasajes) {
		this.pasajes = pasajes;
	}

}
