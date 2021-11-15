package dev.jefferson.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

import dev.jefferson.dto.ItemDTO;

@Embeddable
public class Item {

	@Column(name = "produto_id")
	private String produtoId;
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

	public static Item convert(ItemDTO dto) {
		Item item = new Item();
		item.setPreco(dto.getPreco());
		item.setProdutoId(dto.getProdutoId());
		return item;
	}
}
