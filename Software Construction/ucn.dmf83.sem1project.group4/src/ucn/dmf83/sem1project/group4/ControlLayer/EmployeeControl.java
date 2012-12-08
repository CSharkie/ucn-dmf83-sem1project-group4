package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class EmployeeControl {
	private ArrayList<Employee> employees;
	
	private static EmployeeControl instance = null;

	protected EmployeeControl() {
	}

	public static EmployeeControl getInstance() {
		if (instance == null) {
			instance = new EmployeeControl();
		}
		return instance;
	}
}
