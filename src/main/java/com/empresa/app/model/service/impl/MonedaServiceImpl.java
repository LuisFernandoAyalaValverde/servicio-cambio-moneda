package com.empresa.app.model.service.impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.app.model.bean.ActualizarTipoCambioReq;
import com.empresa.app.model.bean.ActualizarTipoCambioResp;
import com.empresa.app.model.bean.CambioMonedaReq;
import com.empresa.app.model.bean.CambioMonedaResp;
import com.empresa.app.model.entity.Moneda;
import com.empresa.app.model.entity.TipoCambio;
import com.empresa.app.model.repository.MonedaRepository;
import com.empresa.app.model.repository.TipoCambioRepository;
import com.empresa.app.model.service.MonedaService;
import com.empresa.app.util.ApiResponse;

@Service
public class MonedaServiceImpl implements MonedaService{
	
	@Autowired
	private MonedaRepository monedaRepository;
	
	@Autowired
	private TipoCambioRepository tipoCambioRepository;

	@Override
	public ApiResponse<CambioMonedaResp> aplicarTipoCambio(CambioMonedaReq cambioMonedaReq) {
		CambioMonedaResp resp = new CambioMonedaResp();
		BigDecimal montoFinal;

		Moneda monedaOrigen = monedaRepository.obtenerMoneda(cambioMonedaReq.getMonedaOrigen());
		Moneda monedaDestino = monedaRepository.obtenerMoneda(cambioMonedaReq.getMonedaDestino());
		
		if(monedaDestino != null && monedaOrigen != null) {
			
			TipoCambio tipoCambio = tipoCambioRepository.obtenerTipoCambio(monedaOrigen, monedaDestino);
			if(tipoCambio != null) {
				montoFinal = cambioMonedaReq.getMonto().multiply(tipoCambio.getValor());
				
				resp.setMonto(cambioMonedaReq.getMonto());
				resp.setMontoTipoCambio(montoFinal);
				resp.setMonedaOrigen(cambioMonedaReq.getMonedaOrigen());
				resp.setMonedaDestino(cambioMonedaReq.getMonedaDestino());
				resp.setTipoCambio(tipoCambio.getValor());
				return new ApiResponse<>(true, resp, "Se aplico el tipo de cambio con exito");
			}
		}
		return new ApiResponse<>(false, null, "Error al aplicar el tipo de cambio");
	}

	@Override
	public ApiResponse<ActualizarTipoCambioResp> actualizarTipoCambio(ActualizarTipoCambioReq actualizarTipoCambioReq) {
		ActualizarTipoCambioResp resp = new ActualizarTipoCambioResp();
		
		Moneda monedaOrigen = monedaRepository.obtenerMoneda(actualizarTipoCambioReq.getMonedaOrigen());
		Moneda monedaDestino = monedaRepository.obtenerMoneda(actualizarTipoCambioReq.getMonedaDestino());
		
		if(monedaDestino != null && monedaOrigen != null) {
			TipoCambio tipoCambio = tipoCambioRepository.actualizarTipoCambio(monedaOrigen, monedaDestino, actualizarTipoCambioReq.getTipoCambio());
			resp.setMonedaOrigen(monedaOrigen.getCodigo());
			resp.setMonedaDestino(monedaDestino.getCodigo());
			resp.setTipoCambio(tipoCambio.getValor());
			return new ApiResponse<>(true, resp, "Se actualizo el registro con exito");
		}
		
		return new ApiResponse<>(false, null, "Error al actualizar el registro");
	}

}
