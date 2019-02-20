package nl.cz.verb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.IVerbLocal;
import nl.cz.verb.view.IVerbRemote;

/**
 * Session Bean implementation class VerbBean
 */
@Stateless(name="VerbBean")
@Local(IVerbLocal.class)
@Remote(IVerbRemote.class)
@LocalBean
public class VerbBean implements IVerb {

	/**
	 * Default constructor.
	 */
	public VerbBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String doeIets(String param) {
		System.out.println("doeiets " + param);
		return "dus" + param;
	}

}
