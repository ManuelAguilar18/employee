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
 * Clase DTO para agregar horas
 * de trabajo
 */
@Entity
@Table(name = "employee_worked_hours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddHourReq implements Serializable{
	
	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = 7372381396765374185L;

	/**
	 * Id 
	 */
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	/**
	 * Id del empleado
	 */
	@Column(name = "employee_id")
	private int employee_id;
	
	/**
	 * Horas trabajadas 
	 */
	@Column(name = "worked_hours")
	private int worked_hours;
	
	/**
	 * Fecha que trabajo 
	 * El empleado
	 */
	@Column(name = "worked_date")
	private String worked_date;

}
