package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class FilterController implements Filter {

	@Override
	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		// TODO Auto-generated method stub

		//HttpServletRequestWrapper  
		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) res;

		/*
		 * 
		 * Temos um servlet geral, que chama v√°rios "mini-servlets", que nao
		 * precisam estar mapeados no web.xml. Chama dinamicamente
		 */

		// a id√©ia √© digiar /fj21-classe/param1/param2

		// param1 = classe a executar (concatenou Ninja para diferenciar do
		// padrao
		// (tiramos a primeira "/", para o nome da classe ser o primeiro
		// parametro)
		// param2 = metodo a executar dentro da classe param1

		String uri = request.getRequestURI().substring(1);
		
		/*
		try {
			if (uri.indexOf("?")!=0) {
				uri = uri.substring(0,uri.indexOf("?"));
			} 
		} catch (Exception e) {
			uri = uri;
		};
		*/
		
		System.out.println(uri);

		// divide o /contato/adicina em itens dentro do array
		String[] strArray = uri.split("/");
		List<String> params = Arrays.asList(strArray);

		System.out.println("Qtade parametros informados: " + params.size());
		
		//linhas com parametros ignora
		if(!params.contains("resources")){
			
			if (params.size()>2) {

				String classeUrl = InitCap(strArray[1]);
				String metodoUrl = strArray[2];

				String paramOpcional = null;
	
				/*
				 * Qualquer parametro alem da classe e do metodo a executar sera definidocomo parametro  no request
				 * lembrando que fj21-agenda È o primeiro parametro
				 *               <classe> È o segundo
				 *               <metodo> È o terceiro
				 *  Qualquer coisa alem disso È um parametro opcional
				 *  
				 *  Isso nao funciona, precisaria ser Usar httpservletWrapped para modificaro request e adicionar os parametros
				 */      
				
				if (params.size()>3){
					for (int i=4;i<params.size()+1;i++){
						String nomParamOpc = "param" + (i-3);
						int numParamOpc = i-1;
						
						request.setAttribute(nomParamOpc, strArray[numParamOpc]);
						System.out.println("Parametro opcional: " + nomParamOpc + " Conteudo " + strArray[numParamOpc]);
						
					}
				}
				

				System.out.println("classe: " + classeUrl + " metodo: " + metodoUrl);
				
				// qualquer url passada tera Ninja concatenado, que √© o controlador dos
				// webservices
				String nomeDaClasse = "br.com.caelum.mvc.logica." + classeUrl + "Ninja"; // var;
				
				Object[] arqs = new Object[2];
				arqs[0] = request;
				arqs[1] = response;
				
				try {
					Class<?> classe = Class.forName(nomeDaClasse);
					Object obj = classe.newInstance();
					Method[] methods = classe.getMethods();
					// lemos todos os metodos da classe, e executamos a que tem o nome
					// igual a que quero executar
					for (Method m : methods) {
						if (m.getName().equals(metodoUrl)) {
							m.invoke(obj, arqs);
						}
					}
					
				} catch (Exception e) {
					throw new ServletException("A l√≥gica de "
							+ "neg√≥cios causou uma exce√ß√£o", e);
				}
			} else {
				System.out.println("Necess·rio informar a classe e o metodo a executr");
			}
		}else{
			chain.doFilter(req, res);
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub

	}

	public static String InitCap(String var) {
		String trata = null;
		if (var.length() > 0) {
			trata = var.substring(0, 1).toUpperCase() + var.substring(1);
		}
		return trata;
	}
}