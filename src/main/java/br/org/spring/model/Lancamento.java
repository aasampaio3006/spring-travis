package br.org.spring.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.org.spring.enums.TipoEnum;

@Entity
@Table(name = "lancamento")
public class Lancamento implements Serializable {

	private static final long serialVersionUID = 3809187274572075756L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data", nullable = false)
	private Date data;

	@Column(name = "descricao", nullable = true)
	private String descricao;

	@Column(name = "localizacao", nullable = true)
	private String localizacao;

	@Column(name = "data_criacao", nullable = false)
	private Date dataCriacao;

	@Column(name = "data_atualizacao", nullable = false)
	private Date dataAtualizacao;

	@Enumerated(EnumType.STRING)
	@Column(name = "tipo", nullable = false)
	private TipoEnum tipo;

	//@Column(name = "funcionario", nullable = false)
	@ManyToOne(fetch = FetchType.EAGER)	
	private Funcionario funcionario;
	
	
	
	public Lancamento() {
	}

	public Date getData() {
		return data;
	}

	public String getDescricao() {
		return descricao;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public Date getDataCriacao() {
		return dataCriacao;
	}

	public Date getDataAtualizacao() {
		return dataAtualizacao;
	}

	public TipoEnum getTipo() {
		return tipo;
	}

	public Funcionario getFuncionario() {
		return funcionario;
	}

	@PreUpdate
	public void preUpdate() {
		dataAtualizacao = new Date();
	}

	@PrePersist
	public void prePersist() {
		final Date atual = new Date();
		dataCriacao = atual;
		dataAtualizacao = atual;
	}

	@Override
	public String toString() {
		return "Lancamento [id=" + id + ", data=" + data + ", descricao=" + descricao + ", localizacao=" + localizacao
				+ ", dataCriacao=" + dataCriacao + ", dataAtualizacao=" + dataAtualizacao + ", tipo=" + tipo
				+ ", funcionario=" + funcionario + "]";
	}

	

}
