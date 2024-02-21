package com.empleados.util;

import java.util.HashMap;

import com.empleados.dto.NewEmployeeReq;

public class ValidacionEmpleadosUtil {
	
	boolean nombre = false;
	
	boolean apellidos = false;

	public HashMap<String, Boolean> validaDatosEmpleados(NewEmployeeReq employeeReq) {
		
		HashMap<String, Boolean> respuesta = new HashMap<>();
		
		nombre = esTexto(employeeReq.getName());
		
		respuesta.put("nombre", nombre);
		
		apellidos = esTexto(employeeReq.getLast_name());
		
		respuesta.put("apellido", apellidos);
		
		
		return respuesta;
	}


	/**
	 * Valida la cadena
	 * @param texto
	 * @return
	 */
	private static boolean esTexto(String texto) {
		return texto != null && texto.chars().allMatch(Character::isLetter);
	}

}
