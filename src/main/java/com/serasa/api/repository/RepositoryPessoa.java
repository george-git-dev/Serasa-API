package com.serasa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.api.model.PessoaModel;

// Essa interface herda de JpaRepository sendo assim é possível usar vários métodos já implementados do próprio JPA.
public interface RepositoryPessoa extends JpaRepository<PessoaModel, Long>{
	
	

}
