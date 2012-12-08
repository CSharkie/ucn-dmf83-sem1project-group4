package ucn.dmf83.sem1project.group4.ControlLayer;

import java.util.ArrayList;
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
}
