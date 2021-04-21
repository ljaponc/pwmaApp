package me.fit.project.service.api;

import java.util.List;

import me.fit.project.model.Korisnik;

public interface KorisnikService {
	public void addKorisnik(Korisnik korisnik) throws Exception;

	public Korisnik findById(Long id);

	public List<Korisnik> getAllKorisnici();

	public List<Korisnik> getByName(String nameP);
	
}
