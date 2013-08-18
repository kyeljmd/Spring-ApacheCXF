package com.kyeljmd.springcxf.repo.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.kyeljmd.springcxf.model.Patient;
import com.kyeljmd.springcxf.repo.PatientRepo;

@Component("patientRepo")
@Scope("singleton")
public class DummyPatientRepoImpl implements PatientRepo{

	
	private static final Map<Long, Patient> patients = new LinkedHashMap<Long, Patient>();

	public DummyPatientRepoImpl() {
		Patient patientOne = new Patient();
		Patient patientTwo = new Patient();
		Patient patientThree = new Patient();

		patientOne.setPatienId(1L);
		patientTwo.setPatienId(2L);
		patientThree.setPatienId(3L);

		patientOne.setPatientFirstName("Kyel");
		patientOne.setPatientLastName("David");
		patientOne.setPhoneNumber("555-5555");

		patientTwo.setPatientFirstName("Duane");
		patientTwo.setPatientLastName("Llose");
		patientTwo.setPhoneNumber("555-5555");

		patientThree.setPatientFirstName("Cardel");
		patientThree.setPatientLastName("Domingo");
		patientThree.setPhoneNumber("555-5555");

		patients.put(patientOne.getPatienId(), patientOne);
		patients.put(patientTwo.getPatienId(), patientTwo);
		patients.put(patientThree.getPatienId(), patientThree);
	}

	public Patient getPatient(Long id) {
		return patients.get(id);
	}

	@Override
	public void delete(Long id) {
		patients.remove(id);
	}

	@Override
	public Patient addPatient(Patient patient) {
		if (patient.getPatienId() == null) {
			patient.setPatienId(nextId());
		}
		patients.put(patient.getPatienId(), patient);
		return patient;
	}

	private Long nextId() {
		return patients.size() + 1L;
	}

	@Override
	public List<Patient> getPatients() {
		return new ArrayList<Patient>(patients.values());
	}

}
