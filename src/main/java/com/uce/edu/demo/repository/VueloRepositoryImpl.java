package com.uce.edu.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.stereotype.Repository;

import com.uce.edu.demo.repository.modelo.Vuelo;

@Repository
@Transactional
public class VueloRepositoryImpl implements IVueloRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Vuelo> buscarVuelosDisponibles(String origen, String destino, String fecha) {
		TypedQuery<Vuelo> myQuery = this.entityManager.createNamedQuery("buscarVuelosDisponibles", Vuelo.class);

		myQuery.setParameter("datoOrigen", origen);
		myQuery.setParameter("datoDestino", destino);
		myQuery.setParameter("datoFecha", fecha);
		List<Vuelo> vuelos = myQuery.getResultList();
		for (Vuelo vuelo : vuelos) {
			vuelo.getAvion().getNombre();
		}
		return vuelos;
	}

	@Override
	@Transactional(value = TxType.NOT_SUPPORTED)
	public Vuelo buscarVueloDisponible(String numeroVuelo) {
		TypedQuery<Vuelo> myQuery = this.entityManager
				.createQuery("SELECT v FROM Vuelo v WHERE v.numero= :datoNumero AND v.estado= :datoEstado", Vuelo.class);
		myQuery.setParameter("datoNumero", numeroVuelo);
		myQuery.setParameter("datoEstado", "DIS");
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Vuelo vuelo) {
		this.entityManager.merge(vuelo);
		
	}

}
