package br.com.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import br.com.ikaros.model.Cidade;

@RepositoryRestController
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
