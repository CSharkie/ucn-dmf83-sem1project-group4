package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Date;

public class Rent {
	private Date startDate;
	private int length;
	private Date endDate;
	
	private Customer customer;
	private Employee renter;
	private Device device;
	
	private double rentPrice;
	private int discount;
	private double finalPrice;
}
