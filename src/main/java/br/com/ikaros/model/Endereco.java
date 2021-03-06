package br.com.ikaros.model;
// Generated Sep 5, 2017 1:14:19 PM by Hibernate Tools 5.1.4.Final

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Endereco generated by hbm2java
 */
@Entity
@Table(name = "endereco", catalog = "fluvialpass")
public class Endereco implements java.io.Serializable {

	private Integer idEndereco;
	private Cep cep;
	private Porto porto;
	private Usuario usuario;
	private String numero;
	private String complemento;

	public Endereco() {
	}

	public Endereco(Cep cep) {
		this.cep = cep;
	}

	public Endereco(Cep cep, Porto porto, Usuario usuario, String numero, String complemento) {
		this.cep = cep;
		this.porto = porto;
		this.usuario = usuario;
		this.numero = numero;
		this.complemento = complemento;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idEndereco", unique = true, nullable = false)
	public Integer getIdEndereco() {
		return this.idEndereco;
	}

	public void setIdEndereco(Integer idEndereco) {
		this.idEndereco = idEndereco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "nCEP", nullable = false)
	public Cep getCep() {
		return this.cep;
	}

	public void setCep(Cep cep) {
		this.cep = cep;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPorto")
	public Porto getPorto() {
		return this.porto;
	}

	public void setPorto(Porto porto) {
		this.porto = porto;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idUsuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "numero", length = 45)
	public String getNumero() {
		return this.numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	@Column(name = "complemento", length = 256)
	public String getComplemento() {
		return this.complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

}
