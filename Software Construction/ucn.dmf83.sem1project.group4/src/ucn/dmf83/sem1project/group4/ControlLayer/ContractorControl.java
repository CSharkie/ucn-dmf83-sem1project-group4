package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
import java.util.Iterator;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class ContractorControl {
	private ArrayList<Contractor> contractors;
	
	private static ContractorControl instance = null;

	protected ContractorControl() {
		
	}

	public static ContractorControl getInstance() {
		if (instance == null) {
			instance = new ContractorControl();
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
	
	public Contractor getContractor(int ID)
	{
		for(Iterator<Contractor> i = contractors.iterator(); i.hasNext();)
		{
			Contractor ct = i.next();
			if(ct.getID() == ID)
				return ct;
		}
		
		return null;
	}
}
