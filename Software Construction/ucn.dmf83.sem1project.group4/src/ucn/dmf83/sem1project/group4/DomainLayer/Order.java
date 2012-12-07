package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Date;
import java.util.Map;

public class Order {
	private int ID;
	
	private Customer customer;
	private Employee seller;
	private Date orderDate;
	
	private Map<Product,Integer> orderItems;
	
	private int orderPrice;
	private int discount;
	private int finalprice;
	
	private boolean isPaid;
}
