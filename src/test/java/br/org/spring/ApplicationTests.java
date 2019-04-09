package br.org.spring;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.spring.util.SenhaUtils;

//Junit 4
@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
public class ApplicationTests {
	
	@Value("${paginacao.qtd_por_pagina}")
	private int qtdPorPagina;


	
	@DisplayName("Testando Context Loads")
	@Test
	public void testContextLoads() {
	   assertEquals(100, qtdPorPagina);
	}
	

	@DisplayName("Validando Senha")
	@Test
	public void validaSenha(){
		String senhaEncoded = SenhaUtils.geraBCrypt("123456");
		System.out.println("Senha Encoded: " + senhaEncoded);
		assertTrue(SenhaUtils.senhaValida("123456", senhaEncoded));
	}
	

}
