package com.empresa.app.model.repository.impl;

import java.math.BigDecimal;

import org.springframework.stereotype.Repository;

import com.empresa.app.model.entity.Moneda;
import com.empresa.app.model.entity.TipoCambio;
import com.empresa.app.model.repository.TipoCambioRepository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

@Repository
public class TipoCambioRepositoryImpl implements TipoCambioRepository{
	
	@PersistenceContext
    private EntityManager entityManager;

	@Override
	public TipoCambio obtenerTipoCambio(Moneda monedaOrigen, Moneda monedaDestino) {
		String sql = "SELECT id, moneda_origen_id, moneda_destino_id, valor FROM tipo_cambio WHERE moneda_origen_id = :monedaOrigenId AND moneda_destino_id = :monedaDestinoId";

        Query consulta = entityManager.createNativeQuery(sql, TipoCambio.class);
        consulta.setParameter("monedaOrigenId", monedaOrigen.getId());
        consulta.setParameter("monedaDestinoId", monedaDestino.getId());

        try {
            return (TipoCambio) consulta.getSingleResult();
        } catch (NoResultException e) {
            return null;
        }
	}

	@Override
	@Transactional
	public TipoCambio actualizarTipoCambio(Moneda monedaOrigen, Moneda monedaDestino, BigDecimal valorTipoCambio) {
		int filaAfectada;
		String sql = "UPDATE tipo_cambio SET valor = :valorTipoCambio WHERE moneda_origen_id = :monedaOrigenId AND moneda_destino_id = :monedaDestinoId";
        Query consulta = entityManager.createNativeQuery(sql);
     
        consulta.setParameter("valorTipoCambio", valorTipoCambio);
        consulta.setParameter("monedaOrigenId", monedaOrigen.getId());
        consulta.setParameter("monedaDestinoId", monedaDestino.getId());

        filaAfectada = consulta.executeUpdate();
        
        if(filaAfectada > 0) {
        	return obtenerTipoCambio(monedaOrigen, monedaDestino);
        }else {
        	return null;
        }
	}

}
