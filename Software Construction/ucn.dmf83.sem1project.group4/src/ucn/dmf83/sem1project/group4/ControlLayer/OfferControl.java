package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;


public class OfferControl {
	private ArrayList<Offer> offers;
	
	private static OfferControl instance = null;

	protected OfferControl() {
	}

	public static OfferControl getInstance() {
		if (instance == null) {
			instance = new OfferControl();
		}
		return instance;
	}
}
