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
public class HourResp implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -7935529114856306212L;
	
	/**
	 * Total de horas
	 */
	private int total_worked_hours;
	
	/**
	 * Bandera
	 */
	private boolean success;
}
