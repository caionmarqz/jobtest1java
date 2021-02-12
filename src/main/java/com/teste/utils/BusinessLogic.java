package com.teste.utils;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.teste.model.CepRange;
import com.teste.model.Loja;
import com.teste.repository.TesteRepository;


@Component
public class BusinessLogic {

	@Autowired
	TesteRepository repository;
	
	public Loja findLojaByCep(long cep) {
		List<Loja> lojas = repository.findAll();
		for (Loja loja : lojas) {
			for (CepRange range : loja.getFaixas()) {
				if ((range.getFAIXA_INICIO()<= cep) && (range.getFAIXA_FIM()>= cep)) {
					return loja;
				}
			}
		}
		return null;
	}

	public Loja addCepRangeToLoja(CepRange new_range, long id) {
		Loja loja1 = repository.findById(id).get();
		boolean[] cep_utilizado = new boolean[999999999];
		List<Loja> lojas = repository.findAll();
		for (Loja loja : lojas) {
			for (CepRange range : loja.getFaixas()) {
				 for(int i=range.getFAIXA_INICIO(); i<range.getFAIXA_FIM(); i++) {
					 cep_utilizado[i] = true; 
				}
			}
		}
		
		 for(int i=new_range.getFAIXA_INICIO(); i<new_range.getFAIXA_FIM(); i++) {
			 if (cep_utilizado[i]) {
				 return null;
			 }
		}
		
		loja1.AddFaixa(new_range);
		repository.save(loja1);
		return loja1;
	}

	
}
