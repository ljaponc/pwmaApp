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

import me.fit.project.model.Korisnik;
import me.fit.project.service.api.KorisnikService;

@Path("/korsisnici")
@RequestScoped
public class KorisnikRestService {

	@Inject
	private Logger log;

	@Inject
	private KorisnikService korisnikService;

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/getAll")
	public Response getAllKorisnici() {
		List<Korisnik> korsisnici = korisnikService.getAllKorisnici();

		return Response.ok(korsisnici).build();

	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/addKorisnik")
	public void getAllKorisnici(Korisnik s) {
		try {
			korisnikService.addKorisnik(s);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/findKorisnik")
	public Response findKorisnikByName(@QueryParam("name") String ime) {
		try {
			List<Korisnik> korsisnici = korisnikService.getByName(ime);

			return Response.ok(korsisnici).build();
		} catch (Exception e) {
			e.printStackTrace();

		}
		return null;
	}

}
