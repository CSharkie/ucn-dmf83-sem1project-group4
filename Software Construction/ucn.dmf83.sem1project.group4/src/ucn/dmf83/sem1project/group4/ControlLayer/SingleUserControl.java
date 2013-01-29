package ucn.dmf83.sem1project.group4.ControlLayer;

import ucn.dmf83.sem1project.group4.DomainLayer.SystemUser;

public class SingleUserControl {
	
	private static SingleUserControl instance = null;
	private SystemUser user;
	
	
	protected SingleUserControl() {
		
	}
	
	public static SingleUserControl getInstance() {
		if(instance == null)
			instance = new SingleUserControl();
		
		return instance;
	}
	
	public void setUser(SystemUser user) {
		this.user = user;
	}
	
	public SystemUser getUser() {
		return this.user;
	}

}
