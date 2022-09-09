package com.uce.edu.demo.service;

import javax.transaction.Transactional;
import javax.transaction.Transactional.TxType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uce.edu.demo.repository.ICompraPasajeRepository;
import com.uce.edu.demo.repository.modelo.CompraPasaje;

@Service
public class CompraPasajeServiceImpl implements ICompraPasajeService{
	
	@Autowired
	private ICompraPasajeRepository iCompraPasajeRepository;

	@Override
	@Transactional(value = TxType.REQUIRED)
	public void insertar(CompraPasaje pasaje) {
		this.iCompraPasajeRepository.insertar(pasaje);
		
	}
}
