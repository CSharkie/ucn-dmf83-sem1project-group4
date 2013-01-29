package ucn.dmf83.sem1project.group4.ControlLayer;

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
	
	public SystemUser authSystemUser(String username, String password) {
		SystemUser tempuser = container.authenticate(username, password);
		return tempuser;
	}
	
	public void flush() {
		container.flush();
	}
}
