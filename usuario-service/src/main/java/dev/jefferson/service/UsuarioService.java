package dev.jefferson.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.jefferson.dto.UsuarioDTO;
import dev.jefferson.exceptions.RegistroNaoEncontradoException;
import dev.jefferson.model.Usuario;
import dev.jefferson.model.dto.DTOConverter;
import dev.jefferson.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository repository;

	
	public List<UsuarioDTO> getAll() {
		List<Usuario> result = repository.findAll();
		return result.stream()
				.map(DTOConverter::convert)
				.collect(Collectors.toList());
	}


	@Transactional
	public UsuarioDTO save(UsuarioDTO dto) {
		Usuario usuario = new Usuario(dto.getNome(), dto.getEndereco(), dto.getCpf());
		usuario = repository.save(usuario);
		return DTOConverter.convert(usuario);
	}


	public UsuarioDTO getUsuario(String id) {
		Usuario user = verificarUsuarioExiste(id);
		return DTOConverter.convert(user);
	}



	@Transactional
	public void delete(String id) {
		UsuarioDTO dto = getUsuario(id);
		repository.deleteById(dto.getId());
	}


	@Transactional
	public UsuarioDTO update(String id, UsuarioDTO dto) {
		Usuario user = verificarUsuarioExiste(id);
		user.setCpf(dto.getCpf());
		user.setEndereco(dto.getEndereco());
		user.setNome(dto.getNome());
		user = repository.save(user);
		return DTOConverter.convert(user);
	}
	
	
	private Usuario verificarUsuarioExiste(String id) {
		Usuario user = repository.findById(id).orElseThrow(
				() -> new RegistroNaoEncontradoException("Registro não encontrado com id: " + id));
		return user;
	}


	public UsuarioDTO getUserByCpf(String id, String cpf) {
		Usuario user = repository.findByIdAndCpf(id, cpf).orElseThrow( 
				() -> new RegistroNaoEncontradoException("Usuário com Cpf ou ID informado não encontrado: " + cpf));
		return DTOConverter.convert(user);
	}

}
