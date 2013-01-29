package ucn.dmf83.sem1project.group4.DomainLayer;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class SystemUserContainer implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8172086567160874425L;

	private ArrayList<SystemUser> systemUsers;
	
	private static SystemUserContainer instance = null;
	
	protected SystemUserContainer() {
		systemUsers = new ArrayList<SystemUser>();
	}
	
	public static SystemUserContainer getInstance(){
		if(instance == null)
			instance = new SystemUserContainer();
		
		return instance;
	}
	
	public SystemUser authenticate(String username, String password) {
		SystemUser user = null;
		
		for(Iterator<SystemUser> it = systemUsers.iterator(); it.hasNext();) {
			SystemUser tempuser = it.next();
			if(getUserState(tempuser.getUserName())) {
				System.out.println("UserDB - User " + tempuser.getUserName() + " exists.");
				if(tempuser.getPassword().equals(password.toString())) {
					System.out.println("UserDB - User " + tempuser.getUserName() + " authenticated.");
					user = tempuser;
				}
			}
		}
		
		return user;
	}
	
	private boolean getUserState(String username) {
		boolean exists = false;
		
		for(SystemUser user:systemUsers) {
			if(user.getUserName() == username)
				exists = true;
		}
		
		
		return exists;
	}
	
	public SystemUser getSystemUser(String username) {
		SystemUser user = null;
		
		for(SystemUser tempuser : systemUsers) {
			if(tempuser.getUserName().equals(username))
				user = tempuser;
		}
		
		return user;		
	}
	
	public void addSystemUser(String username, String password) {
		if(getUserState(username)) {
			systemUsers.add(new SystemUser(username,password));
			System.out.println("UserDB - Added user " +  username);
		}
		else 
		{
			System.out.println("UserDB - User " + username + " already exists!");
		}
			
	}
	
	public void removeSystemUser(SystemUser user) {
		systemUsers.remove(user);
	}
	
	public void updateSystemUser(String username, SystemUser user) {
		removeSystemUser(getSystemUser(username));
		addSystemUser(user.getUserName(),user.getPassword());
	}
	
	
	public void flush() {
		systemUsers.clear();
		systemUsers = new ArrayList<SystemUser>();
	}

}
