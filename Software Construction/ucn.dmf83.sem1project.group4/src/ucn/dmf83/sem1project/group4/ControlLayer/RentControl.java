package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class RentControl {
	private ArrayList<Rent> rents;
	
	private static RentControl instance = null;

	protected RentControl() {
	}

	public static RentControl getInstance() {
		if (instance == null) {
			instance = new RentControl();
		}
		return instance;
	}
}
