package com.empleados.service;

import com.empleados.dto.PayEmployeeReq;
import com.empleados.dto.PayEmployeeResp;

public interface TotalSalarioTrabajadaService {

	/**
	 * 
	 * @param payEmployeeReq
	 * @return
	 */
	PayEmployeeResp totalSalarioTrabajador(PayEmployeeReq payEmployeeReq);

}
