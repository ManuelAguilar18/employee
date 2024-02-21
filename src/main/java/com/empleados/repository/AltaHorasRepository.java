package com.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.empleados.dto.AddHourReq;

import jakarta.transaction.Transactional;

public interface AltaHorasRepository extends JpaRepository<AddHourReq, Integer>{

	@Query(value = "SELECT COUNT(*) FROM employees WHERE id = :idEmpleado", nativeQuery = true)
	int findExisteEmpleado(@Param("idEmpleado") int employee_id);

	@Query(value = "SELECT COUNT(*) FROM employee_worked_hours WHERE worked_date = :fecha and employee_id = :idEmpleado", nativeQuery = true)
	int findValidaFecha(@Param("fecha") String worked_date, @Param("idEmpleado") int employee_id);

	@Query(value = "SELECT COALESCE(worked_hours,0) AS hora FROM employee_worked_hours WHERE worked_date = :fecha and employee_id = :idEmpleado", nativeQuery = true)
	String findObtenerHoras(@Param("fecha") String worked_date, @Param("idEmpleado") int employee_id);

	@Query(value = "SELECT id FROM employee_worked_hours WHERE worked_date = :fecha and employee_id = :idEmpleado and worked_hours = :hora", nativeQuery = true)
	int findHoraInsert(@Param("idEmpleado") int employee_id, @Param("fecha") String worked_date, @Param("hora") int worked_hours);

	@Modifying
	@Transactional
	@Query(value = "UPDATE employee_worked_hours SET worked_hours = :hora WHERE worked_date = :fecha AND employee_id = :idEmpleado", nativeQuery = true)
	void updateHora(@Param("hora")int hora, @Param("fecha") String fecha, @Param("idEmpleado")int idEmpleado);

	
}
