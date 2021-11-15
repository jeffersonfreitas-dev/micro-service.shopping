package dev.jefferson.dto;

import java.util.Date;
import java.util.List;

import javax.validation.constraints.NotBlank;

public class CompraDTO {

	private long id;
	@NotBlank(message = "Informe o código de identificação do cliente")
	private String usuarioId;
	private float total;
	private Date date;
	private List<ItemDTO> items;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsuarioId() {
		return usuarioId;
	}

	public void setUsuarioId(String usuarioId) {
		this.usuarioId = usuarioId;
	}

	public float getTotal() {
		return total;
	}

	public void setTotal(float total) {
		this.total = total;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public List<ItemDTO> getItems() {
		return items;
	}

	public void setItems(List<ItemDTO> items) {
		this.items = items;
	}

}
