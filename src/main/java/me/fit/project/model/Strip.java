package me.fit.project.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = Strip.GET_ALL, query = "Select s from Strip s")})
@XmlRootElement
public class Strip implements Serializable{

	private static final long serialVersionUID = 5L;
	
	public static final String GET_ALL = "Strip.getAll";
	public static final String GET_BY_NAME = "Strip.getByName";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "strip_seq")
	@SequenceGenerator(name = "strip_seq", sequenceName = "strip_seq", allocationSize = 1)
	private Long id;
	
	private String naziv;
	private String zanr;
	private String autor;
	private int brStrana;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="strip", fetch=FetchType.EAGER)
	private Set<Korisnik> korisnici;
	

	public Strip() {
		super();
	}
	
	public Strip(Long id, String naziv, String autor, String zanr, int brStrana, Set<Korisnik> korisnici ) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.zanr = zanr;
		this.brStrana = brStrana;
		this.korisnici = korisnici;
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


	public String getZanr() {
		return zanr;
	}

	public void setZanr(String zanr) {
		this.zanr = zanr;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public int getBrStrana() {
		return brStrana;
	}

	public void setBrStrana(int brStrana) {
		this.brStrana = brStrana;
	}


	@Override
	public String toString() {
		
		
		return "Strip [id=" + id + ", naziv=" + naziv + ", zanr=" + zanr + ", autor=" + autor + ", brStrana=" + brStrana;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Strip other = (Strip) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	public Set<Korisnik> getKorisnici() {
		return korisnici;
	}

	public void setKorisnici(Set<Korisnik> korisnici) {
		this.korisnici = korisnici;
	}
	
	
	
	
	
}

