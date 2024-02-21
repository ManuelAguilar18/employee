/**
 * 
 */
package com.empleados.service;

import com.empleados.dto.NewEmployeeReq;
import com.empleados.dto.NewEmployeeResp;

/**
 * Service de Alta Empleado
 */
public interface AltaEmpleadoService {

	/**
	 * Alta de empleado
	 * @param employeeReq
	 * @return
	 */
	NewEmployeeResp altaEmpledo(NewEmployeeReq employeeReq);

}
