package com.empresa.app.model.repository;

import java.math.BigDecimal;

import com.empresa.app.model.entity.Moneda;
import com.empresa.app.model.entity.TipoCambio;

public interface TipoCambioRepository {
	
	TipoCambio obtenerTipoCambio(Moneda monedaOrigen, Moneda monedaDestino);
	TipoCambio actualizarTipoCambio(Moneda monedaOrigen, Moneda monedaDestino, BigDecimal tipoCambio);

}
