package com.serasa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.api.model.ContatoModel;
import com.serasa.api.repository.RepositoryContato;

@RestController
@RequestMapping("/contato")
public class ContatoController {

	@Autowired
	private RepositoryContato repositorio;

	@GetMapping
	public List<ContatoModel> listar() {
		return repositorio.findAll();
	}

	@PostMapping
	public void salvar(@RequestBody ContatoModel contato) {
		repositorio.save(contato);
	}

	@PutMapping
	public void alterar(@RequestBody ContatoModel contato) {
		if (contato.getId() > 0)
			repositorio.save(contato);
	}

	@DeleteMapping
	public void excluir(@RequestBody ContatoModel contato) {
		repositorio.delete(contato);
	}

}
