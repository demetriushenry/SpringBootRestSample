package br.com.ikaros.serviceimpl;

import java.security.Principal;
import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ikaros.exception.UserNotFoundException;
import br.com.ikaros.model.Usuario;
import br.com.ikaros.repository.UsuarioRepository;
import br.com.ikaros.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {
	
	private final UsuarioRepository usuarioRepository;
	
	@Autowired
	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Collection<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	@Override
	public Usuario findOne(int id) {
		return usuarioRepository.findOne(id);
	}

	@Override
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return usuarioRepository.saveAndFlush(usuario);
	}

	@Override
	public void delete(Usuario usuario) {
		usuarioRepository.delete(usuario);
	}

	@Override
	public void delete(int id) {
		usuarioRepository.delete(id);
	}

	@Override
	public boolean exists(int id) {
		return usuarioRepository.exists(id);
	}

	@Override
	public void validadeUser(Principal principal) {
		String userId = principal.getName();
		usuarioRepository.findByNomeUsuario(userId)
		.orElseThrow(() -> new UserNotFoundException(userId));
	}

	@Override
	public Optional<Usuario> findByUsername(String nomeUsuario) {
		return usuarioRepository.findByNomeUsuario(nomeUsuario);
	}

}
