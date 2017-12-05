package br.com.ikaros.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ikaros.model.Estado;

public interface EstadoRepository extends JpaRepository<Estado, Integer> {

}
