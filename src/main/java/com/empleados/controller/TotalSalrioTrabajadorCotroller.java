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

import com.empleados.dto.PayEmployeeReq;
import com.empleados.dto.PayEmployeeResp;
import com.empleados.service.TotalSalarioTrabajadaService;

/**
 * 
 */
@RestController
@RequestMapping("empleado")
public class TotalSalrioTrabajadorCotroller {
	
	private final static Logger log = Logger.getLogger(TotalSalrioTrabajadorCotroller.class);
	
	@Autowired
	TotalSalarioTrabajadaService service;
	
	@PostMapping(value = "/salarioTrabajador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public PayEmployeeResp totalHorasTrabajador(@RequestBody PayEmployeeReq payEmployeeReq) {
		
		log.debug("Se obtiene el salario del trabajador");
		
		PayEmployeeResp resp = service.totalSalarioTrabajador(payEmployeeReq);
		
		return resp;
	}

}
