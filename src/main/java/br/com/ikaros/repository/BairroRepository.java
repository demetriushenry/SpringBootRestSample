package br.com.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ikaros.model.Bairro;

public interface BairroRepository extends JpaRepository<Bairro, Integer> {
	
	
}
