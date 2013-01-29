package ucn.dmf83.sem1project.group4.DomainLayer;

public class SystemUser {
	private String strUserName;
	private String strPassword;
	
	private boolean isElevated;
	private boolean isAdmin;
	
	public SystemUser() {
		
	}

	public SystemUser(String username, String password) {
		this.strUserName = username;
		this.strPassword = password;
	}

	public String getUserName() {
		return strUserName;
	}

	public void setUserName(String strUserName) {
		this.strUserName = strUserName;
	}

	public String getPassword() {
		return strPassword;
	}

	public void setPassword(String strPassword) {
		this.strPassword = strPassword;
	}

	public boolean isElevated() {
		return isElevated;
	}

	public void setElevated(boolean isElevated) {
		this.isElevated = isElevated;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
