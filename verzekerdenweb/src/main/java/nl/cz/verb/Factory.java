package nl.cz.verb;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.IVerbRemote;

@Named
@ApplicationScoped
public class Factory {

	@EJB(name = "VerbBean", beanInterface = IVerbRemote.class)
	private IVerb verb;

	public IVerb instance() {
		return verb;
	}

	public IVerb lookup() {
		try {
			return (IVerb) new InitialContext().lookup("java:global/verzekerdenear-1.0/verzekerdenejb-1.0/VerbBean!nl.cz.verb.view.IVerbLocal");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
