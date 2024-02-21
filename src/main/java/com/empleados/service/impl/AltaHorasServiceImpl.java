/**
 * 
 */
package com.empleados.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dto.AddHourReq;
import com.empleados.dto.AddHourResp;
import com.empleados.repository.AltaHorasRepository;
import com.empleados.service.AltaHorasService;

/**
 * 
 */
@Service
public class AltaHorasServiceImpl implements AltaHorasService{
	
	private final static Logger log = Logger.getLogger(AltaHorasServiceImpl.class);
	
	AddHourResp addHourResp = null;
	
	private static int HORAS_MAXIMAS = 20;
	
	private static int HORAS_CERO = 0;
	
	@Autowired
	AltaHorasRepository altaHorasRepository;

	@Override
	public AddHourResp altaHoras(AddHourReq hourReq) {
		
		try {
			addHourResp = new AddHourResp();
			
			log.debug("Validacion de horas");
			
			int insertHoras = this.validaHora(hourReq);
			
			if (insertHoras == 1) {
				log.debug("Guardar las horas asignadas al empleado");
				altaHorasRepository.save(hourReq);
				
				int idHora = altaHorasRepository.findHoraInsert(hourReq.getEmployee_id(), hourReq.getWorked_date(), hourReq.getWorked_hours());
				
				addHourResp.setId(idHora);
				addHourResp.setSuccess(true);
				
			}else if (insertHoras == 2) {
				
				altaHorasRepository.updateHora(hourReq.getWorked_hours(), hourReq.getWorked_date(), hourReq.getEmployee_id() );
				
				int idHora = altaHorasRepository.findHoraInsert(hourReq.getEmployee_id(), hourReq.getWorked_date(), hourReq.getWorked_hours());
				
				addHourResp.setId(idHora);
				addHourResp.setSuccess(true);
			}else {
				addHourResp.setId(-1);
				addHourResp.setSuccess(false);	
			}
			
		} catch (Exception e) {
			addHourResp.setId(-10);
			addHourResp.setSuccess(false);
		}
		

		
		return addHourResp;
	}

	/**
	 * Valida Informacion a insertar
	 * @param hourReq
	 * @return
	 */
	private int validaHora(AddHourReq hourReq) {

		boolean bandera = false;
		int tipoAccion = 0;
		
		
		boolean existeUsuario = this.validaEmpleado(hourReq.getEmployee_id());
		
		boolean fecha = this.validaFechaIngresar(hourReq.getWorked_date(), hourReq.getEmployee_id());
		
		log.debug("Validacion Fechas");
		
		if (existeUsuario == true && (fecha == false || fecha == true)) {
			
			bandera = this.validaFechaMenor(hourReq.getWorked_date());
			
			if (bandera == true) {
				
				bandera = false;
				
				String hora = altaHorasRepository.findObtenerHoras(hourReq.getWorked_date(), hourReq.getEmployee_id());
				
				int horasAsignadas = this.covertirNumero(hora);
				
				log.debug("Validacion las horas asignadas al empleado");
				
				if (HORAS_CERO == horasAsignadas && hourReq.getWorked_hours() <= HORAS_MAXIMAS) {
					tipoAccion = 1;	
				}else if (horasAsignadas <= HORAS_MAXIMAS && hourReq.getWorked_hours() <= HORAS_MAXIMAS) {
					tipoAccion = 2;
				}
				
			}
			
		}
		
		return tipoAccion;
	}

	private int covertirNumero(String hora) {
		
		int convHora = -1;
		
		if (hora == null || "null".equals(hora)) {
			convHora = 0;
		}else if (!"null".equals(hora) && hora != null) {
			convHora = Integer.parseInt(hora);
		} 
		
		return convHora;
	}

	/**
	 * Valida Empleado
	 * @param employee_id
	 * @return
	 */
	private boolean validaEmpleado(int employee_id) {
		
		boolean bandera = false;
		
		log.debug("Valida que el empleafo exista");
		
		int idEmpleado = altaHorasRepository.findExisteEmpleado(employee_id);
		
		if (idEmpleado > 0) {
			bandera = true;
		}
		
		return bandera;
	}

	/**
	 * 
	 * @param worked_date
	 * @param employee_id
	 * @return
	 */
	private boolean validaFechaIngresar(String worked_date, int employee_id) {
		boolean bandera = false;
		
		log.debug("Valida que no este el registro");
		
		int fechaExite = altaHorasRepository.findValidaFecha(worked_date,employee_id);
		
		if (fechaExite > 0) {
			bandera = true;
		}
		
		return bandera;
	}
	
	/**
	 * 
	 * @param worked_date
	 * @return
	 */
	private boolean validaFechaMenor(String worked_date) {

		log.debug("Valida que la fecha no sea mayor a la actual");
		
		boolean fechaAc = false;
		Calendar cal = new GregorianCalendar();
		
		try {

			Date fechaActual = new Date(System.currentTimeMillis());
			SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
			Date fechaInicioDate;

			fechaInicioDate = date.parse(worked_date);

			cal.setTime(fechaInicioDate);
			
			if (fechaInicioDate.after(fechaActual)) {
				fechaAc = false;
			} else {
				if (cal.get(Calendar.DAY_OF_WEEK) != Calendar.SUNDAY && cal.get(Calendar.DAY_OF_WEEK) != Calendar.SATURDAY) {
					fechaAc = true;
				}

			}
		} catch (ParseException e) {
			log.debug("ERROR: " + e.toString());
		}
		return fechaAc; 

	}
}
