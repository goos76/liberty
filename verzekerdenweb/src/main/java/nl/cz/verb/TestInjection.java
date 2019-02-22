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
public class TestInjection extends HttpServlet {

	@EJB(name = "VerbBean", beanInterface = IVerbRemote.class)
	private IVerb verb;

	@Inject
	@IVerbWeb
	private IVerb webVerbPojo;

	@Inject
	@Named("verbPojo")
	private IVerb verbPojo;

	@Inject
	private Factory factory;

	public TestInjection() {
		super();

	}

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		IVerb verb = getService(request, response);
		String x = request.getParameter("x");

		Integer terug = verb.tweeKeer(Integer.parseInt(x));
		response.getWriter().append("2 x " + x + " = " + terug + "!!! at " + LocalDate.now());
	}

	private IVerb getService(HttpServletRequest request, HttpServletResponse response) throws IOException {
		if (isParameter(request, "ejb")) {
			response.getWriter().append("use ejb ");
			return verb;
		}
		if (isParameter(request, "pojo")) {
			response.getWriter().append("use pojo ");
			return verbPojo;
		}
		if (isParameter(request, "webpojo")) {
			response.getWriter().append("use pojo ");
			return webVerbPojo;
		}
		if (isParameter(request, "factory")) {
			response.getWriter().append("use factory ");
			return factory.instance();
		}
		return null;
	}

	private boolean isParameter(HttpServletRequest request, String paramater) {
		return Boolean.parseBoolean(request.getParameter(paramater));
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
