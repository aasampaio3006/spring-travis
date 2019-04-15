package br.org.api;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.org.api.repository.EmpresaRepository;
import br.org.model.Empresa;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApiApplicationTests {
	
	@Autowired
	EmpresaRepository repository;

	@Test
	public void buscaEmpresa() {		
		String cnpj = "18126249000103";
		
		// when
	    Empresa found = repository.findByCnpj(cnpj);
		assertTrue(found.getCnpj().equals(cnpj));
			
	}
	
}
