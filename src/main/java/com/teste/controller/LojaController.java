package com.teste.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.model.CepRange;
import com.teste.model.Loja;
import com.teste.repository.TesteRepository;
import com.teste.utils.BusinessLogic;

@Controller
@RequestMapping("/api/v1")
public class LojaController {

	
	@Autowired
	TesteRepository repository;

	/*
	 *  Requisitar todas as lojas
	 * 
	 * 	Produces: JSON(loja)
	 */
	
	
	@GetMapping(value="/get", produces="application/json")
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
	
	
	@GetMapping(value="/get/{id}", produces="application/json")
	public ResponseEntity<Loja> getLoja(@PathVariable("id") long id) { 
		return new ResponseEntity<Loja>(repository.findById(id).get(), HttpStatus.OK);
	}

	
	
		
	/*
	 * ####### FUNCÃO NECESSÁRIA A PROVA      #######
	 * #######							      #######
	 * ####### Adiciona uma nova faixa de CEP #######
	 * 
	 */


	@PostMapping(value="/add/{id}", consumes = "application/json", produces="application/json")
	public ResponseEntity<Loja> addCepRangeToLoja(@RequestBody CepRange range, @PathVariable("id") long id) {
		Loja loja = repository.findById(id).get();
		loja.AddFaixa(range);
		repository.save(loja);
		return new ResponseEntity<Loja>(loja, HttpStatus.OK);
	}



	/*
	 * ####### FUNCÃO NECESSÁRIA A PROVA         #######
	 * #######							         #######
	 * ####### Encontra uma loja na Faixa do cep #######
	 * 
	 */

	@GetMapping(value="/find/{cep}", produces="application/json")
	public ResponseEntity<Loja> findLoja(@PathVariable("cep") long cep) {

		BusinessLogic bl = new BusinessLogic();
		
		return new ResponseEntity<Loja>(bl.findLojaByCep(cep), HttpStatus.OK);
	}

	




















}
