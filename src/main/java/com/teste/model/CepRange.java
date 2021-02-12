package com.teste.model;

import javax.persistence.Column;
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
//	@Column("ID")
	long id;
//	@Column("CODIGO_LOJA")
	long codigo_loja;
//	@Column("FAIXA_INICIO")
	int faixa_inicio;
//	@Column("FAIXA_FIM")
	int faixa_fim;

	

	
	
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
