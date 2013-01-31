package ucn.dmf83.sem1project.group4.ControlLayer;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class LocationControl {
	
	private LocationContainer container;
	private Location location;
	
	private static LocationControl instance;
	
	public LocationControl()
	{
		container = LocationContainer.getInstance();
	}
	
	public static LocationControl getInstance()
	{
		if (instance == null) {
			instance = new LocationControl();
		}
		return instance;
	}
	
	public Location createLocation(int ID, String address)
	{
		location = new Location(ID, address);
		container.addLocation(location);
		return location;
	}
	
	public Location getLocation(int ID)
	{
		return container.getLocation(ID);
	}
	
	public Location getLocation(String name)
	{
		return container.getLocation(name);
	}
	
	public Location getLocation(Product p)
	{
		return container.getLocation(p);
	}
	
	public void removeLocation(Location location)
	{
		container.removeLocation(location);
	}
	
	public void readFile()
	{
		
	}
	
	public void saveFile()
	{
		
	}

}
