package dev.jefferson.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "produto")
public class Produto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private long id;
	private String nome;
	private Float preco;
	private String descricao;
	@Column(name = "produto_id")
	private String produtoId;
	
	@ManyToOne
	@JoinColumn(name = "id_categoria")
	private Categoria categoria;
	
	public Produto() {};
	
	public Produto(String nome, String descricao) {
		setId(this.id);
		this.nome = nome;
		this.preco = 0F;
		this.descricao = descricao;
		this.produtoId = UUID.randomUUID().toString();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = gerarRandom();
	}


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

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	private long gerarRandom() {
		long mix = (long) (Math.random() * 100000);
		return mix;
	}

}
