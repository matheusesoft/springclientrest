package com.uol.clientrest.persistence.model;

import java.io.Serializable;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

@Entity(name="cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 4173949143018581027L;

	@Id @GeneratedValue
	private long id;
	private String nome;
	private Integer idade;
	
	public Cliente( ) { }
	
	public Cliente(long id, String nome, Integer idade) {
		this.id = id;
		this.nome = nome;
		this.idade = idade;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("cliente [id=");
		builder.append(id);
		builder.append(", ");
		if (nome != null) {
			builder.append("nome=");
			builder.append(nome);
			builder.append(", ");
		}
		if (idade != null) {
			builder.append("idade=");
			builder.append(idade);
			builder.append(", ");
		}
		builder.append("]");
		return builder.toString();
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

	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}
}
