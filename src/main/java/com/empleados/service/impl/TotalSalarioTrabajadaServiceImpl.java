package com.empleados.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empleados.dto.PayEmployeeReq;
import com.empleados.dto.PayEmployeeResp;
import com.empleados.repository.TotalSalarioTrabajadaRepository;
import com.empleados.service.TotalSalarioTrabajadaService;

@Service
public class TotalSalarioTrabajadaServiceImpl implements TotalSalarioTrabajadaService{
	
	private final static Logger log = Logger.getLogger(TotalHoraTrabajadaServiceImpl.class);

	@Autowired
	TotalSalarioTrabajadaRepository totalSalarioTrabajadaRepository;
	
	@Override
	public PayEmployeeResp totalSalarioTrabajador(PayEmployeeReq payEmployeeReq) {
		
		PayEmployeeResp resp = new PayEmployeeResp();
		
		log.debug("Valida las fechas de pago");
		
		boolean bandera = this.validaFecha(payEmployeeReq);
		
		try {
			if (bandera==true) {
				
				log.debug("Obtiene el salario del empleado");
				
				int totalSalario = totalSalarioTrabajadaRepository.findTotalSalario(payEmployeeReq.getEmployee_id(), payEmployeeReq.getStart_date(), payEmployeeReq.getEnd_date());
				
				resp.setPayment(totalSalario);
				resp.setSuccess(true);
				
			}else {
				resp.setPayment(-1);
				resp.setSuccess(false);
			}
			
		} catch (Exception e) {
			resp.setPayment(-101);
			resp.setSuccess(false);
		}
		

		return resp;
	}

	private boolean validaFecha(PayEmployeeReq payReq) {

		boolean bandera = false;

		try {

			if ((payReq.getStart_date() != null || !"null".equals(payReq.getStart_date())
					|| !"".equals(payReq.getStart_date()))
					&& (payReq.getEnd_date() != null || !"null".equals(payReq.getEnd_date())
							|| !"".equals(payReq.getEnd_date()))) {

				SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
				Date fechaInicioDate;

				fechaInicioDate = date.parse(payReq.getStart_date());
				Date fechaFinDate = date.parse(payReq.getEnd_date());

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
