package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Map;
import java.util.Date;


public class Product {
	private String ID;
	private String name;
	private String description;
	
	private Map<Date,Integer> prices;
	
	private int currentNumber;
	
	private int minNumber;
	private int maxNumber;
}
