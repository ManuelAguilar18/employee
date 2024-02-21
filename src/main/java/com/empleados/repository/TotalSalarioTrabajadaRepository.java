package com.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empleados.dto.PayEmployeeDTO;

@Repository
public interface TotalSalarioTrabajadaRepository extends JpaRepository<PayEmployeeDTO, Integer>{

	@Query(value = "select COALESCE(SUM(worked_salary),0) AS total from employee_worked_salary where employee_id = ?1 and worked_date BETWEEN ?2 and ?3", nativeQuery = true)
	int findTotalSalario(int employee_id, String start_date, String end_date);

}
