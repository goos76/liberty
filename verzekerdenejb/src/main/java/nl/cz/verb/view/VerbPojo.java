package nl.cz.verb.view;

import java.io.Serializable;

import javax.inject.Named;

@Named("verbPojo")
public class VerbPojo implements IVerb, Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3502432843619059025L;

	@Override
	public Integer tweeKeer(Integer x) {
		System.out.println("VerbPojo");
		return x == null ? null : x * 2;
	}
	
}
