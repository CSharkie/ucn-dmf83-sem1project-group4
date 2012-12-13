package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Iterator;

public class RentContainer {
	
private ArrayList<Rent> rents;
	
	private static RentContainer instance = null;

	protected RentContainer() {
	}

	public static RentContainer getInstance() {
		if (instance == null) {
			instance = new RentContainer();
		}
		return instance;
	}
	
	public void addRent(Rent rent)
	{
		rents.add(rent);
	}
	
	public void removeRent(Rent rent)
	{
		rents.remove(rent);
	}
	
	public Rent getRent(int ID)
	{
		for(Iterator<Rent> i = rents.iterator(); i.hasNext();)
		{
			Rent ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
	
}
