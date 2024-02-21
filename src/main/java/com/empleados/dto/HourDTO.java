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

@Entity
@Table(name = "employee_worked_hours")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HourDTO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8760968827500061091L;
	/**
	 * id del empleado
	 */
	@Id
	@Column(name="id", nullable = false, unique = true)
	private int id;
	
	@Column(name = "employee_id")
	private int employee_id;
	
	@Column(name = "worked_hours")
	private int worked_hours;
	
	@Column(name = "worked_date")
	private String worked_date;
}
