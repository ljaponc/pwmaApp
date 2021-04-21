
package me.fit.project.view;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.SelectEvent;

import me.fit.project.model.Film;
import me.fit.project.model.Igrica;
import me.fit.project.model.Korisnik;
import me.fit.project.model.Strip;
import me.fit.project.service.api.KorisnikService;
import me.fit.project.service.impl.KorisnikServiceImpl;

@Named
@ViewScoped
public class KorisnikView implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	private FacesContext facesContext;

	@Inject
	private KorisnikService korisnikService;

	private Korisnik korisnik;

	private Film film;
	
	private Igrica igrica;

	private List<Korisnik> korisniks;

	private String imeZaPretragu;

	private Korisnik selectedKorisnik;
	
	private Strip strip;

	@PostConstruct
	public void initNewMember() {
		korisnik = new Korisnik();
		film = new Film();
		korisniks = korisnikService.getAllKorisnici();
		igrica = new Igrica();
		strip = new Strip();
		
	}


	public void addNewKorisnik() throws Exception {
		try {
			System.out.println(korisnik.getName());
			korisnikService.addKorisnik(korisnik);
			korisnik = new Korisnik();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Registered!", "Registration successful");
			facesContext.addMessage(null, m);
			korisniks = korisnikService.getAllKorisnici();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Not registered", "Registration unsuccessful");
			facesContext.addMessage(null, m);
		}
	}

	public void pretraziPoImenu() {
		if (imeZaPretragu.isEmpty()) {
			korisniks = korisnikService.getAllKorisnici();
			return;
		}
		korisniks = korisnikService.getByName(imeZaPretragu);
	}

	public void dodajFilm() {
		try {
			selectedKorisnik.getFilms().add(film);
			film.setKorisnik(selectedKorisnik);
			korisnikService.addKorisnik(selectedKorisnik);
			korisniks = korisnikService.getAllKorisnici();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void dodajIgricu() {
		try {
			selectedKorisnik.getIgrice().add(igrica);
			igrica.setKorisnik(selectedKorisnik);
			korisnikService.addKorisnik(selectedKorisnik);
			korisniks = korisnikService.getAllKorisnici();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public List<Korisnik> getKorisnici() {
		return korisniks;
	}

	public void setKorisnici(List<Korisnik> korisniks) {
		this.korisniks = korisniks;
	}

	public String getImeZaPretragu() {
		return imeZaPretragu;
	}

	public void setImeZaPretragu(String imeZaPretragu) {
		this.imeZaPretragu = imeZaPretragu;
	}

	public Long getId() {
		return selectedKorisnik.getId();
	}

	public void setId(Long id) {
		selectedKorisnik.setId(id);
	}

	public String getName() {
		return selectedKorisnik.getName();
	}

	public void setName(String name) {
		selectedKorisnik.setName(name);
	}

	public String getEmail() {
		return selectedKorisnik.getEmail();
	}

	public void setEmail(String email) {
		selectedKorisnik.setEmail(email);
	}

	public Set<Film> getFilms() {
		return selectedKorisnik.getFilms();
	}

	public void setFilms(Set<Film> films) {
		selectedKorisnik.setFilms(films);
	}
	
	public Igrica getIgrica() {
		return igrica;
	}

	public void setIgrica(Igrica igrica) {
		this.igrica = igrica;
	}


	public boolean equals(Object obj) {
		return selectedKorisnik.equals(obj);
	}

	public Korisnik getSelectedKorisnik() {
		return selectedKorisnik;
	}

	public void setSelectedKorisnik(Korisnik selectedKorisnik) {
		this.selectedKorisnik = selectedKorisnik;
	}

	public Film getFilm() {
		return film;
	}

	public void setFilm(Film film) {
		this.film = film;
	}


	public Strip getStrip() {
		return strip;
	}


	public void setStrip(Strip strip) {
		this.strip = strip;
	}
	
	public void onRowSelect(SelectEvent<Korisnik> event) {
		Korisnik k = event.getObject();  
    }
	
	

}
