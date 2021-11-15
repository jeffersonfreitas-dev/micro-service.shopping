package dev.jefferson.model.dto;

import java.util.stream.Collectors;

import dev.jefferson.dto.CompraDTO;
import dev.jefferson.dto.ItemDTO;
import dev.jefferson.model.Compra;
import dev.jefferson.model.Item;

public class DTOConvert {
	
	public static ItemDTO convert(Item item) {
		ItemDTO dto = new ItemDTO();
		dto.setPreco(item.getPreco());
		dto.setProdutoId(item.getProdutoId());
		return dto;
	}
	
	public static CompraDTO convert(Compra compra) {
		CompraDTO dto = new CompraDTO();
		dto.setDate(compra.getDate());
		dto.setTotal(compra.getTotal());
		dto.setUsuarioId(compra.getUsuarioId());
		dto.setItems(compra.getItems().stream().map(DTOConvert::convert).collect(Collectors.toList()));
		return dto;
	}

}
