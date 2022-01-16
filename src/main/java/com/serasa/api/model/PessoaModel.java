package com.serasa.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data // cria os getters e setters automaticamente
@Entity
public class PessoaModel {

	@Id // Diz ao banco de dados que esse atributo será o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automáticamente os ID's (auto-increment)
	private Long id;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String telefone;

	@Column(nullable = false)
	private int idade;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false)
	private String estado;

	@Column(nullable = false)
	private int score;

}
