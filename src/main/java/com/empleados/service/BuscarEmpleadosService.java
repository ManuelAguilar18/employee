package com.empleados.service;

import com.empleados.dto.EmployeeReq;
import com.empleados.dto.EmployeeResp;

public interface BuscarEmpleadosService {

	/**
	 * 
	 * @param employeeReq
	 * @return
	 */
	EmployeeResp buscarEmpleados(EmployeeReq employeeReq);

}
