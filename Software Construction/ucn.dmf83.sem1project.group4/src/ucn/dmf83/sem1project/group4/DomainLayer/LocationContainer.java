package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class LocationContainer implements Serializable {
	
	private static final long serialVersionUID = 3354847234590476836L;

	private ArrayList<Location> locations;
	
	private static LocationContainer instance = null;

	protected LocationContainer() {
	}

	public static LocationContainer getInstance() {
		if (null == instance) {
			instance = new LocationContainer();
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
		for(Location loc : locations)
		{
			if(loc.hasProduct(p))
				return loc;
		}
		
		return null;
	}
	
	public ArrayList<Location> getLocations() {
		return locations;
	}
	
	public ArrayList<Product> getProducts(String location) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		Location temp = getLocation(location);
		
		for(Product p:temp.getProducts()) {
			list.add(p);
		}
		
		
		return list;
	}
	
	public ArrayList<Product> getProducts() {
		ArrayList<Product> list = new ArrayList<Product>();
		
		for(Location l:locations) {
			for(Product p:l.getProducts())
				list.add(p);
		}
		
		
		return list;
	}
	
	public ArrayList<Product> searchProducts(String location, String filter) {
		ArrayList<Product> list = new ArrayList<Product>();
		
		Location temp = getLocation(location);
		
		for(Product p:temp.getProducts()) {
			if(filter != "")
				if(p.getName().toString().contains(filter) || Integer.toString(p.getID()).contains(filter))
					list.add(p);
		}
		
		
		return list;
	}
	
	public ArrayList<Product> searchProducts(String filter) {
		ArrayList<Product> list = new ArrayList<Product>();

		
		for(Location l:locations) {
			for(Product p:l.getProducts()) {
				if(filter != "")
					if(p.getName().toString().contains(filter) || Integer.toString(p.getID()).contains(filter))
						list.add(p);
			}
		}
		
		
		return list;
	}
	
	public Product getProduct(int ID) {
		Product pa = null;
		
		for(Location l:locations) {
			if(l.getProduct(ID) != null )
				pa = l.getProduct(ID);
		}
		return pa;
	}

}
