package br.org.api.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import br.org.model.Empresa;

public interface EmpresaRepository extends CrudRepository<Empresa, String> {

	List<Empresa> findAll();

	Empresa findByCnpj(String cnpj);

}
