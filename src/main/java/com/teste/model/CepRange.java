package com.teste.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="cepranges")
public class CepRange {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	long CODIGO_LOJA;
	int FAIXA_INICIO;
	int FAIXA_FIM;

	public CepRange(long id, long cODIGO_LOJA, int fAIXA_INICIO, int fAIXA_FIM) {
		//super();
		this.id = id;
		CODIGO_LOJA = cODIGO_LOJA;
		FAIXA_INICIO = fAIXA_INICIO;
		FAIXA_FIM = fAIXA_FIM;
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
		return CODIGO_LOJA;
	}
	public void setCODIGO_LOJA(long cODIGO_LOJA) {
		CODIGO_LOJA = cODIGO_LOJA;
	}
	public int getFAIXA_INICIO() {
		return FAIXA_INICIO;
	}
	public void setFAIXA_INICIO(int fAIXA_INICIO) {
		FAIXA_INICIO = fAIXA_INICIO;
	}
	public int getFAIXA_FIM() {
		return FAIXA_FIM;
	}
	public void setFAIXA_FIM(int fAIXA_FIM) {
		FAIXA_FIM = fAIXA_FIM;
	}
}
