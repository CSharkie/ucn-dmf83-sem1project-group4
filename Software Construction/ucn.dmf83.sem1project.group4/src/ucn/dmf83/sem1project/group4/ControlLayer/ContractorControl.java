package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import ucn.dmf83.sem1project.group4.DomainLayer.*;

public class ContractorControl {
	
	private ContractorContainer contractor;
	
	public ContractorControl()
	{
		contractor = ContractorContainer.getInstance();
	}
	
	public void createContractor(int ID, String name)
	{
		contractor.addContractor(ID, name);
	}
	
	public ArrayList<Contractor> getContractors(String name)
	{
		return contractor.getContractors(name);
	}
	
	public Contractor getContractor(int ID)
	{
		return contractor.getContractor(ID);
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("contractor.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		contractor = (ContractorContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("contractor.dat");
			ObjectOutputStream save = new ObjectOutputStream(saveFile);
			save.writeObject(contractor);
			save.close();
			saveFile.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
