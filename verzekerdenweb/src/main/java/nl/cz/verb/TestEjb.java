package nl.cz.verb;

import java.io.IOException;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.IVerbRemote;

@WebServlet("/2x")
public class TestEjb extends HttpServlet {

	@EJB(name = "VerbBean", beanInterface = IVerbRemote.class)
	IVerb verb;
	
	@Inject
	@IVerbWeb
	private IVerb webVerbPojo;
	
	@Inject
	@Named("verbPojo")
	private IVerb ejbwebVerbPojo;
	
	@Inject
	private Factory factory;
	
 
	public TestEjb() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String x = request.getParameter("x");
		if (Boolean.parseBoolean(request.getParameter("y"))) {

			IVerb unmanagedVerb = factory.instance();
			Integer terug = unmanagedVerb.tweeKeer(Integer.parseInt(x));
			response.getWriter().append("unmanaged 2 x " + x + " = " + terug + "!!! at " + LocalDate.now());
			return;

		}

		Integer terug = verb.tweeKeer(Integer.parseInt(x));
		response.getWriter().append("2 x " + x + " = " + terug + "!!! at " + LocalDate.now());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
