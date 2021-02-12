package com.teste.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.teste.model.Loja;
import com.teste.repository.TesteRepository;


@Component
public class BusinessLogic {

	@Autowired
	TesteRepository repository;
	
	public Loja findLojaByCep(long cep) {
		return repository.findById((long) 1).get();
	}
	
	
}
