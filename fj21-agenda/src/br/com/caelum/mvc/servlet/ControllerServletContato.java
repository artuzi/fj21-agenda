package br.com.caelum.mvc.servlet;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerServletContato  extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	/*
	 * 
	 * Temos um servlet geral, que chama vários "mini-servlets", que nao precisam 
	 * estar mapeados no web.xml. Chama dinamicamente
	 * 
	 */
	
	// a idéia é digiar /fj21-classe/param1/param2
	
	// param1 = classe a executar (concatenou Ninja para diferenciar do padrao
	   //(tiramos a primeira "/", para o nome da classe ser o primeiro parametro)
	// param2 = metodo a executar dentro da classe param1
	
	String uri = request.getRequestURI().substring(1);
	
	System.out.println(uri);

	 //divide o /contato/adicina em itens dentro do array
	 String[] strArray = uri.split("/");
	
	 String classeUrl = InitCap(strArray[1]);
	 String metodoUrl = strArray[2];	 

	 
	System.out.println("classe: " + classeUrl + " metodo: " + metodoUrl);

	//qualquer url passada tera Ninja concatenado, que é o controlador dos webservices
	String nomeDaClasse = "br.com.caelum.mvc.logica." + classeUrl + "Ninja"; //var;
	
	Object[] arqs = new Object[2];
	arqs[0] = request;
	arqs[1] = response;
	
	try {
		Class<?> classe = Class.forName(nomeDaClasse);
		Object obj = classe.newInstance();
		Method[] methods = classe.getMethods();
		//lemos todos os metodos da classe, e executamos a que tem o nome igual a que quero executar
		for (Method m : methods ) {
			if (m.getName().equals(metodoUrl)){
				m.invoke(obj,arqs);
			}
		}
		
/*
		Class classe = Class.forName(nomeDaClasse);
		
		//como criamos uma interface executa na interface Logica
		//sabemos que toda classe que a implementa tem esse metodo
		Logica logica = (Logica) classe.newInstance();
		logica.executa(request, response);
*/
	} catch (Exception e) {
		throw new ServletException("A lógica de " +
				"negócios causou uma exceção", e);
	}
 }

public static void chamada(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	/*
	 * 
	 * Temos um servlet geral, que chama vários "mini-servlets", que nao precisam 
	 * estar mapeados no web.xml. Chama dinamicamente
	 * 
	 */
	
	// a idéia é digiar /fj21-classe/param1/param2
	
	// param1 = classe a executar (concatenou Ninja para diferenciar do padrao
	   //(tiramos a primeira "/", para o nome da classe ser o primeiro parametro)
	// param2 = metodo a executar dentro da classe param1
	
	String uri = request.getRequestURI().substring(1);
	
	System.out.println(uri);

	 //divide o /contato/adicina em itens dentro do array
	 String[] strArray = uri.split("/");
	
	 String classeUrl = InitCap(strArray[1]);
	 String metodoUrl = strArray[2];	 

	 
	System.out.println("classe: " + classeUrl + " metodo: " + metodoUrl);

	//qualquer url passada tera Ninja concatenado, que é o controlador dos webservices
	String nomeDaClasse = "br.com.caelum.mvc.logica." + classeUrl + "Ninja"; //var;
	
	Object[] arqs = new Object[2];
	arqs[0] = request;
	arqs[1] = response;
	
	try {
		Class<?> classe = Class.forName(nomeDaClasse);
		Object obj = classe.newInstance();
		Method[] methods = classe.getMethods();
		//lemos todos os metodos da classe, e executamos a que tem o nome igual a que quero executar
		for (Method m : methods ) {
			if (m.getName().equals(metodoUrl)){
				m.invoke(obj,arqs);
			}
		}
		
/*
		Class classe = Class.forName(nomeDaClasse);
		
		//como criamos uma interface executa na interface Logica
		//sabemos que toda classe que a implementa tem esse metodo
		Logica logica = (Logica) classe.newInstance();
		logica.executa(request, response);
*/
	} catch (Exception e) {
		throw new ServletException("A lógica de " +
				"negócios causou uma exceção", e);
	}
 }

public static String InitCap (String var) {
	String trata = null;
	if (var.length() > 0) {
	   trata = var.substring(0, 1).toUpperCase() + var.substring(1);
	}
	return trata;
	}
}
