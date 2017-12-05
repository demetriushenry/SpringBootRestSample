package br.com.ikaros.facade;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import br.com.ikaros.model.Bairro;
import br.com.ikaros.model.Cidade;
import br.com.ikaros.model.Estado;
import br.com.ikaros.model.Usuario;

public interface FacadeFP {
	// Bairro
	public Collection<Bairro> findAllBairros();
	
	public Bairro findOneBairro(int id);
	
	public Bairro saveBairro(Bairro bairro);
	
	public Bairro updateBairro(Bairro bairro);
	
	public void deleteBairro(Bairro bairro);
	
	public void deleteBairro(int id);
	
	public boolean existsBairro(int id);
	// ----
	// Usuario
	public Collection<Usuario> findAllUsuarios();
	
	public Usuario findOneUsuario(int id);
	
	public Usuario saveUsuario(Usuario usuario);
	
	public Usuario updateUsuario(Usuario usuario);
	
	public void deleteBairro(Usuario usuario);
	
	public void deleteUsuario(int id);
	
	public boolean existsUsuario(int id);
	
	public void validateUser(Principal principal);
	
	public Optional<Usuario> findByUsername(String nomeUsuario);
	// ----
	// Estado
	public Collection<Estado> findAllEstados();
	
	public Estado findOneEstado(int id);
	
	public Estado saveEstado(Estado estado);
	
	public Estado updateEstado(Estado estado);
	
	public void deleteEstado(Estado estado);
	
	public void deleteEstado(int id);
	
	public boolean existsEstado(int id);
	// ----
	// Cidade
	public Collection<Cidade> findAllCidades();
	
	public Cidade findOneCidade(int id);
	
	public Cidade saveCidade(Cidade cidade);
	
	public Cidade updateCidade(Cidade cidade);
	
	public void deleteCidade(Cidade cidade);
	
	public void deleteCidade(int id);
	
	public boolean existsCidade(int id);
	// ----

}
