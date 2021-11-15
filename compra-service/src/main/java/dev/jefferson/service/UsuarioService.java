package dev.jefferson.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dev.jefferson.dto.UsuarioDTO;
import dev.jefferson.exceptions.RegistroNaoEncontradoException;

@Service
public class UsuarioService {
	
	public UsuarioDTO getUserByCpf(String cpf) {
		String url = "http://localhost:8081/usuarios/cpf/" + cpf;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UsuarioDTO> result = restTemplate.getForEntity(url, UsuarioDTO.class);
			return result.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new RegistroNaoEncontradoException("Usuário com CPF informado não encontrado");
		}
	}

}
