package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public void addOffer(Offer offer)
	{
		offers.add(offer);
	}
	
	public void removeOffer(Offer offer)
	{
		offers.remove(offer);
	}
	
	public Offer getOffer(int ID)
	{
		for(Iterator<Offer> i = offers.iterator(); i.hasNext();)
		{
			Offer ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
