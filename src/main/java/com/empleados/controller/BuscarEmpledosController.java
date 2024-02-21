package com.empleados.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.dto.EmployeeReq;
import com.empleados.dto.EmployeeResp;
import com.empleados.service.BuscarEmpleadosService;

@RestController
@RequestMapping("empleado")
public class BuscarEmpledosController {
	
	private final static Logger log = Logger.getLogger(BuscarEmpledosController.class);
	
	@Autowired
	BuscarEmpleadosService buscarEmpleadosService;

	@PostMapping(value = "/buscarEmpleo", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public EmployeeResp buscarEmpleados(@RequestBody EmployeeReq employeeReq) {
		
		log.debug("Buscar empleado");
		
		EmployeeResp resp = buscarEmpleadosService.buscarEmpleados(employeeReq);
		
		return resp;
		
	}
}
