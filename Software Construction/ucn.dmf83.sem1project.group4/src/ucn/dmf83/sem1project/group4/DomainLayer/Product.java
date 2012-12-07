package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.Map;
import java.util.Date;


public class Product extends Item{
	
	private Map<Date,Integer> prices;
	
	private int currentNumber;
	
	private int minNumber;
	private int maxNumber;
}
