package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

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
		readFile();
		container = EmployeeContainer.getInstance();
	}
	
	public void createEmployee(String name, Location location )
	{
		container.createEmployee(name,location);
		saveFile();
	}
	
	public void removeEmployee(int ID)
	{
		container.removeEmloyee(ID);
		saveFile();
	}
	
	public Employee getEmployee(int ID) {
		return container.getEmployee(ID);
	}
	
	public void updateEmployeeLocation(Location location)
	{
		employee.setLocation(location);
		saveFile();
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("employee.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (EmployeeContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("employee.dat");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(container);
			save.close();
			saveFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
