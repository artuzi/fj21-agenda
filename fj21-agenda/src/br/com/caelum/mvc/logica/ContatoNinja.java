package br.com.caelum.mvc.logica;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.caelum.agenda.dao.ContatoDao;
import br.com.caelum.agenda.modelo.Contato;

public class ContatoNinja extends HttpServlet{
/*
 * Controlador. Ao inves de criar um servlet para cada servico, temos um controlador que executa vários
 * 
 * 
 * 
 */
		
	public void adiciona (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
		System.out.println("Executando a logica adiciona ninja " +
	     "e redirecionando...");
	
		RequestDispatcher rd = req.getRequestDispatcher("/adiciona-contato-power.jsp");
		rd.forward(req, res);

	}

	public void exclui (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		System.out.println("Executando a logica exclui ninja " +
			     "e redirecionando...");
		ContatoDao dao = new ContatoDao();
		dao.exclui( Long.valueOf(req.getParameter("id")) );
		
		RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(req, res);
	
	}

	public void lista (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	
	System.out.println("Executando a logica contatos ninja " +
     "e redirecionando...");

	RequestDispatcher rd = req.getRequestDispatcher("/lista-contatos-elegante.jsp");
	rd.forward(req, res);

	}

	public void grava(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(arg0, arg1);
		PrintWriter out = response.getWriter();
		
		String nome = request.getParameter("nome");
		String endereco = request.getParameter("endereco");
		String email = request.getParameter("email");
		String dataEmTexto = request.getParameter("dataNascimento");
		
		Calendar dataNascimento = null;
		
		try {
			Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
			dataNascimento = Calendar.getInstance();
			dataNascimento.setTime(date);
		} catch (ParseException e) {
			out.println("Erro de conversão da data");
			return;				
		} catch	(Exception e) {
			out.println("Erro generico na data");
			return;				
		}

		Contato contato = new Contato();
		contato.setNome(nome);
		contato.setEndereco(endereco);
		contato.setEmail(email);
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.adiciona(contato);
		
		RequestDispatcher rd =  request.getRequestDispatcher("/contato-adicionado.jsp");
		rd.forward(request, response);
		
	}

	public void home (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		System.out.println("Executando a logica adiciona ninja " +
	     "e redirecionando...");
	
		RequestDispatcher rd = req.getRequestDispatcher("/primeira-logica.jsp");
		rd.forward(req, res);

	}	

	public void altera (HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException, SQLException {
		
		System.out.println("Executando a logica contatos ninja " +
	     "e redirecionando...");
	
		ContatoDao dao = new ContatoDao();
		Long id =  Long.parseLong(req.getParameter("id"));
		Contato contato = dao.carrega(id);
		
		req.setAttribute("contatos", contato);
		
		RequestDispatcher rd = req.getRequestDispatcher("/altera-contato.jsp");
		rd.forward(req, res);
		
	}

	
	public void alteraContatoLogic(HttpServletRequest request, HttpServletResponse response)
			throws Exception {
		// TODO Auto-generated method stub
		
		
		Contato contato = new Contato();
		long id = Long.parseLong(request.getParameter("id"));
		contato.setId(id);
		contato.setNome(request.getParameter("nome"));
		contato.setEndereco(request.getParameter("endereco"));
		contato.setEmail(request.getParameter("email"));
		
		String dataEmTexto = request.getParameter("dataNascimento");
		Date date = new SimpleDateFormat("dd/MM/yyyy").parse(dataEmTexto);
		Calendar dataNascimento = Calendar.getInstance();
		dataNascimento.setTime(date);
		
		contato.setDataNascimento(dataNascimento);
		
		ContatoDao dao = new ContatoDao();
		dao.atualiza(contato);
		
		RequestDispatcher rd = request.getRequestDispatcher("/lista-contatos-elegante.jsp");
		rd.forward(request, response);
		System.out.println("Alterando contato ..." +
				contato.getNome());
	}
	
}
	


