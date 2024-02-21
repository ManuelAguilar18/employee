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
 * Class DTO Genero
 */
@Entity
@Table(name = "genders")
@Getter
@Setter
public class GenderDTO implements Serializable{

	/**
	 * Serial Version
	 */
	private static final long serialVersionUID = -4216341701306841604L;

	/**
	 * Id genero
	 */
	@Id
	@Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 * Genero
	 */
	@Column(name = "name_gender")
	private String name;
	
}
