package dev.jefferson.dto;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ProdutoDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private long id;
	@NotBlank(message = "Informe o nome do produto")
	private String nome;

	@NotNull(message = "Informe um preço para o produto")
	private Float preco;
	private String descricao;
	private String produtoId;
	private CategoriaDTO categoria;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Float getPreco() {
		return preco;
	}

	public void setPreco(Float preco) {
		if(preco < 0F) throw new IllegalArgumentException("Preço inicial não pode ser negativo!");
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getProdutoId() {
		return produtoId;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public CategoriaDTO getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaDTO categoria) {
		this.categoria = categoria;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

}
