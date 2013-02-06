/**
 * 
 */
package ucn.dmf83.sem1project.group4.DomainLayer;

import java.io.Serializable;

/**
 * @author József
 *
 */
public class Employee extends User implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5508260984606119628L;
	private Location location;

	public Employee(String name, int ID, Location location) {
		super(name, ID);
		this.location = location;
	}
	
	
	public Employee() {
		super();
	}

	
	public Employee(String name, int ID) {
		super(name, ID);
	}


	/**
	 * @return the location
	 */
	public Location getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(Location location) {
		this.location = location;
	}
}
