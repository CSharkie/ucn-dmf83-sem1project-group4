package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class LocationControl {
	private ArrayList<Location> locations;
	
	private static LocationControl instance = null;

	protected LocationControl() {
	}

	public static LocationControl getInstance() {
		if (null == instance) {
			instance = new LocationControl();
		}
		return instance;
	}
}
