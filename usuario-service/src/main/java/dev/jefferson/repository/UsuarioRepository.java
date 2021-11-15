package dev.jefferson.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String>{

	Optional<Usuario> findByCpfIgnoreCase(String cpf);
	

}
