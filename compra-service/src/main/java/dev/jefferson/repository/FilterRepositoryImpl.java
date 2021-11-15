package dev.jefferson.repository;

import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import dev.jefferson.model.Compra;

public class FilterRepositoryImpl implements FilterRepository{
	
	@PersistenceContext 
	private EntityManager manager;

	@Override
	@SuppressWarnings("unchecked")
	public List<Compra> filter(Date dataInicio, Date dataFim, Float valor) {
		String sql = getSql(dataInicio, dataFim, valor);
		Query query = manager.createQuery(sql);
		query.setParameter("dataInicio", dataInicio);
		setParameters(query, dataFim, valor);
		return query.getResultList();
	}

	
	private void setParameters(Query query, Date dataFim, Float valor) {
		if(dataFim != null) {
			query.setParameter("dataFim", dataFim);
		}
		
		if(valor != null) {
			query.setParameter("valor", valor);
		}
		
	}


	private String getSql(Date dataInicio, Date dataFim, Float valor) {
		if(dataInicio == null) throw new IllegalArgumentException("Data inicio é obrigatória");
		StringBuilder sb = new StringBuilder();
		sb.append("select c from Compra c where c.date >= :dataInicio ");
		
		if(dataFim != null) {
			sb.append("and date <= :dataFim ");
		}
		
		if(valor != null) {
			sb.append("and total >= :valor");
		}
		return sb.toString();
	}

}
