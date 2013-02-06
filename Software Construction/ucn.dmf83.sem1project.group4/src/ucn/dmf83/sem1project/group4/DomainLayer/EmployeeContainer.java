package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.util.Iterator;
import java.io.Serializable;

public class EmployeeContainer implements Serializable {
	
	private static final long serialVersionUID = 6691751667232337863L;

	private ArrayList<Employee> employees;
	
	private static EmployeeContainer instance = null;

	protected EmployeeContainer() {
		employees = new ArrayList<Employee>();
	}

	public static EmployeeContainer getInstance() {
		if (instance == null) {
			instance = new EmployeeContainer();
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
	
	public boolean checkID(int ID)
    {
        for(Employee employee: employees)
        {
            if(employee.getID() == ID)
            return false;
        }
        return true;
    }
	
	public void createEmployee(String name, Location location)
	{
		int ID = employees.size();
		Employee employee = new Employee(name, ID, location);
		addEmployee(employee);
	}
	
	public void removeEmloyee(int ID)
	{
		if(getEmployee(ID)==null)
		{
			System.out.println("Emplyee ID doesn't exists.");
		} else {
			Employee employee = getEmployee(ID);
			employees.remove(employee);
		}
	}
	
	public ArrayList<Employee> searchEmployees(String filter) {
		ArrayList<Employee> list = new ArrayList<Employee>();

		
		for(Employee l:employees) {
				if(filter != "") {
					if(("" + l.getName()).toString().contains(filter) || (""+l.getID()).toString().contains(filter))
						list.add(l);
				} else {
					list.add(l);
				}
		}
		
		return list;
	}

}
