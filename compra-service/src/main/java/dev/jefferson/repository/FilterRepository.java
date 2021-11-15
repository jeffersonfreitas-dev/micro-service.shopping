package dev.jefferson.repository;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import dev.jefferson.model.Compra;

@Repository
public interface FilterRepository {

	List<Compra> filter (Date dataInicio, Date dataFim, Float valor);
	
}
