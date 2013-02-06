package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

/**
 * @author Group 4 DM83F
 */
public class CustomerControl {

	/**
	 * instance variables
	 */
	private CustomerContainer container;
	
	private static CustomerControl instance = null;
	
	public CustomerControl()
	{
		readFile();
	}
	
	public static CustomerControl getInstance() {
		if(instance == null)
			instance = new CustomerControl();
		
		return instance;
	}
	
	public void createCustomer(String name, int ID, customerGroup cgroup)
	{
		container.addCustomer(name, ID, cgroup);
		saveFile();
	}
	
	public void removeCustomer(int ID)
	{
		container.removeCustomer(ID);
		saveFile();
	}
	
	public void updateCustomer(Customer original, Customer newc)
	{
		container.updateCustomer(original, newc);
		saveFile();
	}
	
	public Customer getCustomer(int ID)
	{
		return container.getCustomer(ID);
	}
	
	public ArrayList<Customer> getCustomer(String partialName)
	{
		return container.getCustomers(partialName);
	}
	
	public customerGroup getCustomerGroup(int ID)
	{
		return container.getCustomerGroup(ID);
	}
	
	public ArrayList<Customer> searchCustomers(String filter) {
		return this.container.searchCustomers(filter);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("customer.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (CustomerContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {container = CustomerContainer.getInstance();}
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
