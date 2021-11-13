package dev.jefferson.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.jefferson.model.dto.UsuarioDTO;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private UUID id;
	private String nome;
	private String endereco;
	private String cpf;
	
	public Usuario() {};
	
	public Usuario(UUID id, String nome, String endereco, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	
	public Usuario(String nome, String endereco, String cpf) {
		this.id = UUID.randomUUID();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public static UsuarioDTO convert(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCpf(usuario.getCpf());
		dto.setEndereco(usuario.getEndereco());
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		return dto;
	}

}
