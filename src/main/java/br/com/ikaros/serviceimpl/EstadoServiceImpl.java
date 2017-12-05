package br.com.ikaros.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ikaros.model.Estado;
import br.com.ikaros.repository.EstadoRepository;
import br.com.ikaros.service.EstadoService;

@Service
public class EstadoServiceImpl implements EstadoService {
	
	private final EstadoRepository estadoRepository;
	
	@Autowired
	public EstadoServiceImpl(EstadoRepository estadoRepository) {
		this.estadoRepository = estadoRepository;
	}

	@Override
	public Collection<Estado> findAll() {
		return estadoRepository.findAll();
	}

	@Override
	public Estado findOne(int id) {
		return estadoRepository.findOne(id);
	}

	@Override
	public Estado save(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Override
	public Estado update(Estado estado) {
		return estadoRepository.save(estado);
	}

	@Override
	public void delete(Estado estado) {
		estadoRepository.delete(estado);
	}

	@Override
	public void delete(int id) {
		estadoRepository.delete(id);
	}

	@Override
	public boolean exists(int id) {
		return estadoRepository.exists(id);
	}

}
