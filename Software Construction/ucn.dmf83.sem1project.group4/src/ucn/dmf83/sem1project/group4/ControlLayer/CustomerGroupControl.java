package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class CustomerGroupControl {
	private ArrayList<customerGroup> customerGroups;
	
	private static CustomerGroupControl instance = null;

	protected CustomerGroupControl() {
	}

	public static CustomerGroupControl getInstance() {
		if (instance == null) {
			instance = new CustomerGroupControl();
		}
		return instance;
	}
}
