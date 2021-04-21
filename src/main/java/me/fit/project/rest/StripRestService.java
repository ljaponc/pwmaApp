package me.fit.project.rest;

import java.util.List;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import me.fit.project.model.Strip;


import me.fit.project.service.api.StripService;

@Path("/stripovi")
@RequestScoped
public class StripRestService {

	@Inject
	private Logger log;

	@Inject
	private StripService stripService;
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllStripovi() {
		
		List<Strip> stripovi = stripService.getAllStripovi();

		return Response.ok(stripovi).build();

	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addStrip")
	public void getAllStripovi(Strip s) {
		try {
			stripService.addStrip(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findStrip")
	public Response findStripByName(@QueryParam("naziv") String ime) {
		try {
			List<Strip> stripovi = stripService.getByName(ime);

			return Response.ok(stripovi).build();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}
	
}
