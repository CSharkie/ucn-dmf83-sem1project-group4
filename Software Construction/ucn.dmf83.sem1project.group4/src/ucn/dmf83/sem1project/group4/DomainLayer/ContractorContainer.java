package ucn.dmf83.sem1project.group4.DomainLayer;

import java.util.ArrayList;
import java.io.Serializable;

public class ContractorContainer implements Serializable {

	private static final long serialVersionUID = -5712058401358043707L;

	private ArrayList<Contractor> contractors;
	
	private static ContractorContainer instance = null;

	protected ContractorContainer() {
		contractors = new ArrayList<Contractor>();
	}

	public static ContractorContainer getInstance() {
		if (instance == null) {
			instance = new ContractorContainer();
		}
		return instance;
	}
	
	public void addContractor(Contractor contractor)
	{
		contractors.add(contractor);
	}
	
	public void removeContractor(Contractor contractor)
	{
		contractors.remove(contractor);
	}
	
	// Get a contractor if we know it's ID
	public Contractor getContractor(int ID)
	{
		for(Contractor ct : contractors)
		{
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
	
	// Get contractors by partial name or full name
	public ArrayList<Contractor> getContractors(String name) {
		ArrayList<Contractor> cts = new ArrayList<Contractor>();
		for (Contractor ct : contractors) {
			if(ct.getName().contains(name))
				cts.add(ct);
		}
		return cts;
	}
	
	public void addContractor(int ID, String name) {
		addContractor(new Contractor(name, ID));
	}

}
