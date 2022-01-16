package com.serasa.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Response;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@Configuration
public class SwaggerConfig {

	@Bean
	public Docket api() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.serasa.api.controller"))
				.paths(PathSelectors.any()).build().apiInfo(metadata()).useDefaultResponseMessages(false)
				.globalResponses(HttpMethod.GET, responseMessage())
				.globalResponses(HttpMethod.POST, responseMessage());
	}

	public static ApiInfo metadata() {
		return new ApiInfoBuilder()
				.title("API - Serasa")
				.description("Projeto API Spring - Serasa")
				.version("1.0.0")
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/george-git-dev")
				.contact(contact()).build();
	}

	private static Contact contact() {
		return new Contact("George S. Silva", "https://github.com/george-git-dev", "george-souza91@hotmail.com");
	}

	private static List<Response> responseMessage() {
		return new ArrayList<Response>() {
			private static final long serialVersionUID = 1L;
			{
				add(new ResponseBuilder().code("200").description("Sucesso!").build());
				add(new ResponseBuilder().code("201").description("Criado!").build());
				add(new ResponseBuilder().code("204").description("Não há conteúdo!").build());
			}
		};
	}
}
