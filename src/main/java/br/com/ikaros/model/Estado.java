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
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Estado generated by hbm2java
 */
@Entity
@Table(name = "estado", catalog = "fluvialpass")
public class Estado implements java.io.Serializable {

	private Integer idEstado;
	private String nomeEstado;
	private String siglaEstado;
	private Set<Cidade> cidades = new HashSet<Cidade>(0);

	public Estado() {
	}
	
	public Estado(String nomeEstado, String siglaEstado) {
		this.nomeEstado = nomeEstado;
		this.siglaEstado = siglaEstado;
	}

	public Estado(String nomeEstado, String siglaEstado, Set<Cidade> cidades) {
		this.nomeEstado = nomeEstado;
		this.siglaEstado = siglaEstado;
		this.cidades = cidades;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEstado", unique = true, nullable = false)
	public Integer getIdEstado() {
		return this.idEstado;
	}

	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}

	@Column(name = "nomeEstado", length = 45)
	public String getNomeEstado() {
		return this.nomeEstado;
	}

	public void setNomeEstado(String nomeEstado) {
		this.nomeEstado = nomeEstado;
	}

	@Column(name = "siglaEstado", length = 45)
	public String getSiglaEstado() {
		return this.siglaEstado;
	}

	public void setSiglaEstado(String siglaEstado) {
		this.siglaEstado = siglaEstado;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "estado")
	public Set<Cidade> getCidades() {
		return this.cidades;
	}

	public void setCidades(Set<Cidade> cidades) {
		this.cidades = cidades;
	}

}
