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
public class PayEmployeeResp implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -6969492918748380566L;

	/**
	 * Monto total
	 */
	private int payment;
	
	/**
	 * Bandera
	 */
	private boolean success;
}
