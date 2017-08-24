package br.com.web.localize.modelo.entidade;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name = "tb_dados_servico")
@XmlRootElement
public class DadosServico extends EntidadeLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** Atributo id. */
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	/** Atributo servicos. */
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, targetEntity = Seguimento.class)
	@JoinTable(name = "tb_dados_servico_seguimento", joinColumns = @JoinColumn(name = "id_dados_servico"), inverseJoinColumns = @JoinColumn(name = "id_seguimento"))
	private List<Seguimento> seguimentos;

	/** Atributo fornecedor. */
	@OneToOne
	@JoinColumn(name = "id_fornecedor")
	private Fornecedor fornecedor;

	/**
	 * Retorna o valor do atributo <code>id</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getId() {

		return id;
	}

	/**
	 * Define o valor do atributo <code>id</code>.
	 *
	 * @param id
	 */
	public void setId(Long id) {

		this.id = id;
	}

	/**
	 * Retorna o valor do atributo <code>seguimentos</code>
	 *
	 * @return <code>List<Seguimento></code>
	 */
	public List<Seguimento> getSeguimentos() {

		return seguimentos;
	}

	/**
	 * Define o valor do atributo <code>seguimentos</code>.
	 *
	 * @param seguimentos
	 */
	public void setSeguimentos(List<Seguimento> seguimentos) {

		this.seguimentos = seguimentos;
	}

	/**
	 * Retorna o valor do atributo <code>fornecedor</code>
	 *
	 * @return <code>Fornecedor</code>
	 */
	public Fornecedor getFornecedor() {

		return fornecedor;
	}

	/**
	 * Define o valor do atributo <code>fornecedor</code>.
	 *
	 * @param fornecedor
	 */
	public void setFornecedor(Fornecedor fornecedor) {

		this.fornecedor = fornecedor;
	}

}
