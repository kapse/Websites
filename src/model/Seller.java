package model;



public class Seller {
	
	
	String username;
	String password;
	String firstName;
	String middleName;
	String lastName;
	String email;
	String address;
	String phoneno;
	String companyName;
	String url;
	int sellerId;
	String bank_name;
	String branch_name;
	String account_number;
	String routing_number;
	
	public Seller()	{
		username = "";
		password = "";
		firstName = "";
		middleName="";
		lastName = "";
		email="";
		address="";
		phoneno="";
		companyName="";
		url="";
		bank_name="";
		branch_name="";
		account_number="";
		routing_number="";
		
	}
	public void setRoutingNumber(String routing_number) {
		this.routing_number = routing_number;
	}
	public String getRoutingNumber() {
		return routing_number;
	}
	public void setAccountNumber(String account_number) {
		this.account_number = account_number;
	}
	public String getAccountNumber() {
		return account_number;
	}
	public void setBranchName(String branch_name) {
		this.branch_name = branch_name;
	}
	public String getBranchName() {
		return branch_name;
	}
	public void setBankName(String bank_name) {
		this.bank_name = bank_name;
	}
	public String getBankName() {
		return bank_name;
	}
	public int getSellerId()
	{
		return sellerId;
	}
	public void setSellerId(int sellerId)
	{
		this.sellerId=sellerId;
	}
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	public String geturl() {
		return url;
	}

	public void seturl(String url) {
		this.url = url;
	}
	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	public String getPhoneno() {
		return phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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
