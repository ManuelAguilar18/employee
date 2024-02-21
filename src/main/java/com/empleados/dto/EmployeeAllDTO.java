/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Clase Employee DTO
 */
@Entity
@Table(name = "employees")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeAllDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 507885597317385658L;

	/**
	 * id del empleado
	 */
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	/**
	 * Nombre del empleado
	 */
	@Column(name = "name")
	private String name;
	
	/**
	 * Apellido del empleado
	 */
	@Column(name = "last_name")
	private String last_name;
	
	/**
	 * Cumpleaños del empleado
	 */
	@Column(name = "birthdate")
	private String birthdate;
	
	/**
	 * Puesto
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="job_id",referencedColumnName="id")	
	private JobDTO job;
	
	/**
	 * Genero
	 */
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="gender_id",referencedColumnName="id")	
	private GenderDTO gender;
	
}
