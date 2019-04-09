package br.org.spring.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Empresa")
public class Empresa implements Serializable {

	private static final long serialVersionUID = 6547027740716363006L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "razaoSocial")
	private String razaoSocial;
	private String cnpj;
	private LocalDate dataCriacao;
	private LocalDate dataAtualizao;
	private List<Funcionario> funcionarios = new ArrayList<Funcionario>();

	public Empresa() {
	}

	public Long getId() {
		return id;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public LocalDate getDataCriacao() {
		return dataCriacao;
	}

	public LocalDate getDataAtualizao() {
		return dataAtualizao;
	}

	public List<Funcionario> getFuncionarios() {
		return funcionarios;
	}

	

	@Override
	public String toString() {
		return "Empresa [id=" + id + ", razaoSocial=" + razaoSocial + ", cnpj=" + cnpj + ", dataCriacao=" + dataCriacao
				+ ", dataAtualizao=" + dataAtualizao + ", funcionarios=" + funcionarios + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Empresa other = (Empresa) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
