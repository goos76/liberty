package nl.cz.verb;

import javax.inject.Named;

import nl.cz.verb.view.IVerb;
import nl.cz.verb.view.VerbPojo;

@Named
@IVerbWeb
public class WebVerb implements IVerb {

	@Override
	public Integer tweeKeer(Integer x) {
		return new VerbPojo().tweeKeer(x);
	}

}
