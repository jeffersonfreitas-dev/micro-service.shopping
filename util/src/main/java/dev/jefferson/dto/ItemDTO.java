package dev.jefferson.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ItemDTO {

	@NotBlank(message = "Informe o código de identificação do produto")
	private String produtoId;
	@NotNull(message = "Informe o preço")
	private float preco;

	public String getProdutoId() {
		return produtoId;
	}

	public void setProdutoId(String produtoId) {
		this.produtoId = produtoId;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}


}
