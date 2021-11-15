package dev.jefferson.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.dto.ProdutoDTO;
import dev.jefferson.service.ProdutoService;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

	@Autowired
	private ProdutoService service;
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<ProdutoDTO> getProdutos(){
		return service.getProdutos();
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public ProdutoDTO newProduto(@RequestBody @Valid ProdutoDTO dto) {
		return service.save(dto);
	}
	
	@GetMapping("{produtoId}")
	@ResponseStatus(HttpStatus.OK)
	public ProdutoDTO findProdutoId(@PathVariable String produtoId) {
		return service.findByProdutoIdentificador(produtoId);
	}
	
	@GetMapping("/categoria/{idCategoria}")
	@ResponseStatus(HttpStatus.OK)
	public List<ProdutoDTO> getAllByCategoria(@PathVariable Long idCategoria){
		return service.findProdutosByCategoria(idCategoria);
	}
}
