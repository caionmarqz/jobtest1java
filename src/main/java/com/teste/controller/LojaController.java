package com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teste.model.CepRange;
import com.teste.model.Loja;
import com.teste.repository.TesteRepository;
import com.teste.utils.BusinessLogic;

@RestController
@RequestMapping("/api/v1")
public class LojaController {

	
	@Autowired
	TesteRepository repository;

	@Autowired
	BusinessLogic bl;
	
	
	/*
	 *  Requisitar todas as LOJAS
	 * 
	 * 	Produces: JSON(loja)
	 */
	
	
	@GetMapping(value="/", produces="application/json")
	public ResponseEntity<List<Loja>> getLojas() { 
		return new ResponseEntity<List<Loja>>(repository.findAll(), HttpStatus.OK);
	}
	
	
	
	/*
	 *  Função adicionar novas LOJAS
	 * 
	 *  Produces: JSON(loja) / Consumes: JSON(loja)
	 */
	
	
	@PostMapping(value="/add", consumes="application/json", produces="application/json")
	public ResponseEntity<Loja> addLoja(@RequestBody Loja loja) {
		repository.save(loja);
		return new ResponseEntity<Loja>(loja, HttpStatus.OK);
	}
	
	
	
	/*
	 *  Função requisitar LOJA por ID
	 * 
	 * 	Produces: JSON(loja) / Consumes: Pathvariable("id")
	 */
	
	
	@GetMapping(value="/{id}", produces="application/json")
	public ResponseEntity<Loja> getLoja(@PathVariable("id") long id) { 
		return new ResponseEntity<Loja>(repository.findById(id).get(), HttpStatus.OK);
	}

	
	
		
	/*
	 * #######               PROVA            #######
	 * #######							      #######
	 * ####### Adiciona uma nova faixa de CEP #######
	 * 
	 */


	@PostMapping(value="/add/{id}", consumes = "application/json", produces="application/json")
	public Loja addCepRangeToLoja(@RequestBody CepRange range, @PathVariable("id") long id) {
		return bl.addCepRangeToLoja(range, id);
	}



	/*
	 * #######                PROVA              #######
	 * #######							         #######
	 * ####### Encontra uma loja na Faixa do cep #######
	 * 
	 */

	@GetMapping(value="/find/{cep}", produces="application/json")
	public ResponseEntity<Loja> findLoja(@PathVariable("cep") long cep) {
		return new ResponseEntity<Loja>(bl.findLojaByCep(cep), HttpStatus.OK);
	}

	




















}
