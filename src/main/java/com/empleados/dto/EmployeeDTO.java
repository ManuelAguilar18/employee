/**
 * 
 */
package com.empleados.dto;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
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
public class EmployeeDTO implements Serializable{

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
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "jobs", joinColumns = { @JoinColumn(name = "job_id") }, 
	                                inverseJoinColumns = { @JoinColumn(name = "id_job") }
	)
	private JobDTO job;
	
	/**
	 * Genero
	 */
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "genders", joinColumns = { @JoinColumn(name = "gender_id") }, 
	                                inverseJoinColumns = { @JoinColumn(name = "id_gender") }
	)
	private GenderDTO gender;
	
}
