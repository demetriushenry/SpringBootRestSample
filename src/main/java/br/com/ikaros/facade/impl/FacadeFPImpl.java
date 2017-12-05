package br.com.ikaros.facade.impl;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ikaros.facade.FacadeFP;
import br.com.ikaros.model.Bairro;
import br.com.ikaros.model.Cidade;
import br.com.ikaros.model.Estado;
import br.com.ikaros.model.Usuario;
import br.com.ikaros.service.BairroService;
import br.com.ikaros.service.CidadeService;
import br.com.ikaros.service.EstadoService;
import br.com.ikaros.service.UsuarioService;

@Service
public class FacadeFPImpl implements FacadeFP {

	private final BairroService bairroService;
	private final UsuarioService usuarioService;
	private final EstadoService estadoService;
	private final CidadeService cidadeService;

	@Autowired
	public FacadeFPImpl(BairroService bairroService, UsuarioService usuarioService, EstadoService estadoService,
			CidadeService cidadeService) {
		this.bairroService = bairroService;
		this.usuarioService = usuarioService;
		this.estadoService = estadoService;
		this.cidadeService = cidadeService;
	}

	@Override
	public Collection<Bairro> findAllBairros() {
		return bairroService.findAll();
	}

	@Override
	public Bairro findOneBairro(int id) {
		return bairroService.findOne(id);
	}

	@Override
	public Bairro saveBairro(Bairro bairro) {
		return bairroService.save(bairro);
	}

	@Override
	public Bairro updateBairro(Bairro bairro) {
		return bairroService.update(bairro);
	}

	@Override
	public void deleteBairro(Bairro bairro) {
		bairroService.delete(bairro);
	}

	@Override
	public void deleteBairro(int id) {
		bairroService.delete(id);
	}

	@Override
	public boolean existsBairro(int id) {
		return bairroService.exists(id);
	}

	@Override
	public Collection<Usuario> findAllUsuarios() {
		return usuarioService.findAll();
	}

	@Override
	public Usuario findOneUsuario(int id) {
		return usuarioService.findOne(id);
	}

	@Override
	public Usuario saveUsuario(Usuario usuario) {
		return usuarioService.save(usuario);
	}

	@Override
	public Usuario updateUsuario(Usuario usuario) {
		return usuarioService.update(usuario);
	}

	@Override
	public void deleteBairro(Usuario usuario) {
		usuarioService.delete(usuario);
	}

	@Override
	public void deleteUsuario(int id) {
		usuarioService.delete(id);
	}

	@Override
	public boolean existsUsuario(int id) {
		return usuarioService.exists(id);
	}

	@Override
	public void validateUser(Principal principal) {
		usuarioService.validadeUser(principal);
	}
	
	@Override
	public Optional<Usuario> findByUsername(String nomeUsuario) {
		return usuarioService.findByUsername(nomeUsuario);
	}

	@Override
	public Collection<Estado> findAllEstados() {
		return estadoService.findAll();
	}

	@Override
	public Estado findOneEstado(int id) {
		return estadoService.findOne(id);
	}

	@Override
	public Estado saveEstado(Estado estado) {
		return estadoService.save(estado);
	}

	@Override
	public Estado updateEstado(Estado estado) {
		return estadoService.update(estado);
	}

	@Override
	public void deleteEstado(Estado estado) {
		estadoService.delete(estado);
	}

	@Override
	public void deleteEstado(int id) {
		estadoService.delete(id);
	}

	@Override
	public boolean existsEstado(int id) {
		return estadoService.exists(id);
	}

	@Override
	public Collection<Cidade> findAllCidades() {
		return cidadeService.findAll();
	}

	@Override
	public Cidade findOneCidade(int id) {
		return cidadeService.findOne(id);
	}

	@Override
	public Cidade saveCidade(Cidade cidade) {
		return cidadeService.save(cidade);
	}

	@Override
	public Cidade updateCidade(Cidade cidade) {
		return cidadeService.update(cidade);
	}

	@Override
	public void deleteCidade(Cidade cidade) {
		cidadeService.delete(cidade);
	}

	@Override
	public void deleteCidade(int id) {
		cidadeService.delete(id);
	}

	@Override
	public boolean existsCidade(int id) {
		return cidadeService.exists(id);
	}

}
