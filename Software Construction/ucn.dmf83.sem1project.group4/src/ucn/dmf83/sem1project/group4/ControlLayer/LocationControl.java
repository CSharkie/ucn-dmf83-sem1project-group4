package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class LocationControl {
	private ArrayList<Location> locations;
	
	private static LocationControl instance = null;

	protected LocationControl() {
	}

	public static LocationControl getInstance() {
		if (null == instance) {
			instance = new LocationControl();
		}
		return instance;
	}
	
	public void addLocation(Location loc)
	{
		locations.add(loc);
	}
	
	public void removeLocation(Location loc)
	{
		locations.remove(loc);
	}
	
	public Location getLocation(int ID)
	{
		for(Iterator<Location> i = locations.iterator(); i.hasNext();)
		{
			Location ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
	
	public Location getLocation(String name)
	{
		for(Iterator<Location> i = locations.iterator(); i.hasNext();)
		{
			Location loc = i.next();
			if(loc.getName() == name)
				return loc;
		}
		
		return null;
	}
	
	public Location getLocation(Product p)
	{
		for(Iterator<Location> i = locations.iterator(); i.hasNext();)
		{
			Location loc = i.next();
			if(loc.hasProduct(p))
				return loc;
		}
		
		return null;
	}
}
