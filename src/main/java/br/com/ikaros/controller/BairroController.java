package br.com.ikaros.controller;

import java.net.URI;
import java.security.Principal;
import java.util.Collection;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import br.com.ikaros.facade.FacadeFP;
import br.com.ikaros.model.Bairro;

@RestController
@RequestMapping("/{userId}/bairros")
public class BairroController {

	private final FacadeFP facade;

	@Autowired
	public BairroController(FacadeFP facade) {
		this.facade = facade;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	ResponseEntity<?> create(Principal principal, @RequestBody @Valid Bairro bairro) {
		facade.validateUser(principal);
		Bairro result = facade.saveBairro(new Bairro(bairro.getCidade(), bairro.getNomeBairro()));

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{idBairro}")
				.buildAndExpand(result.getIdBairro()).toUri();

		if (location != null)
			return ResponseEntity.created(location).build();
		else
			return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.GET)
	ResponseEntity<Collection<Bairro>> readAll(Principal principal) {
		facade.validateUser(principal);
		return new ResponseEntity<Collection<Bairro>>(facade.findAllBairros(), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	ResponseEntity<Bairro> readSingle(Principal principal, @PathVariable int id) {
		facade.validateUser(principal);
		return new ResponseEntity<Bairro>(facade.findOneBairro(id), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.OK)
	ResponseEntity<Bairro> update(Principal principal, @RequestBody @Valid Bairro bairro) {
		facade.validateUser(principal);
		Bairro result;
		if (facade.existsBairro(bairro.getIdBairro())) {
			result = facade.updateBairro(bairro);
			return new ResponseEntity<Bairro>(result, HttpStatus.OK);
		} else {
			return ResponseEntity.noContent().build();
		}			
	}
	
	@RequestMapping(method = RequestMethod.DELETE) /*@DeleteMapping*/
	ResponseEntity<?> delete(Principal principal, @RequestBody @Valid Bairro bairro) {
		facade.validateUser(principal);
		Bairro delBairro = facade.findOneBairro(bairro.getIdBairro());
		facade.deleteBairro(delBairro);
		return ResponseEntity.noContent().build();
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}") /*@DeleteMapping*/
	ResponseEntity<?> deleteId(Principal principal, @PathVariable int id) {
		facade.validateUser(principal);
		Bairro delBairro = facade.findOneBairro(id);
		facade.deleteBairro(delBairro);
		return ResponseEntity.noContent().build();
	}

}
