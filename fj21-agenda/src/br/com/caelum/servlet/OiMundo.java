package br.com.caelum.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class OiMundo  extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1919529822176254338L;

	/**
	 * 
	 */

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		//super.service(request, response);
		
		PrintWriter out = response.getWriter();
		
		
		out.println("<html>");
		out.println("<body>");
		out.println("Oi mundo!");
		out.println("</body>");
		out.println("</html>");

	}

}
