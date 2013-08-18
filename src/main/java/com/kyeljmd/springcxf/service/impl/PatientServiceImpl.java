package com.kyeljmd.springcxf.service.impl;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.kyeljmd.springcxf.model.Patient;
import com.kyeljmd.springcxf.repo.PatientRepo;
import com.kyeljmd.springcxf.service.PatientService;

@Service
@Component("patientServiceImpl")
public class PatientServiceImpl  implements PatientService{

	@Autowired
	private PatientRepo patientRepo;

	public String getPatient(Long id) {
		Patient patient = patientRepo.getPatient(id);
		if (patient != null) {
			return new Gson().toJson(patient);
		} else {
			return "";
		}
	}

	public Patient addPatient(Patient patient) {
		Patient res = patientRepo.addPatient(patient);
		return res;
	}

	@Override
	public String getPatients() {
		return new Gson().toJson(patientRepo.getPatients());
	}

	@Override
	public Response deletePatient(Long id) {
		patientRepo.delete(id);
		return Response.ok().build();
	}
}
