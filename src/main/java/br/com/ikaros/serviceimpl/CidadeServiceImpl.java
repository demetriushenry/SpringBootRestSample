package br.com.ikaros.serviceimpl;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ikaros.model.Cidade;
import br.com.ikaros.repository.CidadeRepository;
import br.com.ikaros.service.CidadeService;

@Service
public class CidadeServiceImpl implements CidadeService {
	
	private final CidadeRepository cidadeRepository;
	
	@Autowired
	public CidadeServiceImpl(CidadeRepository cidadeRepository) {
		this.cidadeRepository = cidadeRepository;
	}

	@Override
	public Collection<Cidade> findAll() {
		return cidadeRepository.findAll();
	}

	@Override
	public Cidade findOne(int id) {
		return cidadeRepository.findOne(id);
	}

	@Override
	public Cidade save(Cidade cidade) {
		return cidadeRepository.save(cidade);
	}

	@Override
	public Cidade update(Cidade cidade) {
		Cidade updateCidade = findOne(cidade.getIdCidade());
		updateCidade.setEstado(cidade.getEstado());
		updateCidade.setNomeCidade(cidade.getNomeCidade());
		updateCidade.setSiglaCidade(cidade.getSiglaCidade());
		return cidadeRepository.saveAndFlush(updateCidade);
	}

	@Override
	public void delete(Cidade cidade) {
		cidadeRepository.delete(cidade);
	}

	@Override
	public void delete(int id) {
		cidadeRepository.delete(id);
	}

	@Override
	public boolean exists(int id) {
		return cidadeRepository.exists(id);
	}

}
