<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="model.Seller" %>
    <%@ page import="model.Product" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="cssfiles/list_product.css">
</head>
<body>
<%	
    Seller seller =  (Seller)session.getAttribute("seller");
    if(seller == null) seller = new Seller();
    
	String loggedIn = (String) session.getAttribute("loggedIn");
	if(loggedIn == null) loggedIn = "";
	
	String msg = (String) request.getParameter("msg");
	if(msg == null) msg = "";
	
	
   
	String show = (String) request.getParameter("show");
	if(show == null) show = "";
%>	
<% if(!loggedIn.equals("true")) {%>
 <form name="Signup" action="seller_login_page.jsp" method="get">
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
	<div class="topheader"><% out.println("<font size='3' color=red>" + "Welcome " + seller.getFirstName()+" "+ seller.getLastName()+"</font>");
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
				<table class="vieworder" border="0" style="width: 100%;height:100%">
					<caption><h3>MENU</h2></caption>
						<tr><td><a href="list_product.jsp" >List Products</a></td></tr>
						<tr><td><a href="update_product.jsp" >Update Products</a></td></tr>
						<tr><td><a href="seller_view_order.jsp" >View Order</a></td></tr>
						<tr><td><a href="update_order.jsp" >Update Order</a></td></tr>
						<tr><td><a href="seller_contact_buyer.jsp" >Contact Buyers</a></td></tr>
						<tr><td><a href="seller_notification.jsp" >Notification</a></td></tr>
						<tr><td><a href="view_my_account.jsp">View Account</a></td></tr>
						<tr><td><a href="update_my_account.jsp">Update Account</a></td></tr>	
						
				</table>
		</form> 				
	</div>
	<div class="aside">
	<% int id=seller.getSellerId(); %>
		     
		      
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
					    	String sql="SELECT orderr.order_id,orderr.shipping_address,orderr.order_status,orderr.quantity,buyer.firstname,buyer.lastname,buyer.phoneno,buyer.email,product.p_id,product.p_name,product.p_desc,product.p_size FROM orderr,buyer,product WHERE orderr.sellerId='"+id+"' AND orderr.userId=buyer.userId AND orderr.p_id=product.p_id";					//    	String sql = "select * from seller where username='"+uname+"'";			
					//		ResultSet rs=st.executeQuery(sql);
					    	rs=st.executeQuery(sql);
							%>
							<table border="1" style="width: 100%">
					        <caption><h3>Order List</h3></caption>
					        <tr>
							<th>P_Id</th>
							<th>Product Name</th>
							<th>Product description</th>
							<th>size</th>
							<th>qty</th>
							<th>Buyer First Name</th>
							<th>Buyer last name</th>
							<th>shipping address</th>
							<th>mo.</th>
							<th>email</th>
							<th>Order status</th>							
					        </tr>
							<%
							
							
							while (rs.next()) { %>
							<tr><td> <%=rs.getInt("p_id") %></td>
							<td> <%=rs.getString("p_name") %></td>
							<td> <%=rs.getString("p_desc") %></td>
							<td> <%=rs.getString("p_size") %></td>	
							<td> <%=rs.getInt("quantity") %></td>
							<td> <%=rs.getString("firstname") %></td>
							<td> <%=rs.getString("lastname") %></td> 
							<td> <%=rs.getString("shipping_address") %></td>
							<td> <%=rs.getString("phoneno") %></td>
							<td> <%=rs.getString("email") %></td>
							<td> <%=rs.getString("order_status") %></td>												
							</tr>											
								
							<%}
							rs.close();
							st.close();
							con.close();
					    }
					    		
					    
					    
					    catch (SQLException e) {
							
							e.printStackTrace();
			    		 }				   %>
			    		 </table>
		
	</div>
	<div class="footer">
		 <a href="index.jsp">Contact Us</a>
        <a href="customerservice.jsp">Customer Service</a>
        <a href="seller_login_page.jsp">Seller Login</a>
        <a href="seller_signup_page.jsp">Seller Registration</a><br>
            @2015 Online T-Shirt Store 
	</div>
</div>
<%} %>
</body>
</html>