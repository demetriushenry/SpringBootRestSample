package br.com.ikaros.model;
// Generated Sep 5, 2017 1:14:19 PM by Hibernate Tools 5.1.4.Final

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Passagem generated by hbm2java
 */
@Entity
@Table(name = "passagem", catalog = "fluvialpass")
public class Passagem implements java.io.Serializable {

	private Integer idPassagem;
	private Barco barco;
	private TipoPassagem tipoPassagem;
	private UsuarioApp usuarioApp;
	private UsuarioVendedorPassagem usuarioVendedorPassagem;
	private UsuarioWeb usuarioWeb;
	private Viagem viagem;
	private String codPassagem;
	private Date dataCompraPassagem;
	private Float valorTotalPassagem;
	private String nomeUsuario;
	private Integer idadeUsuario;

	public Passagem() {
	}

	public Passagem(Barco barco, TipoPassagem tipoPassagem, Viagem viagem) {
		this.barco = barco;
		this.tipoPassagem = tipoPassagem;
		this.viagem = viagem;
	}

	public Passagem(Barco barco, TipoPassagem tipoPassagem, UsuarioApp usuarioApp,
			UsuarioVendedorPassagem usuarioVendedorPassagem, UsuarioWeb usuarioWeb, Viagem viagem, String codPassagem,
			Date dataCompraPassagem, Float valorTotalPassagem, String nomeUsuario, Integer idadeUsuario) {
		this.barco = barco;
		this.tipoPassagem = tipoPassagem;
		this.usuarioApp = usuarioApp;
		this.usuarioVendedorPassagem = usuarioVendedorPassagem;
		this.usuarioWeb = usuarioWeb;
		this.viagem = viagem;
		this.codPassagem = codPassagem;
		this.dataCompraPassagem = dataCompraPassagem;
		this.valorTotalPassagem = valorTotalPassagem;
		this.nomeUsuario = nomeUsuario;
		this.idadeUsuario = idadeUsuario;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)

	@Column(name = "idPassagem", unique = true, nullable = false)
	public Integer getIdPassagem() {
		return this.idPassagem;
	}

	public void setIdPassagem(Integer idPassagem) {
		this.idPassagem = idPassagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idBarco", nullable = false)
	public Barco getBarco() {
		return this.barco;
	}

	public void setBarco(Barco barco) {
		this.barco = barco;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idTipo_passagem", nullable = false)
	public TipoPassagem getTipoPassagem() {
		return this.tipoPassagem;
	}

	public void setTipoPassagem(TipoPassagem tipoPassagem) {
		this.tipoPassagem = tipoPassagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "idusuario_app", insertable = false, updatable = false),
		@JoinColumn(name = "usuario_idUsuario", insertable = false, updatable = false)
	})
	public UsuarioApp getUsuarioApp() {
		return this.usuarioApp;
	}

	public void setUsuarioApp(UsuarioApp usuarioApp) {
		this.usuarioApp = usuarioApp;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "idusuario_vendedor_passagem", insertable = false, updatable = false),
		@JoinColumn(name = "usuario_idUsuario", insertable = false, updatable = false)
	})
	public UsuarioVendedorPassagem getUsuarioVendedorPassagem() {
		return this.usuarioVendedorPassagem;
	}

	public void setUsuarioVendedorPassagem(UsuarioVendedorPassagem usuarioVendedorPassagem) {
		this.usuarioVendedorPassagem = usuarioVendedorPassagem;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
		@JoinColumn(name = "idusuario_web", insertable = false, updatable = false),
		@JoinColumn(name = "usuario_idUsuario", insertable = false, updatable = false)
	})
	public UsuarioWeb getUsuarioWeb() {
		return this.usuarioWeb;
	}

	public void setUsuarioWeb(UsuarioWeb usuarioWeb) {
		this.usuarioWeb = usuarioWeb;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idViagem", nullable = false)
	public Viagem getViagem() {
		return this.viagem;
	}

	public void setViagem(Viagem viagem) {
		this.viagem = viagem;
	}

	@Column(name = "codPassagem", length = 45)
	public String getCodPassagem() {
		return this.codPassagem;
	}

	public void setCodPassagem(String codPassagem) {
		this.codPassagem = codPassagem;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "dataCompraPassagem", length = 10)
	public Date getDataCompraPassagem() {
		return this.dataCompraPassagem;
	}

	public void setDataCompraPassagem(Date dataCompraPassagem) {
		this.dataCompraPassagem = dataCompraPassagem;
	}

	@Column(name = "valorTotalPassagem", precision = 12, scale = 0)
	public Float getValorTotalPassagem() {
		return this.valorTotalPassagem;
	}

	public void setValorTotalPassagem(Float valorTotalPassagem) {
		this.valorTotalPassagem = valorTotalPassagem;
	}

	@Column(name = "nomeUsuario", length = 256)
	public String getNomeUsuario() {
		return this.nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Column(name = "idadeUsuario")
	public Integer getIdadeUsuario() {
		return this.idadeUsuario;
	}

	public void setIdadeUsuario(Integer idadeUsuario) {
		this.idadeUsuario = idadeUsuario;
	}

}
