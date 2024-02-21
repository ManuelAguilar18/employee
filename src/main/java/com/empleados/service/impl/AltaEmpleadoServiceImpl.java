/**
 * 
 */
package com.empleados.service.impl;

import java.util.HashMap;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dto.NewEmployeeReq;
import com.empleados.dto.NewEmployeeResp;
import com.empleados.repository.AltaEmpleadoRepository;
import com.empleados.service.AltaEmpleadoService;
import com.empleados.util.ValidacionEmpleadosUtil;

/**
 * 
 */
@Service
public class AltaEmpleadoServiceImpl implements AltaEmpleadoService{
	
	private final static Logger log = Logger.getLogger(AltaEmpleadoServiceImpl.class);
	
	/**
	 * Bandera existe empleado
	 */
	 private final static int EXISTE_EMPLEADO = 0;

	@Autowired
	AltaEmpleadoRepository altaEmpleadoRepository;
	
	@Override
	public NewEmployeeResp altaEmpledo(NewEmployeeReq employeeReq) {
		
		log.debug("Alta de empleado");
		
		ValidacionEmpleadosUtil util = new ValidacionEmpleadosUtil();
		HashMap<String, Boolean> validaEmpleado = new HashMap<>();
		
		NewEmployeeResp resp = null;
		
		try {
			
			resp = new NewEmployeeResp();
			
			log.debug("Valida el nombre y apelledios que no contenga carateres extraños");
			
			validaEmpleado = util.validaDatosEmpleados(employeeReq);
			
			if (validaEmpleado.get("nombre") == true && validaEmpleado.get("apellido") == true) {
				
				log.debug("Valida que no se encuentre registrado");
				
				int validacion = altaEmpleadoRepository.findEmpleado(employeeReq.getName(), employeeReq.getLast_name(), employeeReq.getBirthdate());
				
				if (EXISTE_EMPLEADO == validacion) {
					altaEmpleadoRepository.save(employeeReq);
					
					log.debug("Realiza el insert del empleado");
					
					int idEmpleado = altaEmpleadoRepository.findEmpleadoId(employeeReq.getName(), employeeReq.getLast_name(), employeeReq.getBirthdate());
					
					resp.setId(idEmpleado);
					resp.setSuccess(true);
					
				}else {
					resp.setId(-2);
					resp.setSuccess(false);
				}
				
			}else {
				resp.setId(-3);
				resp.setSuccess(false);
			}
			
		} catch (Exception e) {
			resp = new NewEmployeeResp();
			resp.setId(-1);
			resp.setSuccess(false);
		}
		

		return resp;
	}
}
