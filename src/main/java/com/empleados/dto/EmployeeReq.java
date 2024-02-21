/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase Employees Response
 */
@Getter
@Setter
public class EmployeeReq implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 6395150943491798390L;

	/**
	 * Lista de empleados
	 */
	private int job_id;
}
