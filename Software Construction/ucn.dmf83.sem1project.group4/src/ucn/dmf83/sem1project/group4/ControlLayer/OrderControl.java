package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class OrderControl {
	private ArrayList<Order> orders;
	
	private static OrderControl instance = null;

	protected OrderControl() {
		orders = new ArrayList<Order>();
	}

	public static OrderControl getInstance() {
		if (instance == null) {
			instance = new OrderControl();
		}
		return instance;
	}
	
	public void addOrder(Order order)
	{
		orders.add(order);
	}
	
	public void removeOrder(Order order)
	{
		orders.remove(order);
	}
	
	public Order getOrder(int ID)
	{
		for(Iterator<Order> i = orders.iterator(); i.hasNext();)
		{
			Order ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
