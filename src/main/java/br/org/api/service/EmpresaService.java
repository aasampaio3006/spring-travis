package br.org.api.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.org.api.repository.EmpresaRepository;
import br.org.model.Empresa;

@Service
public class EmpresaService implements Serializable{


	private static final long serialVersionUID = -3447829471750324854L;
	
	@Autowired
	private EmpresaRepository repository;

	public List<Empresa> findAllEmpresa() {		
		return repository.findAll();
	}

	public Empresa findEmpresaByCnpj(String cnpj) {
		return repository.findByCnpj(cnpj);
	}

	public void save(Empresa empresa) {
		repository.save(empresa);
		
	}

}
