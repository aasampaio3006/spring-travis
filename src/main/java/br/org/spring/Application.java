package br.org.spring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.org.spring.util.SenhaUtils;

@SpringBootApplication
public class Application {

	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha Encoded: " + senhaEncoded);
			
			senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha Encoded new: " + senhaEncoded);
			
			System.out.println("Senha valida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
			
			
			System.out.println("##### Qtd de elementos por pagina =" + this.qtdPorPagina);
		};
	}

}
