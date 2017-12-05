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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Destino generated by hbm2java
 */
@Entity
@Table(name = "destino", catalog = "fluvialpass")
public class Destino implements java.io.Serializable {

	private Integer idDestino;
	private Cidade cidade;
	private Porto porto;
	private String nomeDestino;
	private Float valorPassagemCrianca03anos;
	private Float valorPassagemCrianca312anos;
	private Float valorPassagem;
	private Set<Barco> barcos = new HashSet<Barco>(0);

	public Destino() {
	}

	public Destino(Cidade cidade, Porto porto) {
		this.cidade = cidade;
		this.porto = porto;
	}

	public Destino(Cidade cidade, Porto porto, String nomeDestino, Float valorPassagemCrianca03anos,
			Float valorPassagemCrianca312anos, Float valorPassagem, Set<Barco> barcos) {
		this.cidade = cidade;
		this.porto = porto;
		this.nomeDestino = nomeDestino;
		this.valorPassagemCrianca03anos = valorPassagemCrianca03anos;
		this.valorPassagemCrianca312anos = valorPassagemCrianca312anos;
		this.valorPassagem = valorPassagem;
		this.barcos = barcos;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idDestino", unique = true, nullable = false)
	public Integer getIdDestino() {
		return this.idDestino;
	}

	public void setIdDestino(Integer idDestino) {
		this.idDestino = idDestino;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCidade", nullable = false)
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idPorto", nullable = false)
	public Porto getPorto() {
		return this.porto;
	}

	public void setPorto(Porto porto) {
		this.porto = porto;
	}

	@Column(name = "nomeDestino", length = 256)
	public String getNomeDestino() {
		return this.nomeDestino;
	}

	public void setNomeDestino(String nomeDestino) {
		this.nomeDestino = nomeDestino;
	}

	@Column(name = "valorPassagemCrianca0_3anos", precision = 12, scale = 0)
	public Float getValorPassagemCrianca03anos() {
		return this.valorPassagemCrianca03anos;
	}

	public void setValorPassagemCrianca03anos(Float valorPassagemCrianca03anos) {
		this.valorPassagemCrianca03anos = valorPassagemCrianca03anos;
	}

	@Column(name = "valorPassagemCrianca3_12anos", precision = 12, scale = 0)
	public Float getValorPassagemCrianca312anos() {
		return this.valorPassagemCrianca312anos;
	}

	public void setValorPassagemCrianca312anos(Float valorPassagemCrianca312anos) {
		this.valorPassagemCrianca312anos = valorPassagemCrianca312anos;
	}

	@Column(name = "valorPassagem", precision = 12, scale = 0)
	public Float getValorPassagem() {
		return this.valorPassagem;
	}

	public void setValorPassagem(Float valorPassagem) {
		this.valorPassagem = valorPassagem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "destino")
	public Set<Barco> getBarcos() {
		return this.barcos;
	}

	public void setBarcos(Set<Barco> barcos) {
		this.barcos = barcos;
	}

}
