/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
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
public class Employees implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 5928977999528326685L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer Id;

	/**
	 * Id de catanlogo gender
	 */
	@Column(name="gender_id")
	private int gender_id;
	
	/**
	 * Id del catalago jobs
	 */
	@Column(name="job_id")
	private int job_id;
	
	/**
	 * Nombre del empleado
	 */
	@Column(name="name")
	private String name;
	
	/**
	 * Apellido del empleado
	 */
	@Column(name="last_name")
	private String last_name;
	
	/**
	 * Fecha de nacimiento
	 */
	@Column(name="birthdate")
	private String birthdate;
	
}
