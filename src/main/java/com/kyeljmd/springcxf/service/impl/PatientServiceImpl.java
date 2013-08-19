package com.kyeljmd.springcxf.service.impl;

import java.util.List;

import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.kyeljmd.springcxf.model.Patient;
import com.kyeljmd.springcxf.repo.PatientRepo;
import com.kyeljmd.springcxf.service.PatientService;

@Service
@Component("patientServiceImpl")
public class PatientServiceImpl  implements PatientService{

	@Autowired
	private PatientRepo patientRepo;

	public Patient getPatient(Long id) {
		return patientRepo.getPatient(id);
	}

	public Patient addPatient(Patient patient) {
		Patient res = patientRepo.addPatient(patient);
		return res;
	}

	@Override
	public List<Patient> getPatients() {
		return patientRepo.getPatients();
	}

	@Override
	public Response deletePatient(Long id) {
		patientRepo.delete(id);
		return Response.ok().build();
	}
}
