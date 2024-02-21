package com.empleados.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.empleados.dto.EmployeeDTO;

@Repository
@EnableJpaRepositories
public interface BuscarEmpleadosRepository extends JpaRepository<EmployeeDTO, Integer>{

	@Query(value = "SELECT u.id, u.name, u.last_name, u.birthdate, j.id AS id_job,j.name_job, j.salary, g.id AS id_gender, g.name_gender FROM employees u INNER JOIN jobs j ON j.id = u.job_id INNER JOIN genders g ON g.id = u.gender_id WHERE u.job_id = :id", nativeQuery = true)
	List<EmployeeDTO> findByJob(@Param("id") int job_id);

}
