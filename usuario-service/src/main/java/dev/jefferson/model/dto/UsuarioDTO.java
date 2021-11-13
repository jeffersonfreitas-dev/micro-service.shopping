package dev.jefferson.model.dto;

import java.io.Serializable;
import java.util.UUID;

import dev.jefferson.CpfCnpjValidation;
import dev.jefferson.model.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private UUID id;
	private String nome;
	private String endereco;
	private String cpf;

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		if(id == null) throw new IllegalArgumentException("ID não pode ser nulo");
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		if(id == null) throw new IllegalArgumentException("Nome não pode ser nulo");
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
		if(cpf != null) {
			if(!CpfCnpjValidation.isValid(cpf)) {
				throw new IllegalArgumentException("CPF inválido"); 
			}
		}
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
