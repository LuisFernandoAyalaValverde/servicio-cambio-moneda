package com.empresa.app.model.repository;

import com.empresa.app.model.entity.Moneda;

public interface MonedaRepository {
	
	Moneda obtenerMoneda(String codigo);

}
