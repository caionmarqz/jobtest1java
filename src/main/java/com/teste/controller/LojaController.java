package com.teste.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import com.teste.repository.TesteRepository;

@RequestMapping("/api/v1")
public class LojaController {

	
	@Autowired
	TesteRepository repository;
}
