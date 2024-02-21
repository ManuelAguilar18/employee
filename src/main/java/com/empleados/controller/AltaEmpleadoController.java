/**
 * 
 */
package com.empleados.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.dto.NewEmployeeReq;
import com.empleados.dto.NewEmployeeResp;
import com.empleados.service.AltaEmpleadoService;

/**
 * 
 */
@RestController
@RequestMapping("empleado")
public class AltaEmpleadoController {

	private final static Logger log = Logger.getLogger(AltaEmpleadoController.class);
	
	@Autowired
	AltaEmpleadoService service;
	
	@PostMapping(value = "/altaempleado", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public NewEmployeeResp altaEmpledo(@RequestBody NewEmployeeReq employeeReq) {
		
		log.debug("Inicia el alta de empleado");
		
		NewEmployeeResp resp = service.altaEmpledo(employeeReq);
		
		
		log.debug("Fin de alta de empleado");

		return resp;
	}
}
