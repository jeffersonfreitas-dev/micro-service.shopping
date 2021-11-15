package dev.jefferson.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import dev.jefferson.dto.UsuarioDTO;

@Entity
@Table(name = "usuario")
public class Usuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;
	private String nome;
	private String endereco;
	private String cpf;
	
	public Usuario() {};
	
	public Usuario(String id, String nome, String endereco, String cpf) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}
	
	
	public Usuario(String nome, String endereco, String cpf) {
		this.id = UUID.randomUUID().toString();
		this.nome = nome;
		this.cpf = cpf;
		this.endereco = endereco;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
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
	
	public static Usuario convert(UsuarioDTO dto) {
		Usuario user = new Usuario();
		user.setCpf(dto.getCpf());
		user.setEndereco(dto.getEndereco());
		user.setId(dto.getId());
		user.setNome(dto.getNome());
		return user;
	}

}
