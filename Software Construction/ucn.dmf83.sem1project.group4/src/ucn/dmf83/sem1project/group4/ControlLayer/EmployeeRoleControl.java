package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class EmployeeRoleControl {
	private ArrayList<employeeRole> employeeRoles;
	private static EmployeeRoleControl instance = null;

	protected EmployeeRoleControl() {
	}

	public static EmployeeRoleControl getInstance() {
		if (instance == null) {
			instance = new EmployeeRoleControl();
		}
		return instance;
	}
}
