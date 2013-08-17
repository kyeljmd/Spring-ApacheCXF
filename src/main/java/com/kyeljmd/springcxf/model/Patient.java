package com.kyeljmd.springcxf.model;

import java.io.Serializable;

public class Patient implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7393320017378010427L;
	private Long patienId;
	private String patientFirstName;
	private String patientLastName;
	private String phoneNumber;
	
	public Long getPatienId() {
		return patienId;
	}
	
	public void setPatienId(Long patienId) {
		this.patienId = patienId;
	}
	
	public String getPatientFirstName() {
		return patientFirstName;
	}
	public void setPatientFirstName(String patientFirstName) {
		this.patientFirstName = patientFirstName;
	}
	
	public String getPatientLastName() {
		return patientLastName;
	}
	
	public void setPatientLastName(String patientLastName) {
		this.patientLastName = patientLastName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
}
