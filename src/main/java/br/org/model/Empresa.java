package br.org.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.br.CNPJ;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;


@NoArgsConstructor
@EqualsAndHashCode(exclude = {"razaoSocial","cnpj","dataCriacao"})
@Getter
@ToString(exclude="id")



@Document(collection = "empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 6547027740716363006L;

	@Id
	private String id;	
	//@NotEmpty(message = "Razão social não pode ser vazia.")
	//@Length(min = 5, max = 200, message = "Razão social deve conter entre 5 e 200 caracteres.")
	private String razaoSocial;
	@NotEmpty(message = "CNPJ não pode ser vazio.")
	@CNPJ(message = "CNPJ inválido.")
	private String cnpj;	
	private LocalDate dataCriacao;
	private LocalDate dataAtualizcao;
	
	public Empresa(String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
		this.dataCriacao = LocalDate.now().minusDays(10);
		this.dataAtualizcao = LocalDate.now().minusMonths(1);
	}
	

	
	
	
	
	
	

}
