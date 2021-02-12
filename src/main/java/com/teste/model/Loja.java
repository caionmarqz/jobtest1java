package com.teste.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="loja")
public class Loja {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	long id;
	String nome;
	
	@OneToMany(targetEntity=faixas.class, mappedBy="faixas", fetch=FetchType.EAGER)
	List<CepRange> faixas;

	public Loja () {
		//faixas = new List<CepRange>();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public List<CepRange> getFaixas() {
		return faixas;
	}
	
	public CepRange getFaixa(int _id) {
		return faixas.get(_id);
	}	
	
	public void AddFaixa(CepRange cep) {
		faixas.add(cep);
	}
	
	public void setFaixa(CepRange cep, int _id) {
		faixas.set(_id, cep);
	}
	
}