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
import lombok.Getter;
import lombok.Setter;

/**
 * Class DTO Job
 */
@Entity
@Table(name = "jobs")
@Getter
@Setter
public class JobDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4216341701306841604L;

	/**
	 * Id del job
	 */
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Nombre del trabajo
	 */
	@Column(name = "name_job")
	private String name;
	
	/**
	 * Salario del puesto
	 */
	@Column(name = "salary")
	private double salary;
}
