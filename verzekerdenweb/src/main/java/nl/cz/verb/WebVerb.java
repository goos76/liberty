package nl.cz.verb;

import javax.inject.Named;

import nl.cz.verb.view.IVerb;

@Named
@IVerbWeb
public class WebVerb implements IVerb {

	@Override
	public Integer tweeKeer(Integer x) {
		System.out.println("WebVerb");
		return x == null ? null : x * 2;
	}

}
