/*
 * JBoss, Home of Professional Open Source
 * Copyright 2013, Red Hat, Inc. and/or its affiliates, and individual
 * contributors by the @authors tag. See the copyright.txt in the
 * distribution for a full listing of individual contributors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.fit.project.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@NamedQueries({ @NamedQuery(name = Korisnik.GET_ALL, query = "Select s from Korisnik s"),
		@NamedQuery(name = Korisnik.GET_BY_NAME, query = "Select s from Korisnik s where s.name = :ime") })
@XmlRootElement
public class Korisnik implements Serializable {

	private static final long serialVersionUID = 1L;

	public static final String GET_ALL = "Korisnik.getAll";
	public static final String GET_BY_NAME = "Korisnik.getByName";

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "korsinik_seq")
	@SequenceGenerator(name = "korsinik_seq", sequenceName = "korsinik_seq", allocationSize = 1)
	private Long id;

	private String name;

	private String email;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="korisnik", fetch=FetchType.EAGER)
	private Set<Film> films;
	
	@OneToMany(cascade=CascadeType.ALL, orphanRemoval=true, mappedBy="korisnik", fetch=FetchType.EAGER)
	private Set<Igrica> igrice;
	
	@ManyToOne
	private Strip strip;
	

	public Korisnik() {
		super();
	}

	public Korisnik(String name, String email, Set<Film> films, Set<Igrica> igrice, Strip strip) {
		super();
		this.name = name;
		this.email = email;
		this.films = films;
		this.igrice = igrice;
		this.strip = strip;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Film> getFilms() {
		return films;
	}

	public void setFilms(Set<Film> films) {
		this.films = films;
	}
	
	public Set<Igrica> getIgrice() {
		return igrice;
	}

	public void setIgrica(Set<Igrica> igrice) {
		this.igrice = igrice;
	}
	
	public Strip getStrip() {
		return strip;
	}

	public void setStrip(Strip strip) {
		this.strip = strip;
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
		Korisnik other = (Korisnik) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Korisnik [id=" + id + ", name=" + name + ", email=" + email + ", films=" + films + "]";
	}

}
