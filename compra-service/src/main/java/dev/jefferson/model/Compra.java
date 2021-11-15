package dev.jefferson.model;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import dev.jefferson.dto.CompraDTO;

@Entity
@Table(name = "compra")
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name = "user_id")
	private String usuarioId;
	private float total;
	private Date date;

	@ElementCollection(fetch = FetchType.EAGER)
	@CollectionTable(name = "item", joinColumns = @JoinColumn(name = "id_compra"))
	private List<Item> items;

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

	public List<Item> getItems() {
		return items;
	}

	public void setItems(List<Item> items) {
		this.items = items;
	}
	
	
	public static Compra convert(CompraDTO dto) {
		Compra compra = new Compra();
		compra.setDate(dto.getDate());
		compra.setTotal(dto.getTotal());
		compra.setUsuarioId(dto.getUsuarioId());
		compra.setItems(dto.getItems().stream().map(Item::convert).collect(Collectors.toList()));
		return compra;
	}

}
