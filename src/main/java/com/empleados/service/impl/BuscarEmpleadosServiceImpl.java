package com.empleados.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dto.EmployeeDTO;
import com.empleados.dto.EmployeeReq;
import com.empleados.dto.EmployeeResp;
import com.empleados.repository.BuscarEmpleadosRepository;
import com.empleados.service.BuscarEmpleadosService;

@Service
public class BuscarEmpleadosServiceImpl implements BuscarEmpleadosService{
	
	private final static Logger log = Logger.getLogger(BuscarEmpleadosServiceImpl.class);
	
	@Autowired
	BuscarEmpleadosRepository buscarEmpleadosRepository;

	@Override
	public EmployeeResp buscarEmpleados(EmployeeReq employeeReq) {
		
		EmployeeResp response = new EmployeeResp();
		
		try {
			
			log.debug("Buscar los empleados");
			
			List<EmployeeDTO> resp = buscarEmpleadosRepository.findByJob(employeeReq.getJob_id());
			
			if (resp.size() >0) {
				response.setEmployees((ArrayList<EmployeeDTO>) resp);
				response.setSuccess(true);
			}else {
				
				response.setSuccess(false);
			}
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return response;
	}

	
}
