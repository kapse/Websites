<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.Admin" %>
    <%@ page import="model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="cssfiles/update_product.css">
</head>
<body>
<%	
	Admin admin =  (Admin)session.getAttribute("admin");
	if(admin == null) admin = new Admin();
    
	String loggedIn = (String) session.getAttribute("loggedIn");
	if(loggedIn == null) loggedIn = "";
	
	String msg = (String) request.getParameter("msg");
	if(msg == null) msg = "";
   
	String show = (String) request.getParameter("show");
	if(show == null) show = "";
%>	
<% if(!loggedIn.equals("true")) {%>
 <form name="Signup" action="admin_login_page.jsp" method="get">
			<table border="0" style="width: 50%">			
				<tr>
					<th>You(seller) are not logged in please click to Login :</th>
					<td><button type="submit">Seller Login Window</button></td>
				</tr>		
			</table>
		</form> 
 <%} %>
 <% if(loggedIn.equals("true")) {%>
<div class="main">
	<div class="topheader"><% out.println("<font size='3' color=red>" + "Welcome " + admin.getFirstName()+" "+ admin.getLastName()+"</font>");
    %> | <form name="Signup" action="logout" method="post">
			<button type="submit">Logout</button></form> </div>
	<div class="header">
	<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>     
  			 <% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %> 
   			</tr>
		</table>  
	</div>
	<div class="section">
			<form name="Signupform" action="seller" method="post">
				<table border="0" style="width: 100%;height:100%">
					<caption><h3>MENU</h2></caption>
						<tr><td><a href="admin_list_product.jsp" >List Products</a></td></tr>
						<tr><td><a href="admin_update_product.jsp" >Update Products</a></td></tr>
						<tr><td><a href="admin_view_order.jsp" >View Order</a></td></tr>
						<tr><td><a href="update_order.jsp" >Update Order</a></td></tr>
						<tr><td><a href="seller_contact_buyer.jsp" >Contact Buyers</a></td></tr>
						<tr><td><a href="seller_notification.jsp" >Notification</a></td></tr>
						<tr><td><a href="view_my_account.jsp">View Account</a></td></tr>
						<tr><td><a href="update_my_account.jsp">Update Account</a></td></tr>	
						
				</table>
		</form> 				
	</div>
	<div class="aside">
		<% int id=admin.getAdminId(); %>
				<%@ page import = "java.sql.*" %>
				  	<%
				  	try {
				  		Class.forName("com.mysql.jdbc.Driver");	   
						//System.out.println("Driver found");
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
				  	Connection con = null;    
				    PreparedStatement ps = null;    
				    ResultSet rs = null;
					    
					    try {
					    	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/store","root","1234@vaibhav");
						} 
					    catch (SQLException e) {
							
							e.printStackTrace();
						}
					    try {
					    	Statement st = con.createStatement();
					    	rs=st.executeQuery("select * from product ");
							%>
							<table border="1" style="width: 100%">
					        <caption><h3>Product List</h3></caption>
					        <tr>
					        <td><input type="text" size="2" name="p_id" value="P_id" readonly></td>
							<td><input type="text" name="p_name" value="Product Name " readonly></td>
							<td> <input type="text" name="price" value="Price" readonly> </td>
							<td> <input type="text" size="2" name="p_size" value="Size" readonly></td>
							<td> <input type="text" name="p_desc" value="Product Description" readonly></td>													
					        </tr>
					        </table>
							<%
							
							
							while (rs.next()) { %>
							<form name="Signupform" action="adminupdateproduct" method="post">
							<table border="0" style="width: 100%">	
							<tr> <td><input type="text" size="2" name="p_id" value="<%=rs.getInt("p_id") %>" readonly></td>
							<td><input type="text" name="p_name" value="<%=rs.getString("p_name") %>" ></td>
							<td> <input type="text" name="price" value="<%=rs.getString("price") %>" > </td>
							<td> <input type="text" size="2" name="p_size" value="<%=rs.getString("p_size") %>" ></td>
							<td> <input type="text" name="p_desc" value="<%=rs.getString("p_desc") %>" ></td>
							<td><input type='submit' name='action' value='UPDATE'/></td>
							<td><input type='submit' name='action' value='REMOVE'/></td>
							</tr>
							</table>
							</form>											
								
							<%}
							rs.close();
							st.close();
							con.close();
					    }
					    		
					    
					    
					    catch (SQLException e) {
							
							e.printStackTrace();
			    		 }				   %>
			    		 
		
	</div>
	<div class="footer">
		 <a href="contact.jsp">Contact Us</a>
        <a href="customerservice.jsp">Customer Service</a>
        <a href="seller_login_page.jsp">Seller Login</a>
        <a href="seller_signup_page.jsp">Seller Registration</a><br>
            @2015 Online T-Shirt Store 
	</div>
</div>
<%} %>
</body>
</html>