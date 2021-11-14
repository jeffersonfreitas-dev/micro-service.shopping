package dev.jefferson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
