package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class RentControl {
	private ArrayList<Rent> rents;
	
	private static RentControl instance = null;

	protected RentControl() {
	}

	public static RentControl getInstance() {
		if (instance == null) {
			instance = new RentControl();
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
