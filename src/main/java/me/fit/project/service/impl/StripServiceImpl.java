package me.fit.project.service.impl;

import java.util.List;
import java.util.logging.Logger;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import me.fit.project.model.Strip;
import me.fit.project.service.api.StripService;

@Stateless
public class StripServiceImpl implements StripService {

	@Inject
	private Logger log;

	@Inject
	private EntityManager em;

	public void addStrip(Strip strip) throws Exception {
		log.info("Adding " + strip.getNaziv());
		em.merge(strip);
	}

	public Strip findById(Long id) {
		return em.find(Strip.class, id);
	}

	public List<Strip> getAllStripovi() {
		return em.createNamedQuery(Strip.GET_ALL, Strip.class).getResultList();
	}

	public List<Strip> getByNaziv(String nameP) {
		return em.createNamedQuery(Strip.GET_BY_NAME, Strip.class).setParameter("naziv", nameP).getResultList();
	}

	@Override
	public List<Strip> getByName(String nameP) {
		// TODO Auto-generated method stub
		return null;
	}

}

