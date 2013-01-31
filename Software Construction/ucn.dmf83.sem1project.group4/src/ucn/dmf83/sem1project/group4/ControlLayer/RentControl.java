package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.Date;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class RentControl {
	
	private RentContainer container;
	private Rent rent;
	
	private static RentControl instance;
	
	public RentControl()
	{
		container = RentContainer.getInstance();
	}
	
	public static RentControl getInstance()
	{
		if (instance == null) {
			instance = new RentControl();
		}
		return instance;
	}
	
	public Rent createRent(int ID, Customer customer, Employee renter, Device device, Date startDate, int length)
	{
		rent = new Rent(ID, customer, renter, device, startDate, length);
		container.addRent(rent);
		return rent;
	}
	
	public Rent getRent(int ID)
	{
		return container.getRent(ID);
	}
	
	public void removeRent(Rent rent)
	{
		container.removeRent(rent);
	}
	
	public void readFile()
	{
		
	}
	
	public void saveFile()
	{
		
	}

}
