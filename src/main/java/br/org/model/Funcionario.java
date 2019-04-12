package br.org.model;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter 
@NoArgsConstructor
@EqualsAndHashCode(exclude = {"nome","email","senha","empresa"})
@ToString(exclude= "id")

@Document(collection = "funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = -6394433826780614354L;
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)
	private String id;	
	@NotEmpty(message = "Nome não pode ser vazia.")
	@Length(min = 2, max = 30, message = "Nome deve conter entre 2 e 30 caracteres.")
	private String nome;
	private String email;
	private String senha;	
	@NotEmpty(message = "CPF não pode ser vazio.")
	@CPF(message = "CPF inválido.")
	private String cpf;
	private Empresa empresa;
	
	

}
