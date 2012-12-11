package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public void addEmployeeRole(employeeRole emprole)
	{
		employeeRoles.add(emprole);
	}
	
	public void removeEmployeeRole(employeeRole emprole)
	{
		employeeRoles.remove(emprole);
	}
	
	public employeeRole getEmployeeRole(int ID)
	{
		for(Iterator<employeeRole> i = employeeRoles.iterator(); i.hasNext();)
		{
			employeeRole ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
