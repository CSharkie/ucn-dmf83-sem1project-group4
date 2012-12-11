package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class ProductControl {
	private ArrayList<Product> products;
	
	private static ProductControl instance = null;

	protected ProductControl() {
		products = new ArrayList<Product>();
	}

	public static ProductControl getInstance() {
		if (instance == null) {
			instance = new ProductControl();
		}
		return instance;
	}
	
	
	public void addProduct(Product p, String locationName) {
		products.add(p);
		LocationControl.getInstance().getLocation(locationName).addProduct(p);
	}
	
}
