/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase DTO de Pago de empleado
 */
@Getter
@Setter
public class PayEmployeeReq implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -1099866683263526171L;

	/**
	 * Numero de empleado
	 */
	private int employee_id;
	
	/**
	 * Fecha de inicio
	 */
	private String start_date;
	
	/**
	 * Fecha de fin
	 */
	private String end_date; 
}
