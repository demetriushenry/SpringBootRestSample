package br.com.ikaros.service;

import java.security.Principal;
import java.util.Optional;

import br.com.ikaros.model.Usuario;

public interface UsuarioService extends GenericService<Usuario> {
	
	void validadeUser(Principal principal);
	
	Optional<Usuario> findByUsername(String nomeUsuario);

}
