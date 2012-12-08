package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Date;
import java.util.TreeMap;

public class Offer {
	private int ID;
	
	private Contractor contractor;
	
	private Date startDate;
	private Date endDate;
	
	private TreeMap<Product,Integer> offeredProducts;
}
