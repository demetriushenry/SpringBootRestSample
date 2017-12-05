package br.com.ikaros.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ikaros.model.Bairro;
import br.com.ikaros.repository.BairroRepository;
import br.com.ikaros.service.BairroService;

@Service
public class BairroServiceImpl implements BairroService {
	
	private final BairroRepository bairroRepository;
	
	@Autowired
	public BairroServiceImpl(BairroRepository bairroRepository) {
		this.bairroRepository = bairroRepository;
	}

	@Override
	public Collection<Bairro> findAll() {
		return bairroRepository.findAll();
	}

	@Override
	public Bairro findOne(int id) {
		return bairroRepository.findOne(id);
	}

	@Override
	public Bairro save(Bairro bairro) {
		return bairroRepository.save(bairro);
	}

	@Override
	public Bairro update(Bairro bairro) {
		Bairro updateBairro = findOne(bairro.getIdBairro());
		updateBairro.setCidade(bairro.getCidade());
		updateBairro.setNomeBairro(bairro.getNomeBairro());
		updateBairro.setCeps(bairro.getCeps());
		return bairroRepository.saveAndFlush(updateBairro);
	}

	@Override
	public void delete(Bairro bairro) {
		bairroRepository.delete(bairro);
	}

	@Override
	public void delete(int id) {
		bairroRepository.delete(id);
	}

	@Override
	public boolean exists(int id) {
		return bairroRepository.exists(id);
	}
	
}
