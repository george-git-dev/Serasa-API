package com.serasa.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serasa.api.model.ContatoModel;

public interface RepositoryContato extends JpaRepository<ContatoModel, Long>{
	
	

}
