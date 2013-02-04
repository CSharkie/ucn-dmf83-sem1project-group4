package ucn.dmf83.sem1project.group4.ControlLayer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import ucn.dmf83.sem1project.group4.DomainLayer.CustomerContainer;
import ucn.dmf83.sem1project.group4.DomainLayer.SystemUser;
import ucn.dmf83.sem1project.group4.DomainLayer.SystemUserContainer;

public class SystemUserControl {
	private SystemUserContainer container;
	private SystemUser user;
	
	public SystemUserControl() {
		container = SystemUserContainer.getInstance();
	}
	
	public void addSystemUser(String username, String password) {
		container.addSystemUser(username,password);
	}
	
	public void getSystemUser(String username) {
		user = container.getSystemUser(username);
	}
	
	public void removeSystemUser() {
		container.removeSystemUser(user);
	}
	
	public void updateSystemUser(String username, String password) {
		getSystemUser(username);
		removeSystemUser();
		addSystemUser(username,password);
	}
	
	public void updateSystemUserRights(boolean isManager, boolean isAdmin) {
		container.removeSystemUser(user);
		user.setElevated(isManager);
		user.setAdmin(isAdmin);
		container.addSystemUser(user);
	}
	
	public SystemUser authSystemUser(String username, String password) {
		SystemUser tempuser = container.authenticate(username, password);
		return tempuser;
	}
	
	public void flush() {
		container.flush();
	}
	
	public SystemUser getSystemUser() {
		return this.user;
	}
	
	public void readFile()
	{
		try {
		FileInputStream saveFile = new FileInputStream("user.dat");
		ObjectInputStream restore = new ObjectInputStream(saveFile);
		container = (SystemUserContainer) restore.readObject();
		restore.close();
		saveFile.close();
		
		} catch(Exception e) {}
	}
	
	public void saveFile()
	{
		try {
			FileOutputStream saveFile = new FileOutputStream("user.dat");
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
