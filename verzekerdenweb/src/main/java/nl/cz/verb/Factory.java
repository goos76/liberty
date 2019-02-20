package nl.cz.verb;

import javax.annotation.ManagedBean;
import javax.inject.Inject;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import nl.cz.verb.view.IVerb;

@ManagedBean
public class Factory {
	@Inject
	IVerb verb;

	public static IVerb instance() {
		return new Factory().verb;
	}

	public static IVerb lookup() {
		try {
			return (IVerb) new InitialContext()
					.lookup("java:global/verzekerdenear-1.0/verzekerdenejb-1.0/VerbBean!nl.cz.verb.view.IVerbLocal");
		} catch (NamingException e) {
			e.printStackTrace();
			return null;
		}
	}
}
