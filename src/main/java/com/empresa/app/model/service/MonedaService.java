package com.empresa.app.model.service;

import com.empresa.app.model.bean.ActualizarTipoCambioReq;
import com.empresa.app.model.bean.ActualizarTipoCambioResp;
import com.empresa.app.model.bean.CambioMonedaReq;
import com.empresa.app.model.bean.CambioMonedaResp;
import com.empresa.app.util.ApiResponse;

public interface MonedaService {
	
	ApiResponse<CambioMonedaResp> aplicarTipoCambio(CambioMonedaReq cambioMonedaReq);
	ApiResponse<ActualizarTipoCambioResp> actualizarTipoCambio(ActualizarTipoCambioReq actualizarTipoCambioReq);

}
