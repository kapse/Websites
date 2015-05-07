package model;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

public class AuthDAO {
	
	static Connection con = null;    
    static PreparedStatement ps = null;    
    static ResultSet rs = null;
    
    public AuthDAO()
    {  
    	try {
    		Class.forName("com.mysql.jdbc.Driver");
    	   	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			System.out.println("Connected Successfully");
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
    }
    public static boolean sellerContactBuyer(int seller_id,int user_id,String msg)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			System.out.println("Connected success");
			String sql="Insert into notification(userId,sellerId,msg) values('"+seller_id+"','"+user_id+"','"+msg+"')";			
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean adminContactBuyer(int admin_id,int user_id,String msg)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			System.out.println("Connected success");
			String sql="Insert into notification(userId,adminId,msg) values('"+user_id+"','"+admin_id+"','"+msg+"')";			
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean adminContactSeller(int admin_id,int seller_id,String msg)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			System.out.println("Connected success");
			String sql="Insert into notification(sellerId,adminId,msg) values('"+seller_id+"','"+admin_id+"','"+msg+"')";			
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean updateOrder(int order_id,String order_status)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();			
			String sql="UPDATE orderr SET order_status='"+order_status+"' WHERE order_id='"+order_id+"'";
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static int getSellerId(String uname)throws Exception
	{
		int sellerId;		
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");	    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			String sql = "select * from seller where username='"+uname+"'";			
			ResultSet rs=st.executeQuery(sql);
			while(rs.next())
			{
				sellerId=rs.getInt("sellerId");		
				
					return sellerId;
				
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return 0;
	}
    public static boolean updateSellerProduct(int p_id,String p_name,String price,String p_size,String p_desc)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();			
			String sql="UPDATE product SET p_name='"+p_name+"',price='"+price+"',p_size='"+p_size+"',p_desc='"+p_desc+"' WHERE p_id='"+p_id+"'";
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean updateProduct(int p_id,String p_name,String price,String p_size,String p_desc)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();			
			String sql="UPDATE product SET p_name='"+p_name+"',price='"+price+"',p_size='"+p_size+"',p_desc='"+p_desc+"' WHERE p_id='"+p_id+"'";
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean deleteProduct(int p_id)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			String sql = "delete from product where p_id='"+p_id+"'";
		
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean deleteOrder(int order_id)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			String sql = "delete from orderr where order_id='"+order_id+"'";
		
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean deleteProductByAdmin(int p_id)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			String sql = "delete from product where p_id='"+p_id+"'";
		
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean deleteSellerInfo(String username)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			String sql = "delete from seller where username='"+username+"'";
		
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static boolean updateSellerInfo(String username,String companyname,String firstname,String middlename,String lastname,String email,String address,String phoneno,String url,String password,String bank_name,String branch_name,String account_number,String routing_number)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			System.out.println(username);
			String sql="UPDATE seller SET companyname='"+companyname+"',firstname='"+firstname+"',middlename='"+middlename+"',lastname='"+lastname+"',email='"+email+"',address='"+address+"',phoneno='"+phoneno+"',url='"+url+"',password='"+password+"' ,bank_name='"+bank_name+"', branch_name='"+branch_name+"' ,account_number='"+account_number+"',routing_number='"+routing_number+"' WHERE username='"+username+"'";
			//	rs=st.executeQuery(sql);
			st.executeUpdate(sql);			
			ret=true;
			return ret;			
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    public static int checkSellerUserPass(String uname, String pass)throws Exception
	{
		String name="";
		String pas="";
		String permission="";
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");	    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from seller");
			while(rs.next())
			{
				name=rs.getString("username");
				pas=rs.getString("password");
				permission=rs.getString("permission");
				if(uname.equals(name) && pass.equals(pas) && permission.equals("yes"))
				{
					System.out.print("Login successfuly");
					System.out.println(rs.getInt(1));
					return rs.getInt(1);
				}
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return 0;
	}
    public static Seller getSellerById(int sellerId) throws ClassNotFoundException
    {
    	
		ResultSet rs;
		
		String firstname="";
		String lastname="";
		String username="";
		String middlename="";
		String email="";
		String address="";
		String phoneno="";
		String url="";
		String password="";
		String companyname="";
		int sellerID = 0;
		String bank_name="";
		String branch_name="";
		String account_number="";
		String routing_number="";
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
		    Statement st=con.createStatement();
		    String sql = "select * from seller where sellerId = "+sellerId;
			rs=st.executeQuery(sql);			
			if(rs.next())	{
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				username=rs.getString("username");
				middlename=rs.getString("middlename");
				email=rs.getString("email");
				address=rs.getString("address");
				phoneno=rs.getString("phoneno");
				url=rs.getString("url");
				password=rs.getString("password");
				companyname=rs.getString("companyname");
				sellerID=sellerID + rs.getInt("sellerId");
				bank_name=rs.getString("bank_name");
				branch_name=rs.getString("branch_name");
				account_number=rs.getString("account_number");
				routing_number=rs.getString("routing_number");
			}
			System.out.println(firstname);
			System.out.println(lastname);
			System.out.println(username);
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			
		}		
		Seller seller = new Seller();
		seller.setFirstName(firstname);
		seller.setLastName(lastname);
		seller.setUserName(username);
		seller.setMiddleName(middlename);
		seller.setEmail(email);
		seller.setAddress(address);
		seller.setPhoneno(phoneno);
		seller.seturl(url);
		seller.setPassword(password);
		seller.setCompanyName(companyname);
		seller.setSellerId(sellerID);
		seller.setBankName(bank_name);
		seller.setBranchName(branch_name);
		seller.setAccountNumber(account_number);
		seller.setRoutingNumber(routing_number);
		return seller;
    }
    public static int checkAdminUserPass(String uname, String pass)throws Exception
	{
		String name="";
		String pas="";
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");	    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from admin");
			while(rs.next())
			{
				name=rs.getString("username");
				pas=rs.getString("password");
				if(uname.equals(name) && pass.equals(pas))
				{
					System.out.print("Login successfuly");
					System.out.println(rs.getInt(1));
					return rs.getInt(1);
				}
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return 0;
	}
    public static Admin getAdminById(int adminId) throws ClassNotFoundException
    {
    	
		ResultSet rs;
		
		String firstname="";
		String lastname="";
		int adminID=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
		    Statement st=con.createStatement();
		    String sql = "select * from admin where adminId = "+adminId;
			rs=st.executeQuery(sql);			
			if(rs.next())	{
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
				adminID=adminID + rs.getInt("adminId");
			}
			System.out.println(firstname);
			System.out.println(lastname);
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			
		}		
		Admin admin = new Admin();
		admin.setFirstName(firstname);
		admin.setLastName(lastname);		
		admin.setAdminId(adminID);
		
		return admin;
    }
        

