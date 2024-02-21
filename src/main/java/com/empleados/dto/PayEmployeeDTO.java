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
 * Clase DTO de Pago de empleado
 */
@Entity
@Table(name = "employee_worked_salary")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PayEmployeeDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -6969492918748380566L;

	/**
	 * id del empleado
	 */
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "employee_id")
	private int employee_id;
	
	@Column(name = "worked_salary")
	private int worked_salary;
	
	@Column(name = "worked_date")
	private String worked_date;
}
