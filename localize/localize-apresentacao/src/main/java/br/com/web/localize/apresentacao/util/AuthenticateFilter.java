package br.com.web.localize.apresentacao.util;

import java.io.IOException;

import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.web.localize.arquitetura.comum.UtilObjeto;
import br.com.web.localize.modelo.entidade.Fornecedor;

@WebFilter(dispatcherTypes = { DispatcherType.REQUEST, }, urlPatterns = { "/*" })
public class AuthenticateFilter implements Filter {

	private final String urlLogin = "/AuthenticateFilter";

	private final String pageLogin = "/pages/login/login.jsp";

	private final String pageEntrar= "/pages/login/entrar.html";

	private final String pageRegistrar= "/pages/login/registrar.html";

	private final String pageEsqueciSenha= "/pages/login/esqueci-senha.html";

	private final String servico= "/servico";

	private final String CSS = ".css";

	private final String JS = ".js";

	private final String PNG = ".png";

	public void destroy() {

	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest httpRequest = (HttpServletRequest) request;

		String path = httpRequest.getServletPath();

		Fornecedor fornecedor = (Fornecedor) httpRequest.getSession().getAttribute("usuario");

		if (UtilObjeto.isNotNull(fornecedor) || path.equals(urlLogin) || isStylePaginasLiberadas(path) || isStyle(path) || path.equals(servico)) {

			chain.doFilter(request, response);

		} else {

			abrirLogin(response, httpRequest);

		}

	}

	private boolean isStylePaginasLiberadas(String path) {
		
		return path.contains(pageLogin) || path.contains(pageEntrar) || path.contains(pageRegistrar) || path.contains(pageEsqueciSenha);
	}

	private boolean isStyle(String path) {

		return path.endsWith(CSS) || path.endsWith(JS) || path.endsWith(PNG);
	}

	private void abrirLogin(ServletResponse response,  HttpServletRequest httpRequest) throws ServletException, IOException {

		//RequestDispatcher rd = httpRequest.getRequestDispatcher("/#");

		//rd.forward(httpRequest, response);
		
		HttpServletResponse resp = (HttpServletResponse) response;
		
		resp.sendRedirect("/localize/#/");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}
