package com.serasa.api.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.serasa.api.model.PessoaModel;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class PessoaControllerTest {

	@Autowired
	private TestRestTemplate testRestTemplate;

	private PessoaModel pessoaModel;

	@BeforeEach
	public void start() {

		pessoaModel = new PessoaModel(0L, "George", "11999999999", 30, "taboao", "SP", 500);

	}

	
	@Test
	@DisplayName("Cadastrar Pessoa")
	@Order(1)
	public void salvarUsuarioRetornaStatus201() {

		HttpEntity<PessoaModel> request = new HttpEntity<PessoaModel>(pessoaModel);
		
		ResponseEntity<PessoaModel> resposta = testRestTemplate.exchange("/pessoa", HttpMethod.POST, request, PessoaModel.class);
		
		assertEquals(HttpStatus.CREATED, resposta.getStatusCode());

	}

	@Test
	@DisplayName("Listar todas as pessoas")
	@Order(2)
	public void buscarPessoaRetornaStatus200() {

		ResponseEntity<String> resposta = testRestTemplate.exchange("/pessoa", HttpMethod.GET, null, String.class);
		
		assertEquals(HttpStatus.OK, resposta.getStatusCode());

	}

}