	public static int checkUserUsernamePassword(String uname, String pass)throws Exception
	{
		String name="";
		String pas="";
		try
		{  
			Class.forName("com.mysql.jdbc.Driver");	    
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next())
			{
				name=rs.getString("username");
				pas=rs.getString("password");
				if(uname.equals(name) && pass.equals(pas))
				{
					System.out.print("Login successfuly");
					System.out.println(rs.getInt(1));
					return rs.getInt(1);
				}
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return 0;
	}

    public static User getUserById(int userId) throws ClassNotFoundException
    {
    	
		ResultSet rs;
		
		String firstname="";
		String lastname="";
			
		try {
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
		    Statement st=con.createStatement();
		    String sql = "select * from user where userId = "+userId;
			rs=st.executeQuery(sql);			
			if(rs.next())	{
				firstname = rs.getString("firstname");
				lastname = rs.getString("lastname");
			}
			System.out.println(firstname);
			System.out.println(lastname);
			
		}
		
		catch (SQLException e) {
			e.printStackTrace();
			
		}
		
		User user = new User();
		user.setFirstName(firstname);
		user.setLastName(lastname);
		
		
		return user;
    }
    
    public static boolean isSellerUserNameAvailable(String userName)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from seller");
			while(rs.next())
			{
				name=rs.getString("username");
				
				if(userName.equals(name))
				{
					ret=true;
					return ret;
				}
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
    
    public static int enterNewSeller(String username,String companyname,String firstname,String middlename,String lastname,String email,String address,String phoneno,String url, String password)
	{   
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			con.setAutoCommit(true);
			String qry="insert into seller(sellerId,username,companyname,firstname,middlename,lastname,email,address,phoneno,url,password) values ('"+0+"','"+username+"','"+companyname+"','"+firstname+"','"+middlename+"','"+lastname+"','"+email+"','"+address+"','"+phoneno+"','"+url+"','"+password+"')";
		    st.execute(qry);		
			a=1;
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return a;
		
	}
     
    public static int enterNewCustomerServiceRequest(String firstname,String lastname,String email,String phoneno,String description)
	{   
		int a=0;
		try
		{   
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			con.setAutoCommit(true);
			String qry="insert into customerservice values ('"+0+"','"+firstname+"','"+lastname+"','"+email+"','"+phoneno+"','"+description+"')";
		    st.execute(qry);		
			a=1;
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return a;
		
	}
    public static int enterNewRequest(String firstname,String lastname,String email,String contactno,String sportname,String countryname,String size)
	{   
		int a=0;
		try
		{   
			Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
			Statement st=con.createStatement();
			con.setAutoCommit(true);
			String qry="insert into request values ('"+0+"','"+firstname+"','"+lastname+"','"+email+"','"+contactno+"','"+sportname+"','"+countryname+"','"+size+"')";
		    st.execute(qry);		
			a=1;
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return a;
		
	}
    public static int enterNewUser(String username, String password)
	{   
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dsn","root","1234@vaibhav");
			Statement st=con.createStatement();
			con.setAutoCommit(true);
			String qry="insert into user values ('"+0+"','"+username+"','"+password+"')";
		    st.execute(qry);
		//	st.executeUpdate("insert into user values(0 , username, password)");
			a=1;
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return a;
		
	}
	public static boolean enterUserName(int userId, String firstName, String lastName)
	{
		Boolean ret=false;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dsn","root","1234@vaibhav");
			Statement st=con.createStatement();
			con.setAutoCommit(true);
			String qry="insert into user_profile values ('"+0+"','"+firstName+"','"+lastName+"')";
		    st.execute(qry);
			
			//st.executeUpdate("insert into user_profile values(0 , firstName, lastName)");
			ret=true;
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;
		
	}
	
	public static boolean isUserNameAvailable(String userName)
	{
		String name="";
		Boolean ret=false;
		int a=0;
		try
		{   Class.forName("com.mysql.jdbc.Driver");
		    Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dsn","root","1234@vaibhav");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from user");
			while(rs.next())
			{
				name=rs.getString("username");
				
				if(userName.equals(name))
				{
					ret=true;
					return ret;
				}
			}
		}
		catch(Exception w)
		{
			System.out.println(w);
		}  
		return ret;			
	}
	public static void DB_Close() throws Throwable 
	{
		try
		{
			if(con!=null)
			{
				con.close();
			}
		}
		catch(SQLException e)
		{
			System.out.println(e);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AuthDAO a=new AuthDAO();
		
	}
}

