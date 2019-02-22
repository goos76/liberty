package nl.cz.verb.view;

import java.io.Serializable;

import javax.inject.Named;

@Named("verbPojo")
public class VerbPojo implements IVerb, Serializable {

	@Override
	public Integer tweeKeer(Integer x) {
		int result = 3 * x;
		System.out.println("3 x " + x + " = " + result);
		return result;
	}

}
