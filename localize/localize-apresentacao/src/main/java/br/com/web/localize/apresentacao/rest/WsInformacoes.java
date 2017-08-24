package br.com.web.localize.apresentacao.rest;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.localize.exceptions.NegocioException;
import br.com.web.localize.apresentacao.util.Mensagem;
import br.com.web.localize.apresentacao.util.MensagemEnum;
import br.com.web.localize.arquitetura.comum.UtilString;
import br.com.web.localize.modelo.dto.InformacoesDTO;
import br.com.web.localize.modelo.entidade.Fornecedor;
import br.com.web.localize.modelo.entidade.Informacoes;
import br.com.web.localize.service.impl.InformacaoService;
import br.com.web.localize.service.impl.FornecedorService;
import br.com.web.localize.service.util.UtilArquivo;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;

/**
 * <p>
 * <b>Title:</b> WsMobile.java
 * </p>
 * 
 * <p>
 * <b>Description:</b> Serviço para Informações.
 * </p>
 * 
 * <p>
 * <b>Company: </b> Fábrica de Software
 * </p>
 * 
 * @author Silvânio Júnior
 * 
 * @version 1.0.0
 */
@Path("/wsinformacoes")
@Component
public class WsInformacoes extends WsLocalize {

	/** Atributo serialVersionUID. */
	private static final long serialVersionUID = 7349909819395728563L;

	@Autowired
	/** Atributo service. */
	private InformacaoService service;

	@Autowired
	/** Atributo service. */
	private FornecedorService fornecedorService;

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/salvar")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public Mensagem salvar(final InformacoesDTO informacoes, @Context final HttpServletRequest request) {

		try {

			final Informacoes entidade = this.converterEmInformacoes(informacoes);

			entidade.setFornecedor(this.getFornecedorLogado(request));

			this.salvarArquivo(request, entidade);

			this.service.alterar(entidade);

			return new Mensagem(MensagemEnum.SUCESS, MensagemEnum.SUCESS.getDescricao());

		} catch (final NegocioException e) {

			return new Mensagem(MensagemEnum.INFO, e.getMessage());

		}

	}

	/**
	 * Método responsável por salvar o arquivo.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param request
	 * 
	 * @param entidade
	 */
	private void salvarArquivo(final HttpServletRequest request, final Informacoes entidade) {

		final String nomeImagem = this.getNomeImagem(request);

		if (!UtilString.isEmpty(nomeImagem)) {

			final ResourceBundle bundle = ResourceBundle.getBundle("config");

			final String caminhoImagem = MessageFormat.format(bundle.getString("dir.imagem"), entidade.getCnpj(), nomeImagem);

			try {

				this.criarArquivo(this.getArquivoSession(request), caminhoImagem);

				entidade.setCaminhoImagem(caminhoImagem);

				entidade.setNomeImagem(nomeImagem);

			} catch (final IOException e) {

				e.printStackTrace();

			}

		}
	}

	@POST
	@Path("/upload")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public void upload(@Context final HttpServletRequest request, @FormDataParam("file") final InputStream uploadedInputStream, @FormDataParam("file") final FormDataContentDisposition fileDetail) {

		final HttpSession session = request.getSession();

		session.setAttribute("fileName", fileDetail.getFileName());

		session.setAttribute("arquivo", UtilArquivo.getBytesFromInputStream(uploadedInputStream));

	}

	/**
	 * Método responsável por registrar o fornecedor.
	 *
	 * @author Silvânio Júnior
	 *
	 * @return <code>String</code> Mensagem.
	 */
	@POST
	@Path("/abririnformacoes")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public InformacoesDTO abrirInformacoes(@Context final HttpServletRequest request) {

		final Fornecedor logado = this.fornecedorService.obter(this.getFornecedorLogado(request).getId());

		return this.converterEmInformacoesDTO(logado.getInformacoes());

	}

	/**
	 * Método responsável por converter Informacoes em InformacoesDTO.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param informacoes
	 * 
	 * @return <code>InformacoesDTO</code>
	 */
	private InformacoesDTO converterEmInformacoesDTO(final Informacoes informacoes) {

		final InformacoesDTO dto = new InformacoesDTO();

		dto.setCaminhoImagem(informacoes.getCaminhoImagem());

		dto.setNomeImagem(informacoes.getNomeImagem());

		dto.setCelular(informacoes.getCelular());

		dto.setCnpj(informacoes.getCnpj());

		dto.setDescricao(informacoes.getDescricao());

		dto.setEmail(informacoes.getEmail());

		dto.setNomeFantasia(informacoes.getNomeFantasia());

		dto.setRazaoSocial(informacoes.getRazaoSocial());

		dto.setSenha(informacoes.getSenha());

		dto.setTelefone(informacoes.getTelefone());

		dto.setId(informacoes.getId());

		if (!UtilString.isEmpty(informacoes.getCaminhoImagem())) {

			final File file = new File(informacoes.getCaminhoImagem());

			if (file.exists()) {

				dto.setImagem(UtilArquivo.converterFileEmByteArray(file));

			}

		}

		return dto;
	}

	/**
	 * Método responsável por converter em infomacoes.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param informacoes
	 * 
	 * @return <code>Informacoes</code>
	 */
	private Informacoes converterEmInformacoes(final InformacoesDTO informacoes) {

		final Informacoes entidade = new Informacoes();

		entidade.setId(informacoes.getId());

		entidade.setCaminhoImagem(informacoes.getCaminhoImagem());

		entidade.setCelular(informacoes.getCelular());

		entidade.setCnpj(informacoes.getCnpj());

		entidade.setDescricao(informacoes.getDescricao());

		entidade.setEmail(informacoes.getEmail());

		entidade.setNomeFantasia(informacoes.getNomeFantasia());

		entidade.setRazaoSocial(informacoes.getRazaoSocial());

		entidade.setSenha(informacoes.getSenha());

		entidade.setTelefone(informacoes.getTelefone());

		return entidade;

	}

	/**
	 * Método responsável por obter o nome da imagem na sessao.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param request
	 * 
	 * @return String
	 */
	public String getNomeImagem(final HttpServletRequest request) {

		if (request.getSession().getAttribute("fileName") != null) {

			return (String) request.getSession().getAttribute("fileName");

		}

		return null;

	}

	/**
	 * Método responsável por obter o arquivo na sessao.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param request
	 * 
	 * @return byte[]
	 */
	public byte[] getArquivoSession(final HttpServletRequest request) {

		if (request.getSession().getAttribute("arquivo") != null) {

			final byte[] is = (byte[]) request.getSession().getAttribute("arquivo");

			return is;

		}

		return null;

	}

	/**
	 * Método responsável por criar o arquivo na pasta.
	 *
	 * @author Silvânio Júnior
	 *
	 * @param imagem
	 * 
	 * @param path
	 * 
	 * @throws IOException
	 * 
	 * @throws FileNotFoundException
	 */
	private void criarArquivo(final byte[] imagem, final String path) throws IOException, FileNotFoundException {

		final File file = new File(path);

		if (file.getParentFile().exists()) {

			if (file.getParentFile().listFiles() != null && file.getParentFile().listFiles().length > 0) {

				for (final File fileRemover : file.getParentFile().listFiles()) {

					fileRemover.delete();
				}

			}

		} else {

			file.getParentFile().mkdirs();

		}

		file.createNewFile();

		final FileOutputStream fs = new FileOutputStream(file);

		final BufferedOutputStream bs = new BufferedOutputStream(fs);

		bs.write(imagem);

		bs.close();

		fs.close();
	}

}
