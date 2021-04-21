package me.fit.project.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import me.fit.project.model.Korisnik;
import me.fit.project.service.api.KorisnikService;

@Stateless
public class KorisnikServiceImpl implements KorisnikService {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void addKorisnik(Korisnik korisnik) throws Exception {
		log.info("Registering " + korisnik.getName());
		em.merge(korisnik);
	}

	public Korisnik findById(Long id) {
		return em.find(Korisnik.class, id);
	}

	public List<Korisnik> getAllKorisnici() {
		return em.createNamedQuery(Korisnik.GET_ALL, Korisnik.class).getResultList();
	}

	public List<Korisnik> getByName(String nameP) {
		return em.createNamedQuery(Korisnik.GET_BY_NAME, Korisnik.class).setParameter("ime", nameP).getResultList();
	}

}
