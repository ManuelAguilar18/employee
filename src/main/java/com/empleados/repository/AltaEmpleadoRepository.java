/**
 * 
 */
package com.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empleados.dto.NewEmployeeReq;

/**
 * 
 */
public interface AltaEmpleadoRepository extends JpaRepository<NewEmployeeReq, Integer>{

	@Query(value="SELECT COUNT(*) FROM employees WHERE name = ?1 and last_name = ?2 and birthdate = ?3", nativeQuery = true)
	int findEmpleado(String name, String last_name, String birthdate);

	@Query(value = "SELECT id FROM employees WHERE name = :name and last_name = :last and birthdate = :bd", nativeQuery = true)
	int findEmpleadoId(@Param("name") String name,@Param("last") String last_name,@Param("bd") String birthdate);

}
