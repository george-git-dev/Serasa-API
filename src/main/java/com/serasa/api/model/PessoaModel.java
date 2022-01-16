package com.serasa.api.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // cria os getters e setters automaticamente
@AllArgsConstructor // cria o construtor de contatoModel automaticamente
@NoArgsConstructor // cria um contrutor vazio(sem argumentos) automaticamente
@Entity
public class PessoaModel {

	@Id // Diz ao banco de dados que esse atributo será o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automáticamente os ID's (auto-increment)
	private Long id;
	
	@Column(nullable=false)
	private String nome;
	
	@Column(nullable=false)
	private String telefone;
	
	@Column(nullable=false)
	private int idade;
	
	@Column(nullable=false)
	private String cidade;
	
	@Column(nullable=false)
	private String estado;
	
	@Column(nullable=false)
	private int score;

}
