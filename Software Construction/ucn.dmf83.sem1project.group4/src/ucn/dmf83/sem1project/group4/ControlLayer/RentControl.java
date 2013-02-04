package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
	
	public void getRent(int ID)
	{
		this.rent = container.getRent(ID);
	}
	
	public void removeRent()
	{
		container.removeRent(this.rent);
	}
	
	public void updateRent(Rent rent) {
		container.removeRent(this.rent);
		this.rent = rent;
		container.addRent(this.rent);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("rent.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (RentContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("rent.dat");
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
