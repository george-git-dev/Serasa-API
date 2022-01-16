package com.serasa.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serasa.api.model.PessoaModel;
import com.serasa.api.repository.RepositoryPessoa;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {

	@Autowired
	private RepositoryPessoa repository;

	@GetMapping
	public ResponseEntity<List<PessoaModel>> getAll() {
		List<PessoaModel> objList = repository.findAll();

		if (objList.isEmpty()) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		} else {
			return ResponseEntity.status(HttpStatus.OK).body(objList);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaModel> GetById(@PathVariable long id) {
		return repository.findById(id).map(resposta -> ResponseEntity.status(HttpStatus.OK).body(resposta))
				.orElse(ResponseEntity.status(HttpStatus.NO_CONTENT).build());
	}

	@PostMapping
	public ResponseEntity<PessoaModel> post(@RequestBody PessoaModel cadastro) {
		return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(cadastro));
	}

}
