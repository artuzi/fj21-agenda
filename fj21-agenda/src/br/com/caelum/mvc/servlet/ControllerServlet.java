package br.com.caelum.mvc.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.mvc.logica.Logica;

public class ControllerServlet  extends HttpServlet {
@Override
protected void service(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {

	String parametro = request.getParameter("logica");
	String nomeDaClasse = "br.com.caelum.mvc.logica." + parametro;
	
	try {
		Class classe = Class.forName(nomeDaClasse);
		
		//como criamos uma interface executa na interface Logica
		//sabemos que toda classe que a implementa tem esse metodo
		Logica logica = (Logica) classe.newInstance();
		logica.executa(request, response);
	} catch (Exception e) {
		throw new ServletException("A lógica de " +
				"negócios causou uma exceção", e);
	}
}
}
