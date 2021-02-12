package com.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.teste.model.CepRange;
import com.teste.model.Loja;
import com.teste.repository.TesteRepository;

@SpringBootApplication
public class TesteProgramacaoApplication implements CommandLineRunner{
	
	@Autowired
	TesteRepository repository;

	public static void main(String[] args){
		SpringApplication.run(TesteProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		
		Loja loja1 = new Loja();
		loja1.setNome("Loja_Pinheiros");
		CepRange range1 = new CepRange();
		range1.setFAIXA_INICIO(10000001);
		range1.setFAIXA_FIM(20000000);
		CepRange range2 = new CepRange();
		range2.setFAIXA_INICIO(20000001);
		range2.setFAIXA_FIM(30000000);
		loja1.AddFaixa(range1); //####### ERRO ########
		loja1.AddFaixa(range2);
		
		
//		Loja loja2 = new Loja();	
//		loja2.setNome("Loja_Jardins");
//		loja2.AddFaixa(new CepRange(0, 2, 30000001,40000000));
//		loja2.AddFaixa(new CepRange(0, 2, 40000001,50000000));		
	
		
		repository.save(loja1);
//		repository.save(loja2);

		
		
	}

}