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
 * TipoPassagem generated by hbm2java
 */
@Entity
@Table(name = "tipo_passagem", catalog = "fluvialpass")
public class TipoPassagem implements java.io.Serializable {

	private Integer idTipoPassagem;
	private String nomeTipoPassagem;
	private Set<Passagem> passagems = new HashSet<Passagem>(0);

	public TipoPassagem() {
	}

	public TipoPassagem(String nomeTipoPassagem, Set<Passagem> passagems) {
		this.nomeTipoPassagem = nomeTipoPassagem;
		this.passagems = passagems;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idTipo_passagem", unique = true, nullable = false)
	public Integer getIdTipoPassagem() {
		return this.idTipoPassagem;
	}

	public void setIdTipoPassagem(Integer idTipoPassagem) {
		this.idTipoPassagem = idTipoPassagem;
	}

	@Column(name = "nomeTipoPassagem", length = 45)
	public String getNomeTipoPassagem() {
		return this.nomeTipoPassagem;
	}

	public void setNomeTipoPassagem(String nomeTipoPassagem) {
		this.nomeTipoPassagem = nomeTipoPassagem;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "tipoPassagem")
	public Set<Passagem> getPassagems() {
		return this.passagems;
	}

	public void setPassagems(Set<Passagem> passagems) {
		this.passagems = passagems;
	}

}
