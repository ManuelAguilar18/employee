package com.empleados.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.empleados.dto.HourDTO;

@Repository
public interface TotalHoraTrabajadaRepository extends JpaRepository<HourDTO, Integer>{

	@Query(value = "select COALESCE(SUM(worked_hours),0) AS total from employee_worked_hours where employee_id = ?1 and worked_date BETWEEN ?2 and ?3", nativeQuery = true)
	int findTotalHoras(int employee_id, String start_date, String end_date);

}
