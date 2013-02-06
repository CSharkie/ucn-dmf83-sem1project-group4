package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class LocationControl {
	
	private LocationContainer container;
	private Location location;
	
	private static LocationControl instance;
	
	protected LocationControl()
	{
		readFile();
		container = LocationContainer.getInstance();
		
	}
	
	public static LocationControl getInstance()
	{
		if (instance == null) {
			instance = new LocationControl();
		}
		return instance;
	}
	
	public void createLocation(int ID, String address)
	{
		container.addLocation(new Location(ID, address));
		System.out.println("LocationDB - added new location " + ID + "; " + address);
		saveFile();
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
		saveFile();
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("location.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (LocationContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("location.dat");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(container);
			save.close();
			saveFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public ArrayList<Product> getProducts(String location) {
		return this.container.getProducts(location);
	}
	
	public ArrayList<Product> getProducts() {
		return this.container.getProducts();
	}
	
	public ArrayList<Product> searchProducts(String location, String filter) {
		return this.container.searchProducts(location, filter);
	}
	
	public ArrayList<Product> searchProducts(String filter) {
		return this.container.searchProducts(filter);
	}
	
	public Product getProduct(int ID) {
		return this.container.getProduct(ID);
	}
	
	public ArrayList<Location> getLocations() {
		return this.container.getLocations();
	}
	
	public ArrayList<Location> searchLocations(String filter) {
		return this.container.searchLocations(filter);
	}
	

}
