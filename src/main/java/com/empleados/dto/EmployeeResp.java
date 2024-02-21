/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase Employees Response
 */
@Getter
@Setter
public class EmployeeResp implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 6395150943491798390L;

	/**
	 * Lista de empleados
	 */
	private ArrayList<EmployeeDTO> employees;
	
	/**
	 * Bandera confirmacion
	 */
	private boolean success;
}
