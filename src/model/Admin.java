package model;



public class Admin {
	
	
	String username;
	String password;
	String firstName;
	String lastName;
	int adminId;
	
	public Admin()	{
		username = "";
		password = "";
		firstName = "";
		lastName = "";
	}
	public int getAdminId()
	{
		return adminId;
	}
	public void setAdminId(int adminId)
	{
		this.adminId=adminId;
	}
		public String getUserName() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
