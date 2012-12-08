package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class OrderControl {
	private ArrayList<Order> orders;
	
	private static OrderControl instance = null;

	protected OrderControl() {
	}

	public static OrderControl getInstance() {
		if (instance == null) {
			instance = new OrderControl();
		}
		return instance;
	}
}
