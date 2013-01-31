package ucn.dmf83.sem1project.group4.ControlLayer;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

/**
 * @author Group 4 DM83F
 */
public class EmployeeControl {
	
	/**
	 * instance variables
	 */
	private EmployeeContainer container;
	private Employee employee;
	
	public EmployeeControl()
	{
		container = EmployeeContainer.getInstance();
	}
	
	public void createEmployee(String name, Location location )
	{
		container.createEmployee(name,location);
	}
	
	public void removeEmployee(int ID)
	{
		container.removeEmloyee(ID);
	}
	
	public void getEmployee(int ID) {
		this.employee = container.getEmployee(ID);
	}
	
	public void updateEmployeeLocation(Location location)
	{
		employee.setLocation(location);
	}
	
	public void readFile()
	{
		
	}
	
	public void saveFile()
	{
		
	}
	
}
