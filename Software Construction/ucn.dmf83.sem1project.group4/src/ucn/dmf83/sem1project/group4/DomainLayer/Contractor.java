package ucn.dmf83.sem1project.group4.DomainLayer;

import java.io.Serializable;

public class Contractor extends User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5232952646258263573L;

	public Contractor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Contractor(int ID) {
		super(ID);
		// TODO Auto-generated constructor stub
	}

	public Contractor(String name, int ID) {
		super(name, ID);
		// TODO Auto-generated constructor stub
	}
	
}
