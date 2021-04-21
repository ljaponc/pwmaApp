package me.fit.project.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@XmlRootElement
public class Igrica implements Serializable{

	private static final long serialVersionUID = -6259826457388313121L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "igrica_seq")
	@SequenceGenerator(name = "igrica_seq", sequenceName = "igrica_seq", allocationSize = 1)
	private Long id;
	
	private String naziv;
	
	@ManyToOne
	private Korisnik korisnik;

	public Igrica() {
		super();
	}
	
	public Igrica(Long id, String naziv, Korisnik korisnik) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.korisnik = korisnik;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}
	
	
	
}
