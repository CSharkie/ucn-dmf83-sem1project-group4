package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Iterator;

public class OfferContainer {
	
private ArrayList<Offer> offers;
	
	private static OfferContainer instance = null;

	protected OfferContainer() {
	}

	public static OfferContainer getInstance() {
		if (instance == null) {
			instance = new OfferContainer();
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
