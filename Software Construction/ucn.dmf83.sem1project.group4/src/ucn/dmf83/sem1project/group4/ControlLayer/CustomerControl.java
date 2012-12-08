package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class CustomerControl {
	private ArrayList<Customer> customers;
	
	private static CustomerControl instance = null;
	
	protected CustomerControl()
	{
		
	}
	
	public CustomerControl getInstance()
	{
		if(instance == null) {
	         instance = new CustomerControl();
	      }
	      return instance;
	}
	
	public void addCustomer(Customer customer)
	{
		customers.add(customer);
	}
	
	
}
