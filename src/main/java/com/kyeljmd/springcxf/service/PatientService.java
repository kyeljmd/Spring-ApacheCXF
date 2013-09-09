package com.kyeljmd.springcxf.service;


import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.kyeljmd.springcxf.model.Patient;

@Path("/patient/")
@Produces("application/json")
public interface PatientService {
	
	@GET
	List<Patient> getPatients();
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	Patient getPatient(@PathParam("id") Long id);
	
	@POST
	@Path("/add")
	@Consumes(MediaType.APPLICATION_JSON)
	Patient addPatient(Patient patient);
	
	@DELETE
	@Path("/delete/{id")
	Response deletePatient(@PathParam("id") Long id);

}
