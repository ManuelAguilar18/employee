/**
 * 
 */
package com.empleados.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empleados.dto.HourReq;
import com.empleados.dto.HourResp;
import com.empleados.service.TotalHoraTrabajadaService;

/**
 * 
 */
@RestController
@RequestMapping("empleado")
public class TotalHorasTrabajadasCotroller {
	
	@Autowired
	TotalHoraTrabajadaService service;
	
	@PostMapping(value = "/horasTrabajador", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HourResp totalHorasTrabajador(@RequestBody HourReq hourReq) {
		
		HourResp resp = service.totalHorasTrabajador(hourReq);
		
		return resp;
	}

}
