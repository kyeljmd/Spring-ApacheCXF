package com.kyeljmd.springcxf.service;


import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.kyeljmd.springcxf.model.Patient;

@Path("/patient/")
@Produces("application/json")
public interface PatientService {
	
	@GET
	String getPatients();
	
	@GET
	@Path("/get/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	String getPatient(@PathParam("id") Long id);
	
	@Path("/add")
	@POST
	Patient addPatient(@FormParam("") Patient patient);

}
