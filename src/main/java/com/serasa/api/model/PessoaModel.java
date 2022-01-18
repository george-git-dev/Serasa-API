package com.serasa.api.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data // cria os getters e setters automaticamente
@Entity
public class PessoaModel {

	@Id // Diz ao banco de dados que esse atributo será o ID
	@GeneratedValue(strategy = GenerationType.IDENTITY) // Gera automáticamente os ID's (auto-increment)
	private Long id;

	@NotNull(message = "O nome é obrigatório")
	private String nome;

	@NotNull(message = "Informe seu telefone")
	private String telefone;

	@NotNull(message = "Informe sua idade")
	private int idade;

	@NotNull(message = "Informe sua cidade")
	private String cidade;

	@NotNull(message = "Informe seu estado com dois dígitos")
	private String estado;

	@NotNull(message = "Informe o score")
	private int score;
	
	private String scoreDescricao;


	// Métodos construtores para test jUnit

	public PessoaModel(Long id, String nome, String telefone, int idade, String cidade, String estado, int score) {
		this.id = id;
		this.nome = nome;
		this.telefone = telefone;
		this.idade = idade;
		this.cidade = cidade;
		this.estado = estado;
		this.score = score;
	}

	public PessoaModel() {

	}



}
