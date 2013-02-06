package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Date;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class OrderControl {
	
	private OrderContainer container;
	private Order order;
	
	private static OrderControl instance = null;
	
	public OrderControl()
	{
		readFile();
	}
	
	public static OrderControl getInstance() {
		if (instance == null) {
			instance = new OrderControl();
		}
		return instance;
	}
	
	public void createOrder(int iD, Customer customer, Employee seller, Date orderDate, boolean isPaid)
    {
        container.addOrder(new Order(iD, customer, seller, orderDate, isPaid));
        saveFile();
    }
	
	public void getOrder(int ID)
    {
        this.order = container.getOrder(ID);
    }
	
	public ArrayList<Order> getOrders(Date startDate, Date endDate)
	{
		return container.getOrders(startDate, endDate);
	}
	
	public ArrayList<Order> getOrders(Employee emp)
	{
		return container.getOrders(emp);
	}
	
	public ArrayList<Order> getOrders(Date startDate)
	{
		return container.getOrders(startDate, new Date());
	}
	
	public double makePayment(Order o, double amount)
    {
        return amount - o.getFinalPrice();
    }
	
	public void removeOrder(Order order)
	{
		container.removeOrder(order);
		saveFile();
	}
	
	public ArrayList<Order> searchOrders(String filter) {
		return this.container.searchOrders(filter);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("order.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (OrderContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {container = OrderContainer.getInstance();}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("order.dat");
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
