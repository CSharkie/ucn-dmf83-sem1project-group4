package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Date;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Order {
	private int ID;
	
	private Customer customer;
	private Employee seller;
	private Date orderDate; // The exact time the order was made
	
	private TreeMap<Product,Integer> orderItems; // Key is the Product object, Value is the amount
	
	private double orderPrice; // SubTotal price of all items added together
	private int discount; // The amount of discount, in percentage (10, 20, etc)
	private double finalPrice; // The final price (subtotal - discount)
	
	private boolean isPaid;

	/**
	 * @param iD
	 * @param customer
	 * @param seller
	 * @param orderDate
	 * @param isPaid
	 */
	public Order(int iD, Customer customer, Employee seller, Date orderDate,
			boolean isPaid) {
		ID = iD;
		this.customer = customer;
		this.seller = seller;
		this.orderDate = orderDate;
		this.isPaid = isPaid;
	}
	
	
	
	
	public String printOrder()
	{
		String order = null;
		
		order += "Vestbjerg Byggecenter A/S\n";
		order += seller.getLocation().getName() + "\n";
		order += seller.getLocation().getAddress() + "\n\n\n";
		
		order += customer.getName() + "\n";
		order += customer.getAddress() + ", " + customer.getPostalCode() + " " + customer.getCity() + "\n";
		order += customer.getPhoneNum();
		
		order += "\n\n\n\n\n";
		
		for(Entry<Product,Integer> entry : orderItems.entrySet())
		{
			order += entry.getKey().getName() + "\t\t\t" + entry.getKey().getPrice(orderDate) + "\n";
			order += "\t x" + entry.getValue() + "\t\t" + (entry.getKey().getPrice(orderDate) * entry.getValue()) + "\n";
		}
		
		order += "\n\n";
		order += "\t Subtotal: " + "\t\t\t" + getOrderPrice() + "\n";
	
		order += "\t Discounts:" + "\t\t\t" + getDiscount() + "%\n";
		order += "\t Total:    " + "\t\t\t" + getFinalPrice() + "\n";
 		
		return order;
	}
	
	
	public void setOrderPrice()
	{
		orderPrice = 0;
		for(Entry<Product,Integer> entry : orderItems.entrySet())
			orderPrice += (entry.getKey().getPrice(orderDate) * entry.getValue());
	}
	
	public double getOrderPrice()
	{
		if(orderPrice == 0)
			setOrderPrice();
		
		return orderPrice;
	}
	
	public void setDiscount()
	{
		if((customer.getDiscount() + customer.getGroup().getDiscount()) > 20)
			discount = 20;
		else
			discount = (customer.getDiscount() + customer.getGroup().getDiscount());
	}
	
	public int getDiscount()
	{
		setDiscount();
		return discount;
	}
	
	public void setFinalPrice()
	{
		finalPrice = getOrderPrice() - (getOrderPrice() * (getDiscount() /100));
	}
	
	public double getFinalPrice()
	{
		setFinalPrice();
		return finalPrice;
	}
	
}
