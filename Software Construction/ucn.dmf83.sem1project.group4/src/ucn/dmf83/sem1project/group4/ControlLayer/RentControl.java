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
	
	private static RentControl instance = null;
	
	public RentControl()
	{
		readFile();
	}
	
	public static RentControl getInstance()
	{
		if (instance == null) {
			instance = new RentControl();
		}
		return instance;
	}
	
	public void createRent(int ID, Customer customer, Employee renter, Device device, Date startDate, int length)
	{
		container.addRent(new Rent(ID, customer, renter, device, startDate, length));
		saveFile();
	}
	
	public void getRent(int ID)
	{
		this.rent = container.getRent(ID);
	}
	
	public void removeRent(int ID)
	{
		getRent(ID);
		container.removeRent(this.rent);
		saveFile();
	}
	
	public void updateRent(Rent rent) {
		container.removeRent(this.rent);
		this.rent = rent;
		container.addRent(this.rent);
		saveFile();
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("rent.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (RentContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {container = RentContainer.getInstance();}
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
