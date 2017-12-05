package br.com.ikaros.model;
// Generated Sep 5, 2017 1:14:19 PM by Hibernate Tools 5.1.4.Final

import static javax.persistence.GenerationType.IDENTITY;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Bairro generated by hbm2java
 */
@Entity
@Table(name = "bairro", catalog = "fluvialpass")
public class Bairro implements java.io.Serializable {

	private Integer idBairro;
	private Cidade cidade;
	private String nomeBairro;
	private Set<Cep> ceps = new HashSet<Cep>(0);

	public Bairro() {
	}

	public Bairro(Cidade cidade, String nomeBairro) {
		this.cidade = cidade;
		this.nomeBairro = nomeBairro;
	}

	public Bairro(Cidade cidade, String nomeBairro, Set<Cep> ceps) {
		this.cidade = cidade;
		this.nomeBairro = nomeBairro;
		this.ceps = ceps;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idBairro", unique = true, nullable = false)
	public Integer getIdBairro() {
		return this.idBairro;
	}

	public void setIdBairro(Integer idBairro) {
		this.idBairro = idBairro;
	}

//	@JsonIgnore
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idCidade", nullable = false)
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@Column(name = "nomeBairro", length = 45)
	public String getNomeBairro() {
		return this.nomeBairro;
	}

	public void setNomeBairro(String nomeBairro) {
		this.nomeBairro = nomeBairro;
	}

	@JsonIgnore
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "bairro")
	public Set<Cep> getCeps() {
		return this.ceps;
	}

	public void setCeps(Set<Cep> ceps) {
		this.ceps = ceps;
	}

	@Override
	public String toString() {
		return "Bairro [idBairro=" + idBairro + ", cidade=" + cidade.getIdCidade() + ", nomeBairro=" + nomeBairro + "]";
	}

}