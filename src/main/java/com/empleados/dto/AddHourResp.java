/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

/**
 * Clase DTO para agregar horas
 * de trabajo
 */
@Getter
@Setter
public class AddHourResp implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 7372381396765374185L;

	/**
	 * Id de respuesta
	 */
	private int id;
	
	/**
	 * Bandera success
	 */
	private boolean success;

}
