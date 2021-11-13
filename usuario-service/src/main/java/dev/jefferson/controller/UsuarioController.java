package dev.jefferson.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jefferson.controller.service.UsuarioService;
import dev.jefferson.model.dto.UsuarioDTO;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
	
	@Autowired
	private UsuarioService service;
	
	
	@GetMapping
	public List<UsuarioDTO> getUsuarios(){
		return service.getAll();
	}
}
