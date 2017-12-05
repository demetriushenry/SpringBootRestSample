package br.com.ikaros.model;
// Generated Sep 5, 2017 1:14:19 PM by Hibernate Tools 5.1.4.Final

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Login generated by hbm2java
 */
@Entity
@Table(name = "login", catalog = "fluvialpass")
public class Login implements java.io.Serializable {

	private LoginId id;
	private Usuario usuario;
	private String nomeUsuario;
	private String senhaUsuario;

	public Login() {
	}

	public Login(LoginId id, Usuario usuario) {
		this.id = id;
		this.usuario = usuario;
	}

	public Login(LoginId id, Usuario usuario, String nomeUsuario, String senhaUsuario) {
		this.id = id;
		this.usuario = usuario;
		this.nomeUsuario = nomeUsuario;
		this.senhaUsuario = senhaUsuario;
	}

	@EmbeddedId

	@AttributeOverrides({ @AttributeOverride(name = "idlogin", column = @Column(name = "idlogin", nullable = false)),
			@AttributeOverride(name = "usuarioIdUsuario", column = @Column(name = "usuario_idUsuario", nullable = false)) })
	public LoginId getId() {
		return this.id;
	}

	public void setId(LoginId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "usuario_idUsuario", nullable = false, insertable = false, updatable = false)
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@Column(name = "nomeUsuario", length = 256)
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(name = "senhaUsuario", length = 256)
	public String getSenhaUsuario() {
		return this.senhaUsuario;
	}

	public void setSenhaUsuario(String senhaUsuario) {
		this.senhaUsuario = senhaUsuario;
	}

}