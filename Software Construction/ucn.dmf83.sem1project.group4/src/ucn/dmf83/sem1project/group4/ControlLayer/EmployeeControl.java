package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

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
	
	public void addEmployee(Employee emp)
	{
		employees.add(emp);
	}
	
	public void removeEmployee(Employee emp)
	{
		employees.remove(emp);
	}
	
	public Employee getEmployee(int ID)
	{
		for(Iterator<Employee> i = employees.iterator(); i.hasNext();)
		{
			Employee ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
