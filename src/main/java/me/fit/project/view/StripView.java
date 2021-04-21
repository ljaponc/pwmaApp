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

import me.fit.project.model.Korisnik;
import me.fit.project.model.Strip;
import me.fit.project.service.api.StripService;

@Named
@ViewScoped
public class StripView implements Serializable {

	private static final long serialVersionUID = 5L;
	
	@Inject
	private FacesContext facesContext;
	
	@Inject
	private StripService stripService;
	
	private Strip strip;
	
	private List<Strip> stripovi;
	
	private Strip selectedStrip;
	
	private Korisnik korisnik;
	
	@PostConstruct
	public void initNewStrip() {
		strip = new Strip();
		stripovi = stripService.getAllStripovi();
		korisnik = new Korisnik();
	}
	
	public void addNewStrip() throws Exception {
		try {
			System.out.println(strip.getNaziv());
			stripService.addStrip(strip);
			strip = new Strip();
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_INFO, "Unijet!", "Unos uspjesan");
			facesContext.addMessage(null, m);
			stripovi = stripService.getAllStripovi();
		} catch (Exception e) {
			FacesMessage m = new FacesMessage(FacesMessage.SEVERITY_ERROR, "Nije unijet", "Desila se greska");
			facesContext.addMessage(null, m);
		}
	}
	
	public void dodajKorisnika(Korisnik korisnik) {
		try {
			selectedStrip.getKorisnici().add(korisnik);
			korisnik.setStrip(selectedStrip);
			stripService.addStrip(selectedStrip);
			stripovi = stripService.getAllStripovi();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	

	public Strip getStrip() {
		return strip;
	}

	public void setStrip(Strip strip) {
		this.strip = strip;
	}

	public List<Strip> getStripovi() {
		return stripovi;
	}

	public void setStripovi(List<Strip> stripovi) {
		this.stripovi = stripovi;
	}

	public Strip getSelectedStrip() {
		return selectedStrip;
	}

	public void setSelectedStrip(Strip selectedStrip) {
		this.selectedStrip = selectedStrip;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
	
}
