package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.Date;
import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class OfferControl {
	private OfferContainer container;
	private static OfferControl instance;
	
	private Offer offer;
	
	public OfferControl()
	{
		container = OfferContainer.getInstance();
	}
	
	public static OfferControl getInstance()
	{
		if (instance == null) {
			instance = new OfferControl();
		}
		return instance;
	}
	
	public Offer addOffer(int iD, Contractor contractor, Date startDate, Date endDate)
	{
		offer = new Offer(iD, contractor, startDate, endDate);
		container.addOffer(offer);
		return offer;
	}
	
	public Offer getOffer(int iD)
	{
		return container.getOffer(iD);
	}
	
	public void removeOffer(Offer offer)
	{
		container.removeOffer(offer);
	}
	
	public ArrayList<Offer> getOffer(Date startDate, Date endDate)
	{
		return container.getOffers(startDate, endDate);
	}
	
	public void readFile()
	{
		
	}
	
	public void saveFile()
	{
		
	}
	
}
