package com.serasa.api.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.serasa.api.model.PessoaModel;
import com.serasa.api.repository.RepositoryPessoa;

@Service
public class PessoaService {

	@Autowired
	RepositoryPessoa pessoaRepository;

	
	public Optional<PessoaModel> cadastrarPessoa(PessoaModel pessoa) {

		int score = pessoa.getScore();

		if (score < 0 || score > 1000)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Digite um valor entre 0 e 1000!", null);


		if (score >= 0 && score <= 200) {
			pessoa.setScoreDescricao("Insuficiente");
			
		} else if (score >= 201 && score <= 500) {
			pessoa.setScoreDescricao("Inaceitável");
			
		} else if (score >= 501 && score <= 700) {
			pessoa.setScoreDescricao("Aceitável");
			
		} else if (score >= 701 && score <= 1000) {
			pessoa.setScoreDescricao("Recomendável");
		}

		return Optional.of(pessoaRepository.save(pessoa));

	}

}