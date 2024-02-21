/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase DTO nuevo empleado 
 * Response
 */
@Getter
@Setter
public class NewEmployeeResp implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 5928977999528326685L;

	/**
	 * Id de respuesta
	 */
	private int id;
	
	/**
	 * Bandera success
	 */
	private boolean success;
	
}
