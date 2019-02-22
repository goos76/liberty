package nl.cz.verb;

import javax.ejb.Local;
import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.IVerbLocal;
import nl.cz.verb.view.IVerbRemote;
import nl.cz.verb.view.VerbPojo;

@Stateless(name = "VerbBean")
@Local(IVerbLocal.class)
@Remote(IVerbRemote.class)
@LocalBean
public class VerbBean implements IVerb {

	public VerbBean() {

	}

	@Override
	public Integer tweeKeer(Integer x) {
		return new VerbPojo().tweeKeer(x);
	}

}
