package dev.jefferson.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.jefferson.model.Compra;

public interface CompraRepository extends JpaRepository<Compra, Long>, FilterRepository{

}
