package ucn.dmf83.sem1project.group4.DomainLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Order implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6523321720362818818L;

	private int ID;
	
	private Customer customer;
	private Employee seller;
	private Date orderDate; // The exact time the order was made
	
	private TreeMap orderItems; // Key is the Product object, Value is the amount
	
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
		
		orderItems = new TreeMap<Product,Integer>();
	}
	
	/**
	 * @return the iD
	 */
	public int getID() {
		return ID;
	}

	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}

	/**
	 * @return the seller
	 */
	public Employee getSeller() {
		return seller;
	}

	/**
	 * @return the orderDate
	 */
	public Date getOrderDate() {
		return orderDate;
	}
	
	/**
	 * @return the isPaid
	 */
	public boolean isPaid() {
		return isPaid;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(int iD) {
		ID = iD;
	}

	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	/**
	 * @param seller the seller to set
	 */
	public void setSeller(Employee seller) {
		this.seller = seller;
	}

	/**
	 * @param orderDate the orderDate to set
	 */
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * @param isPaid the isPaid to set
	 */
	public void setPaid(boolean isPaid) {
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
		
		for(Iterator it = orderItems.entrySet().iterator(); it.hasNext();)
		{
			Map.Entry entry = (Entry) it.next();
			order += ((Product)entry.getKey()).getName() + "\t\t\t" + ((Product)entry.getKey()).getPrice(orderDate) + "\n";
			order += "\t x" + (Product)entry.getValue() + "\t\t" + (((Product)entry.getKey()).getPrice(orderDate)) * (Integer)entry.getValue() + "\n";
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
		for(Iterator it = orderItems.entrySet().iterator();it.hasNext();) {
			Map.Entry entry = (Entry) it.next();
			orderPrice += ((Integer)((Product)entry.getKey()).getPrice(orderDate)) * (Integer)entry.getValue();
		}
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
	
	public ArrayList<Product> getProducts()
	{
		ArrayList<Product> products = new ArrayList<Product>();
		
		if(!orderItems.isEmpty()) {
			for(Iterator it = orderItems.keySet().iterator(); it.hasNext();)
			{
				Map.Entry entry = (Entry) it.next();
				products.add((Product)entry.getKey());
			}
		}
		return products;
	}
	
	public void addProduct(Product product, Integer amount)
	{
		orderItems.put(product, amount);
		product.sell(amount);
	}
	
	public void removeProduct(Product product)
	{
		product.buy((Integer)orderItems.get(product));
		orderItems.remove(product);
	}
	
	public void modifyPrice(Product product, Integer newPrice)
	{
		Product oldProduct = product;
		product.addPrice(new Date(), newPrice);
		orderItems.put(product, orderItems.get(oldProduct));
	}
	
	public void modifyAmount(Product product, Integer amount)
	{
		product.buy((Integer)orderItems.get(product));
		orderItems.put(product, amount);
		product.sell(amount);
	}
	
	public Order getOrder()
	{
		return this;
	}
	
	public int getAmount(Product product) {
		return (Integer)orderItems.get(product);
	}
}
