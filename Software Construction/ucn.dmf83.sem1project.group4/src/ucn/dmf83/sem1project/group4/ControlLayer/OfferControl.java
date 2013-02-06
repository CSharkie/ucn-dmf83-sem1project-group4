package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;
import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class OfferControl {
	private OfferContainer container;
	private static OfferControl instance;
	
	private Offer offer;
	
	public OfferControl()
	{
		readFile();
	}
	
	public static OfferControl getInstance()
	{
		if (instance == null) {
			instance = new OfferControl();
		}
		return instance;
	}
	
	public void addOffer(int iD, Contractor contractor, Date startDate, Date endDate)
	{
		container.addOffer(new Offer(iD, contractor, startDate, endDate));
		saveFile();
	}
	
	public Offer getOffer(int iD)
	{
		return container.getOffer(iD);
	}
	
	public void removeOffer(Offer offer)
	{
		container.removeOffer(offer);
		saveFile();
	}
	
	public ArrayList<Offer> getOffer(Date startDate, Date endDate)
	{
		return container.getOffers(startDate, endDate);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("offer.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (OfferContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {container = OfferContainer.getInstance();}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("offer.dat");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(container);
			save.close();
			saveFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
