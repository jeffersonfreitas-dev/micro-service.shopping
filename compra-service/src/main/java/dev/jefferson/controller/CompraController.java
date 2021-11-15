package dev.jefferson.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.dto.CompraDTO;
import dev.jefferson.service.CompraService;

@RestController
@RequestMapping("/compras")
public class CompraController {
	
	@Autowired
	private CompraService service;

	@GetMapping
	public ResponseEntity<List<CompraDTO>> getCompras(){
		return ResponseEntity.status(HttpStatus.OK).body(service.getCompras());
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public CompraDTO newCompra(@RequestParam(name = "id", required = true) String idUser, @RequestBody CompraDTO dto) {
		return service.save(idUser, dto);
	}
	
	@GetMapping("/filter")
	@ResponseStatus(HttpStatus.OK)
	public List<CompraDTO> filter(
			@RequestParam(name = "dataInicio", required = true) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataInicio,
			@RequestParam(name = "dataFim", required = false) @DateTimeFormat(pattern = "dd/MM/yyyy") Date dataFim,
			@RequestParam(name = "valor", required = false) Float valor){
		
		return service.filter(dataInicio, dataFim, valor);
		
	}
}
