package com.empleados.service;

import com.empleados.dto.AddHourReq;
import com.empleados.dto.AddHourResp;

public interface AltaHorasService {

	/**
	 * Metodo alta de horas
	 * @param hourReq
	 * @return
	 */
	AddHourResp altaHoras(AddHourReq hourReq);

}
