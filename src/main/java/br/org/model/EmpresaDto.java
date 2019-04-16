package br.org.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@NoArgsConstructor
@EqualsAndHashCode(exclude = {"razaoSocial","cnpj"})
@Getter
@Setter
@ToString()

public class EmpresaDto {	

	private String razaoSocial;
	private String cnpj;
	public EmpresaDto(String razaoSocial, String cnpj) {
		this.razaoSocial = razaoSocial;
		this.cnpj = cnpj;
	}
	
	
}
