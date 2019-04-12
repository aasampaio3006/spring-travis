package br.org.api.repository;

import org.springframework.data.repository.CrudRepository;

import br.org.model.Funcionario;

public interface FuncionarioRepository extends CrudRepository<Funcionario, String>{

}
