package com.empresa.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.app.model.bean.ActualizarTipoCambioReq;
import com.empresa.app.model.bean.ActualizarTipoCambioResp;
import com.empresa.app.model.bean.CambioMonedaReq;
import com.empresa.app.model.bean.CambioMonedaResp;
import com.empresa.app.model.service.MonedaService;
import com.empresa.app.util.ApiResponse;

@RestController
@RequestMapping("tipocambio")
public class TipoCambioController {
	
	@Autowired
	private MonedaService monedaService;
	
	@GetMapping("/convertir")
	public ApiResponse<CambioMonedaResp> aplicarTipoCambio(@RequestBody CambioMonedaReq cambioMonedaReq) {
		return monedaService.aplicarTipoCambio(cambioMonedaReq);
	}
	
	@PostMapping("/actualizar")
    public ApiResponse<ActualizarTipoCambioResp> actualizarTipoCambio(@RequestBody ActualizarTipoCambioReq actualizarTipoCambioReq) {
		return monedaService.actualizarTipoCambio(actualizarTipoCambioReq);
    }
	
}
