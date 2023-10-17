package com.empresa.app.model.repository.impl;

import org.springframework.stereotype.Repository;
import com.empresa.app.model.entity.Moneda;
import com.empresa.app.model.repository.MonedaRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class MonedaRepositoryImpl implements MonedaRepository{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public Moneda obtenerMoneda(String codigo) {
		String sql = "SELECT id, codigo, descripcion FROM moneda WHERE codigo = :codigo";

        Query consulta = entityManager.createNativeQuery(sql, Moneda.class);
        consulta.setParameter("codigo", codigo);

        try {
            return (Moneda) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

}
