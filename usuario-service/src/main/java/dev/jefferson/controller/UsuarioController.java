package dev.jefferson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.dto.UsuarioDTO;
import dev.jefferson.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<UsuarioDTO> getUsuarios(){
		return service.getAll();
	}
	
	
	@PostMapping
	public ResponseEntity<UsuarioDTO> newUsuario(@RequestBody UsuarioDTO dto) {
		UsuarioDTO result = service.save(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
	
	
	@GetMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO getUsuario(@PathVariable String id) {
		return service.getUsuario(id);
	}
	
	
	@DeleteMapping("{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable String id){
		service.delete(id);
	}
	
	
	@PutMapping("{id}")
	@ResponseStatus(HttpStatus.OK)
	public UsuarioDTO update(@PathVariable String id, @RequestBody UsuarioDTO dto) {
		return service.update(id, dto);
	}
	
	@GetMapping("/cpf/{cpf}")
	public UsuarioDTO getUserByCpf(@RequestParam(name = "id") String id, @PathVariable String cpf) {
		return service.getUserByCpf(id, cpf);
	}
}
