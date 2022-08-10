package com.idat.ttito.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.idat.ttito.entity.Profesor;
import com.idat.ttito.repository.ProfesorRepository;

@Service
public class ProfesorServiceImpl implements ProfesorService{

	@Autowired
	private ProfesorRepository repository;
	
	@Override
	public List<Profesor> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Profesor porId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Profesor profesor) {
		// TODO Auto-generated method stub
			repository.save(profesor);
		
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
			repository.deleteById(id);
	}

	@Override
	public void actualizar(Profesor profesor) {
		// TODO Auto-generated method stub
			repository.saveAndFlush(profesor);
	}

}
