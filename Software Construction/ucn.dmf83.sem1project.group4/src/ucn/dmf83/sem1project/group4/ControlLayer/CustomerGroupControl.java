package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class CustomerGroupControl {
	private ArrayList<customerGroup> customerGroups;
	
	private static CustomerGroupControl instance = null;

	protected CustomerGroupControl() {
		
	}

	public static CustomerGroupControl getInstance() {
		if (instance == null) {
			instance = new CustomerGroupControl();
		}
		return instance;
	}
	
	public void addCustomerGroup(customerGroup cgroup)
	{
		customerGroups.add(cgroup);
	}
	
	public void removeCustomerGroup(customerGroup cgroup)
	{
		customerGroups.remove(cgroup);
	}
	
	public customerGroup getCustomerGroup(int ID)
	{
		for(Iterator<customerGroup> i = customerGroups.iterator(); i.hasNext();)
		{
			customerGroup ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
