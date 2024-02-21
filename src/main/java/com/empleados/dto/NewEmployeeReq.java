/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase DTO nuevo empleado
 */
@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewEmployeeReq implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 5928977999528326685L;
	
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;

	/**
	 * Id de catanlogo gender
	 */
	private int gender_id;
	
	/**
	 * Id del catalago jobs
	 */
	private int job_id;
	
	/**
	 * Nombre del empleado
	 */
	private String name;
	
	/**
	 * Apellido del empleado
	 */
	private String last_name;
	
	/**
	 * Fecha de nacimiento
	 */
	private String birthdate;
	
}
