package nl.cz.verb;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.IVerbRemote;

@WebServlet("/Test")
public class Test extends HttpServlet {

	@EJB(name = "VerbBean", beanInterface = IVerbRemote.class)
	IVerb verb;

	public Test() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String terug = verb.doeIets("test");
		response.getWriter().append("Served " + terug + " at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
