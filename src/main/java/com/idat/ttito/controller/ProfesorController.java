package com.idat.ttito.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.idat.ttito.entity.Profesor;
import com.idat.ttito.service.ProfesorService;

@Controller
@RequestMapping("/api/profesor/v1")
public class ProfesorController {

	@Autowired
	private ProfesorService service;

	@GetMapping("/listar")
    public ResponseEntity<List<Profesor>> listarC(){
        List<Profesor> con = service.listar();
        return new ResponseEntity<>(con, HttpStatus.OK);
    }

    @PostMapping("/nuevo")
    public ResponseEntity<Void> nuevoC(@Validated @RequestBody Profesor profesor){
        service.guardar(profesor);
        return  new ResponseEntity<Void>(HttpStatus.OK);
    }

    @PutMapping("/actualizar")
    public ResponseEntity<Void> actualizarC(@Validated @RequestBody Profesor profesor){
        service.actualizar(profesor);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    @GetMapping("/listarPorId/{id}")
    public ResponseEntity<Profesor> listarPorId(@Validated @RequestBody @PathVariable("id")Integer id) throws Exception{
    	Profesor con = service.porId(id);
        if (con == null){
            throw new Exception("No existe id");
        }
        return new ResponseEntity<Profesor>(con, HttpStatus.OK);
    }
    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarA(@Validated @RequestBody @PathVariable("id")Integer id) throws Exception{
    	Profesor pdt = service.porId(id);
        if(pdt == null){
            throw new Exception("No existe Id");
        }
        service.eliminar(id);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }
	
}
