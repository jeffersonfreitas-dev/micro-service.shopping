package dev.jefferson.service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jefferson.dto.CompraDTO;
import dev.jefferson.dto.ItemDTO;
import dev.jefferson.dto.ProdutoDTO;
import dev.jefferson.exceptions.RegistroNaoEncontradoException;
import dev.jefferson.model.Compra;
import dev.jefferson.model.dto.DTOConvert;
import dev.jefferson.repository.CompraRepository;

@Service
public class CompraService {

	@Autowired
	private CompraRepository repository;
	@Autowired
	private UsuarioService userService;
	@Autowired
	private ProdutoService produtoService;
	
	
	public List<CompraDTO> getCompras() {
		return repository.findAll().stream()
				.map(DTOConvert::convert)
				.collect(Collectors.toList());
	}


	@Transactional
	public CompraDTO save(String idUser, CompraDTO dto) {
		if (userService.getUserByCpf(idUser, dto.getUsuarioId()) == null) {
			return null;
		};
		
		if(!validarProdutos(dto.getItems())) {
			throw new RegistroNaoEncontradoException(null);
		}
		
		dto.setTotal(dto.getItems().stream().map(e -> e.getPreco()).reduce(0F, Float::sum));
		Compra compra = Compra.convert(dto);
		compra.setDate(new Date());
		compra = repository.save(compra);
		return DTOConvert.convert(compra);
	}



	public List<CompraDTO> filter(Date dataInicio, Date dataFim, Float valor) {
		List<Compra> compras = repository.filter(dataInicio, dataFim, valor);
		return compras.stream()
				.map(DTOConvert::convert)
				.collect(Collectors.toList());
	}
	
	
	private boolean validarProdutos(List<ItemDTO> list) {
		for(ItemDTO dto  :list) {
			ProdutoDTO prod = produtoService.getProdutoByIdentifier(dto.getProdutoId());
			if(prod == null) {
				return false;
			}
			dto.setPreco(prod.getPreco());
		}
		return true;
	}

}
