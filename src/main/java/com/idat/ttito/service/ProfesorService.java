package com.idat.ttito.service;

import java.util.List;

import com.idat.ttito.entity.Profesor;



public interface ProfesorService {	
	List<Profesor> listar();
	Profesor porId(Integer id);
    void guardar(Profesor profesor);
    void eliminar(Integer id);
    void actualizar(Profesor profesor);

}
