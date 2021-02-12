package com.teste;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.teste.model.CepRange;
import com.teste.model.Loja;
import com.teste.repository.TesteRepository;

@SpringBootApplication
public class TesteProgramacaoApplication implements CommandLineRunner {

	@Autowired
	TesteRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(TesteProgramacaoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {

		/*
		 * Cria uma tabela com valores padrões caso não exista
		 * 
		 */

		if (repository.count() == 0) {

			Loja loja1 = new Loja();
			loja1.setNome("Loja_Pinheiros");

			CepRange range1 = new CepRange();
			range1.setFAIXA_INICIO(10000000);
			range1.setFAIXA_FIM(20000000);
			loja1.AddFaixa(range1);

			CepRange range2 = new CepRange();
			range2.setFAIXA_INICIO(20000001);
			range2.setFAIXA_FIM(30000000);
			loja1.AddFaixa(range2);

			Loja loja2 = new Loja();
			loja2.setNome("Loja_Jardins");

			CepRange range3 = new CepRange();
			range3.setFAIXA_INICIO(30000001);
			range3.setFAIXA_FIM(40000000);
			loja2.AddFaixa(range3);

			CepRange range4 = new CepRange();
			range4.setFAIXA_INICIO(40000001);
			range4.setFAIXA_FIM(50000000);
			loja2.AddFaixa(range4);

			repository.save(loja1);
			repository.save(loja2);

		}

	}

}
