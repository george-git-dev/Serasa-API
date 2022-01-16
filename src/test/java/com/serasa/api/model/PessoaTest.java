package com.serasa.api.model;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)//Anotação para dizer ao spring que é uma classe de teste. | WebEnvironment.RANDOM_PORT > vai achar outra porta se a padrão 8080 estiver ocupada
class PessoaTest {
	//Objeto a ser testado
	public PessoaModel pessoaModel;
	
	//Injeção de dependencia para verificar a validação dos dados 
	@Autowired
	private ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
	Validator validator = factory.getValidator();

	//Método que se inicia primeiro para inserir os dados através do contrutor
	@BeforeEach
	public void start() {
		pessoaModel = new PessoaModel("George", "11999999999", 30, "taboao", "SP", 500);
	}

	//Método de teste, verifica se está vazio ou não
	@Test
	void validaUsuarioCorretoRetornaTrue() {
		Set<ConstraintViolation<PessoaModel>> objetoViolado = validator.validate(pessoaModel);
		
		System.out.println(objetoViolado.toString());

		assertTrue(objetoViolado.isEmpty());
	}

}
