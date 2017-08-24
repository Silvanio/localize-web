package br.com.web.localize.modelo.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * <p>
 * <b>Title:</b> TipoServicoFormDTO.java
 * </p>
 * 
 * <p>
 * <b>Description:</b>
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software - Localize TI.
 * </p>
 * 
 * @author Silânio Júnior
 * 
 * @version 1.0.0
 */
@XmlRootElement
public class DadosServicoDTO implements Serializable {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7813449837318487186L;

	private TipoServicoDTO tipoServico;

	private List<SeguimentoDTO> seguimentosSelecionados;

	private Long idFornecedor;

	/**
	 * Retorna o valor do atributo <code>idFornecedor</code>
	 *
	 * @return <code>Long</code>
	 */
	public Long getIdFornecedor() {

		return idFornecedor;
	}

	/**
	 * Define o valor do atributo <code>idFornecedor</code>.
	 *
	 * @param idFornecedor
	 */
	public void setIdFornecedor(Long idFornecedor) {

		this.idFornecedor = idFornecedor;
	}

	/**
	 * Retorna o valor do atributo <code>tipoServico</code>
	 *
	 * @return <code>TipoServicoDTO</code>
	 */
	public TipoServicoDTO getTipoServico() {

		return tipoServico;
	}

	/**
	 * Define o valor do atributo <code>tipoServico</code>.
	 *
	 * @param tipoServico
	 */
	public void setTipoServico(TipoServicoDTO tipoServico) {

		this.tipoServico = tipoServico;
	}

	/**
	 * Retorna o valor do atributo <code>seguimentosSelecionados</code>
	 *
	 * @return <code>List<SeguimentoDTO></code>
	 */
	public List<SeguimentoDTO> getSeguimentosSelecionados() {

		return seguimentosSelecionados;
	}

	/**
	 * Define o valor do atributo <code>seguimentosSelecionados</code>.
	 *
	 * @param seguimentosSelecionados
	 */
	public void setSeguimentosSelecionados(List<SeguimentoDTO> seguimentosSelecionados) {

		this.seguimentosSelecionados = seguimentosSelecionados;
	}

}
