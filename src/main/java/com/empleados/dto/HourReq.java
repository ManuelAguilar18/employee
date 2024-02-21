/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase de horas
 */
@Getter
@Setter
public class HourReq implements Serializable{

	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7935529114856306212L;

	/**
	 * Id del empleado
	 */
	private int employee_id;
	
	/**
	 * Fecha de inicio 
	 */
	private String start_date;
	
	/**
	 * Fecha fin 
	 */
	private String end_date;
}
