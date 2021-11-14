package dev.jefferson.model.dto;

import java.io.Serializable;

import dev.jefferson.CpfCnpjValidation;
import dev.jefferson.model.Usuario;

public class UsuarioDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private String id;
	private String nome;
	private String endereco;
	private String cpf;

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
		if(nome == null) throw new IllegalArgumentException("Nome não pode ser nulo");
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
	
	
	public static UsuarioDTO convert(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCpf(usuario.getCpf());
		dto.setEndereco(usuario.getEndereco());
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		return dto;
	}

}
