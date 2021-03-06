package br.com.ikaros.model;
// Generated Sep 5, 2017 1:14:19 PM by Hibernate Tools 5.1.4.Final

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Itinerario generated by hbm2java
 */
@Entity
@Table(name = "itinerario", catalog = "fluvialpass")
public class Itinerario implements java.io.Serializable {

	private Integer idItinerario;
	private String nomeItinerario;
	private Set<Cidade> cidades = new HashSet<Cidade>(0);
	private Set<Viagem> viagems = new HashSet<Viagem>(0);

	public Itinerario() {
	}

	public Itinerario(String nomeItinerario, Set<Cidade> cidades, Set<Viagem> viagems) {
		this.nomeItinerario = nomeItinerario;
		this.cidades = cidades;
		this.viagems = viagems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idItinerario", unique = true, nullable = false)
	public Integer getIdItinerario() {
		return this.idItinerario;
	}

	public void setIdItinerario(Integer idItinerario) {
		this.idItinerario = idItinerario;
	}

	@Column(name = "nomeItinerario", length = 256)
	public String getNomeItinerario() {
		return this.nomeItinerario;
	}

	public void setNomeItinerario(String nomeItinerario) {
		this.nomeItinerario = nomeItinerario;
	}

	@ManyToMany(fetch = FetchType.LAZY, mappedBy = "itinerarios")
	public Set<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "itinerario")
	public Set<Viagem> getViagems() {
		return this.viagems;
	}

	public void setViagems(Set<Viagem> viagems) {
		this.viagems = viagems;
	}

}
