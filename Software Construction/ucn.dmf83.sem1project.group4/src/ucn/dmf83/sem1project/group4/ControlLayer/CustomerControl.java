package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

/**
 * @author Group 4 DM83F
 */
public class CustomerControl {

	/**
	 * instance variables
	 */
	private CustomerContainer container;
	
	public CustomerControl()
	{
		container = CustomerContainer.getInstance();
	}
	
	public void createCustomer(String name, int ID, customerGroup cgroup)
	{
		container.addCustomer(name, ID, cgroup);
	}
	
	public void removeCustomer(int ID)
	{
		container.removeCustomer(ID);
	}
	
	public void updateCustomer(Customer original, Customer newc)
	{
		container.updateCustomer(original, newc);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("customer.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (CustomerContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("customer.dat");
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
