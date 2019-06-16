package com.uol.clientrest.model;

import java.io.Serializable;

import org.springframework.data.annotation.Id;

public class Cliente implements Serializable {

	private static final long serialVersionUID = 4173949143018581027L;

	@Id
	private String id;
	private String nome;
	private Integer idade;
	
	public Cliente( ) { }
	
	public Cliente(String id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nome=" + nome + ", idade=" + idade + "]";
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
