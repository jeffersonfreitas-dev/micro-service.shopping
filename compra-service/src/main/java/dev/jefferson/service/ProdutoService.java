package dev.jefferson.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import dev.jefferson.dto.ProdutoDTO;
import dev.jefferson.exceptions.RegistroNaoEncontradoException;

@Service
public class ProdutoService {
	
	public ProdutoDTO getProdutoByIdentifier(String identif) {
		String url = "http://localhost:8082/produtos/" + identif;
		try {
			RestTemplate restTemplate = new RestTemplate();
			ResponseEntity<ProdutoDTO> result = restTemplate.getForEntity(url, ProdutoDTO.class);
			return result.getBody();
		} catch (HttpClientErrorException.NotFound e) {
			throw new RegistroNaoEncontradoException("Produto não encontrado com a idenfiticação informada");
		}
	}

}
