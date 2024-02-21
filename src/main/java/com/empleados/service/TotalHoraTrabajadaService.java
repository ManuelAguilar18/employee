package com.empleados.service;

import com.empleados.dto.HourReq;
import com.empleados.dto.HourResp;

public interface TotalHoraTrabajadaService {

	/**
	 * 
	 * @param hourReq
	 * @return
	 */
	HourResp totalHorasTrabajador(HourReq hourReq);

}
