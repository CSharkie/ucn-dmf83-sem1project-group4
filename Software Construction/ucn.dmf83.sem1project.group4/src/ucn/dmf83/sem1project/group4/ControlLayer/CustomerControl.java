package ucn.dmf83.sem1project.group4.ControlLayer;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

/**
 * @author Group 4 DM83F
 */
public class CustomerControl {

	/**
	 * instance variables
	 */
	private CustomerContainer customer;
	
	public CustomerControl()
	{
		customer = CustomerContainer.getInstance();
	}
	
	public void createCustomer(String name, int ID, customerGroup cgroup)
	{
		customer.addCustomer(name, ID, cgroup);
	}
	
	public void removeCustomer(int ID)
	{
		customer.removeCustomer(ID);
	}
	
	public void updateCustomer(Customer original, Customer newc)
	{
		customer.updateCustomer(original, newc);
	}
	
	public void readFile()
	{
		
	}
	
	public void saveFile()
	{
		
	}
	
}
