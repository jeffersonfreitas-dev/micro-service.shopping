package dev.jefferson.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jefferson.exceptions.RegistroNaoEncontradoException;
import dev.jefferson.model.Categoria;
import dev.jefferson.model.Produto;
import dev.jefferson.model.dto.ProdutoDTO;
import dev.jefferson.repository.CategoriaRepository;
import dev.jefferson.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository repository;
	@Autowired
	private CategoriaRepository catRepository;
	

	private ModelMapper mapper = new ModelMapper();
	
	
	public List<ProdutoDTO> getProdutos() {
		List<Produto> produtos = repository.findAll();
		return produtos.stream()
				.map(p -> mapper.map(p, ProdutoDTO.class))
				.collect(Collectors.toList());
	}


	@Transactional
	public ProdutoDTO save(ProdutoDTO dto) {
		if(dto.getCategoria() == null) {
			throw new NullPointerException("Categoria deve ser informada");
		}
		dto.setProdutoId(UUID.randomUUID().toString());
		Produto produto = mapper.map(dto, Produto.class);
		produto.setCategoria(getCategoria(dto.getCategoria().getId()));
		produto = repository.save(produto);
		return mapper.map(produto, ProdutoDTO.class);
	}


	public ProdutoDTO findByProdutoIdentificador(String codigo) {
		Produto produto = repository.findByProdutoId(codigo).orElseThrow( 
				() -> new RegistroNaoEncontradoException("Registro não encontrado com o identificador: " + codigo));
		return mapper.map(produto, ProdutoDTO.class);
	}

	
	private Categoria getCategoria(Long id) {
		if(id == 0) throw new IllegalArgumentException("O ID da categoria deve ser informada");
		return catRepository.findById(id).orElseThrow( 
				()-> new RegistroNaoEncontradoException("Categoria não encontrada com id: " + id));
	}


	public List<ProdutoDTO> findProdutosByCategoria(Long id) {
		List<Produto> result = repository.getProdutoByCategoria(id);
		if(!result.isEmpty()) {
			return result.stream()
					.map(e -> mapper.map(e, ProdutoDTO.class))
					.collect(Collectors.toList());
		}
		return new ArrayList<>();
	}



}
