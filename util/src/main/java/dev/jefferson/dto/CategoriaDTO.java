package dev.jefferson.dto;

import javax.validation.constraints.NotBlank;

public class CategoriaDTO {

	private long id;
	@NotBlank(message = "Informe o nome da categoria")
	private String nome;

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

}
