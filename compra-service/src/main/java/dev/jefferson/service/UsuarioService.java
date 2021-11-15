package dev.jefferson.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dev.jefferson.dto.UsuarioDTO;
import dev.jefferson.exceptions.RegistroNaoEncontradoException;

@Service
public class UsuarioService {
	
	@Value("${USUARIO_API_URL:http://localhost:8081/usuarios}")
	private String url;
	
	public UsuarioDTO getUserByCpf(String id, String cpf) {
		url = url + "/cpf/" + cpf + "?id=" + id;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<UsuarioDTO> result = restTemplate.getForEntity(url, UsuarioDTO.class);
			return result.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new RegistroNaoEncontradoException("Usuário com CPF ou ID informado não encontrado");
		}
	}

}
