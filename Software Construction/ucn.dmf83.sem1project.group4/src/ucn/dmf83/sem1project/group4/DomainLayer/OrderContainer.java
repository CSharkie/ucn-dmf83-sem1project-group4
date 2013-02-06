package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Date;
import java.io.Serializable;

public class OrderContainer implements Serializable {
	
	private static final long serialVersionUID = 8509238208930032500L;

	private ArrayList<Order> orders;
	
	private static OrderContainer instance = null;

	protected OrderContainer() {
		orders = new ArrayList<Order>();
	}

	public static OrderContainer getInstance() {
		if (instance == null) {
			instance = new OrderContainer();
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
		for(Order order : orders)
		{
			if(order.getID() == ID)
				return order;
		}
		
		return null;
	}
	
	public ArrayList<Order> getOrders(Date startDate, Date endDate)
	{
		ArrayList<Order> orders = new ArrayList<Order>();

		for(Order order : this.orders)
		{
			if(order.getOrderDate().after(startDate) && order.getOrderDate().before(endDate))
				orders.add(order);
		}
		
		
		return orders;
	}
	
	public ArrayList<Order> getOrders(Employee emp)
	{
		ArrayList<Order> orders = new ArrayList<Order>();
		
		for(Order order : this.orders)
		{
			if(order.getSeller() == emp)
				orders.add(order);
		}
		
		return orders;
	}
	
	public ArrayList<Order> getOrders(Customer customer)
	{
		ArrayList<Order> orders = new ArrayList<Order>();
		
		for(Order order : this.orders)
		{
			if(order.getCustomer() == customer)
				orders.add(order);
		}
		
		return orders;
	}
	
	public ArrayList<Order> searchOrders(String filter) {
		ArrayList<Order> list = new ArrayList<Order>();

		
		for(Order l:orders) {
				if(filter != "") {
					if(("" + l.getCustomer()).toString().contains(filter) || (""+l.getSeller()).toString().contains(filter) || (""+l.getID()).toString().contains(filter))
						list.add(l);
				} else {
					list.add(l);
				}
		}
		
		return list;
	}

}
