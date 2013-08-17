package com.kyeljmd.springcxf.repo;

import java.util.List;

import com.kyeljmd.springcxf.model.Patient;

public interface PatientRepo {
	
	Patient getPatient(Long id);
	
	void delete(Patient patient);
	
	Patient addPatient(Patient patient);
	
	List<Patient> getPatients();
}
