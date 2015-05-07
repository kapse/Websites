<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.Admin" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Page</title>
<link rel="stylesheet" href="cssfiles/admin.css">
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
					<th>You(admin) are not logged in please click to Login :</th>
					<td><button type="submit">Admin Login Window</button></td>
				</tr>		
			</table>
		</form> 
 <%} %>
 <% if(loggedIn.equals("true")) {%>
<div class="main">
	<div class="topheader"><% out.println("<font size='3' color=red>" + "Welcome " + admin.getFirstName()+" "+ admin.getLastName()+"</font>");
    %> | <form name="Signup" action="logout" method="post">
			<button type="submit">Logout</button></form></div>
	<div class="header">
	<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>
   						<td><% out.println("<font size='3' color=red>" + " " + msg+"</font>"); %> </td>				
   					<td><form class="form-wrapper cf">
       					 <input type="text" placeholder="Search here..." >
        				 <button type="submit">Search</button></form> 
        			</td>
        			
   			</tr>
		</table>  
	</div>
	<div class="section">
			<form name="Signupform" action="admin" method="post">
				<table border="0" style="width: 100%;height:100%">
					<caption><h3>MENU</h3></caption>					
						<tr><td><a href="admin_list_product.jsp" >List_Products</a></td></tr>
						<tr><td><a href="admin_update_product.jsp" >Update Products</a></td></tr>
						<tr><td><a href="admin_view_order.jsp" >View Order</a></td></tr>
						<tr><td><a href="admin_view_seller.jsp" >View Sellers</a></td></tr>
						<tr><td><a href="admin_contact_seller.jsp" >Contact Sellers</a></td></tr>
						<tr><td><a href="admin_view_buyer.jsp" >View Buyers</a></td></tr>
						<tr><td><a href="admin_contact_buyer.jsp" >Contact Buyers</a></td></tr>
						<tr><td><a href="admin_contact_seller.jsp" >Contact Sellers</a></td></tr>
						<tr><td><a href="seller_notification.jsp" >Notification</a></td></tr>
						<tr><td><a href="admin_update_order.jsp">Update Order</a></td></tr>
						<tr><td><a href="update_my_account.jsp">Update Account</a></td></tr>
						
						<tr>							
							<td><input type='submit' name='action' value='Add_Product'/></td>
						</tr>						
						<tr>
							<td><input type='submit' name='action' value='View_Seller'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='View_Customer'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='View_Order'/></td>
						</tr>							
						<tr>
							<td><input type='submit' name='action' value='Edit_Order'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='Delete_Order'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='Contact_Buyer'/></td>
						</tr>	
						<tr>
							<td><input type='submit' name='action' value='Contact_Seller'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='Notification'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='New_Requests'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='Appr_Seller_Reg'/></td>
						</tr>
						<tr>
							<td><input type='submit' name='action' value='Decl_Seller_Reg'/></td>
						</tr>
						
				</table>
		</form> 			
	</div>
	<div class="aside">
		<iframe border="0" width="830px" height="600px" src="" name="iframe_a"></iframe>
	</div>
	<div class="footer">
		 <a href="home.jsp">Home</a>
         <a href="index.jsp">Contact Us</a>
        <a href="index.jsp">Customer Service</a>
        <a href="admin_login_page.jsp">Admin</a><br>
        @2015 Online T-Shirt Store
	</div>
</div>
  <%} %>
</body>
</html>