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

import com.empleados.dto.AddHourReq;
import com.empleados.dto.AddHourResp;
import com.empleados.service.AltaHorasService;

/**
 * 
 */
@RestController
@RequestMapping("empleado")
public class AltaHorasController {
	
	private final static Logger log = Logger.getLogger(AltaEmpleadoController.class);
	
	@Autowired
	AltaHorasService service;
	
	@PostMapping(value = "/altahoras", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public AddHourResp altaHoras(@RequestBody AddHourReq hourReq) {
		
		log.debug("Inicia alta horas empleado");
		
		AddHourResp resp = service.altaHoras(hourReq); 
		
		log.debug("Fin alta horas empleado");
		
		return resp;
	}

}
