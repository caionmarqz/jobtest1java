package com.teste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity(name = "CepRange")
@Table(name="cepranges")
public class CepRange {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long codigo_loja;
	int faixa_inicio;
	int faixa_fim;

	public CepRange(long id, long cODIGO_LOJA, int fAIXA_INICIO, int fAIXA_FIM) {
		super();
		this.id = id;
		codigo_loja = cODIGO_LOJA;
		faixa_inicio = fAIXA_INICIO;
		faixa_fim = fAIXA_FIM;
	}

	public CepRange() {
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getCODIGO_LOJA() {
		return codigo_loja;
	}
	public void setCODIGO_LOJA(long cODIGO_LOJA) {
		codigo_loja = cODIGO_LOJA;
	}
	public int getFAIXA_INICIO() {
		return faixa_inicio;
	}
	public void setFAIXA_INICIO(int fAIXA_INICIO) {
		faixa_inicio = fAIXA_INICIO;
	}
	public int getFAIXA_FIM() {
		return faixa_fim;
	}
	public void setFAIXA_FIM(int fAIXA_FIM) {
		faixa_fim = fAIXA_FIM;
	}
}
