package dev.jefferson.model.dto;

import dev.jefferson.dto.UsuarioDTO;
import dev.jefferson.model.Usuario;

public class DTOConverter {
	
	public static UsuarioDTO convert(Usuario usuario) {
		UsuarioDTO dto = new UsuarioDTO();
		dto.setCpf(usuario.getCpf());
		dto.setEndereco(usuario.getEndereco());
		dto.setId(usuario.getId());
		dto.setNome(usuario.getNome());
		return dto;		
	}

}
