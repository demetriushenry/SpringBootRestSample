package br.com.ikaros.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configurers.GlobalAuthenticationConfigurerAdapter;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import br.com.ikaros.facade.FacadeFP;

@Configuration
public class WebSecurityConfiguration extends GlobalAuthenticationConfigurerAdapter {

	@Autowired
	FacadeFP repository;

	@Override
	public void init(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService());
	}

	UserDetailsService userDetailsService() {
		return (username) -> repository.findByUsername(username)
				.map(a -> new User(a.getNomeUsuario(), a.getSenhaAdmin(), true, true, true, true,
						AuthorityUtils.createAuthorityList("ROLE_USER", "write")))
				.orElseThrow(() -> new UsernameNotFoundException("could not find the user '" + username + "'"));
	}

}
