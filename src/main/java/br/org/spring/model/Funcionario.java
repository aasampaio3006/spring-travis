package br.org.spring.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;

import br.org.spring.enums.PerfilEnum;

@Entity
@Table(name = "funcionario")
public class Funcionario implements Serializable{

	private static final long serialVersionUID = -6394433826780614354L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "nome", nullable = false)
	private String nome;
	
	@Column(name = "email", nullable = false)
	private String email;
	
	@Column(name = "senha", nullable = false)
	private String senha;
	
	@Column(name = "cpf", nullable = false)
	private String cpf;
	
	@Column(name = "valor_hora", nullable = true)
	private BigDecimal valorHora
	;
	@Column(name = "qtd_horas_trabalhado_dia", nullable = true)
	private Float qtdHorasTrabalhadoDia;
	
	@Column(name = "qtd_horas_almoco", nullable = true)
	private Float qtdHorasAlmoco;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "perfil", nullable = false)
	private PerfilEnum perfil;
	
	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;
	
	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;
	
	//@Column(name = "lancamento", nullable = false)
	//@OneToMany(mappedBy = "mLancamento", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Lancamento> lancamentos;
	
	//@Column(name = "empresa", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)
	private Empresa empresa;
	

	public Funcionario() {
	
	}
	
	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}
	
	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao =  atual;
	}
	
	public Empresa getEmpresa() {
		return empresa;
	}
	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	public Long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public String getEmail() {
		return email;
	}
	public String getSenha() {
		return senha;
	}
	public String getCpf() {
		return cpf;
	}
	public BigDecimal getValorHora() {
		return valorHora;
	}
	public Float getQtdHorasTrabalhadoDia() {
		return qtdHorasTrabalhadoDia;
	}
	public Float getQtdHorasAlmoco() {
		return qtdHorasAlmoco;
	}
	public PerfilEnum getPerfil() {
		return perfil;
	}
	public Date getDataCriacao() {
		return dataCriacao;
	}
	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}
	public List<Lancamento> getLancamentos() {
		return lancamentos;
	}

	
		
	@Override
	public String toString() {
		return "Funcionario [id=" + id + ", nome=" + nome + ", email=" + email + ", senha=" + senha + ", cpf=" + cpf
				+ ", valorHora=" + valorHora + ", qtdHorasTrabalhadoDia=" + qtdHorasTrabalhadoDia + ", qtdHorasAlmoco="
				+ qtdHorasAlmoco + ", perfil=" + perfil + ", dataCriacao=" + dataCriacao + ", dataAtualizacao="
				+ dataAtualizacao + ", empresa=" + empresa + "]";
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
		Funcionario other = (Funcionario) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	
	

}
