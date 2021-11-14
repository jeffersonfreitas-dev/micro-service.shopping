package dev.jefferson.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import dev.jefferson.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{
	
	public Optional<Produto> findByProdutoId(String produtoId);
	
	@Query("select p from Produto p join Categoria c on c.id = p.categoria.id where c.id = :idCategoria")
	List<Produto> getProdutoByCategoria(@Param("idCategoria") long idCategoria);

}
