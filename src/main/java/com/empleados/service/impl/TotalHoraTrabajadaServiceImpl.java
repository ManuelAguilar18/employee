package com.empleados.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dto.HourReq;
import com.empleados.dto.HourResp;
import com.empleados.repository.TotalHoraTrabajadaRepository;
import com.empleados.service.TotalHoraTrabajadaService;

@Service
public class TotalHoraTrabajadaServiceImpl implements TotalHoraTrabajadaService{

	@Autowired
	TotalHoraTrabajadaRepository totalHoraTrabajadaRepository;
	
	@Override
	public HourResp totalHorasTrabajador(HourReq hourReq) {
		
		HourResp resp = new HourResp();
		
		boolean bandera = this.validaFecha(hourReq);
		
		try {
			if (bandera==true) {
				int totalHoras = totalHoraTrabajadaRepository.findTotalHoras(hourReq.getEmployee_id(), hourReq.getStart_date(), hourReq.getEnd_date());
				
				resp.setTotal_worked_hours(totalHoras);
				resp.setSuccess(true);
				
			}else {
				resp.setTotal_worked_hours(-1);
				resp.setSuccess(false);
			}
			
		} catch (Exception e) {
			resp.setTotal_worked_hours(-101);
			resp.setSuccess(false);
		}
		

		return resp;
	}

	private boolean validaFecha(HourReq hourReq) {

		boolean bandera = false;

		try {

			if ((hourReq.getStart_date() != null || !"null".equals(hourReq.getStart_date())
					|| !"".equals(hourReq.getStart_date()))
					&& (hourReq.getEnd_date() != null || !"null".equals(hourReq.getEnd_date())
							|| !"".equals(hourReq.getEnd_date()))) {

				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaInicioDate;

				fechaInicioDate = date.parse(hourReq.getStart_date());
				Date fechaFinDate = date.parse(hourReq.getEnd_date());

				if (fechaInicioDate.after(fechaFinDate)) {
					bandera = false;
				} else {
					bandera = true;
				}

			}

		} catch (ParseException e) {
			e.printStackTrace();
		} 

		return bandera;
	}

}
