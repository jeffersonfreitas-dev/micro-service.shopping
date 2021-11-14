package dev.jefferson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{
	

}
