<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.User" %> 
    <%@ page import="model.Admin" %> 
    <%@ page import="model.Seller" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Request New Tshirt Page</title>
<link rel="stylesheet" href="cssfiles/customerservice.css">
</head>
<body>
<% 
	 Admin admin =  (Admin)session.getAttribute("admin");
	 if(admin == null) admin = new Admin();
	 
	 User user =  (User)session.getAttribute("user");
	 if(user == null) user = new User();
	 
	 Seller seller =  (Seller)session.getAttribute("seller");
	    if(seller == null) seller = new Seller();

 	 String msg=(String)request.getParameter("msg");
 	 try{if(msg==null) msg="";}catch(NullPointerException e){response.sendRedirect("user_login_page.jsp");}
  	 
   	 String loggedIn=(String)session.getAttribute("loggedIn");
 	 try{if(loggedIn==null)loggedIn="";}catch(NullPointerException e){response.sendRedirect("user_login_page.jsp");}
  %>
 <% if(!loggedIn.equalsIgnoreCase("true")) {%>
<div class="main">
	<div class="topheader">My Account | Cart |<a href="user_login_page.jsp">Login</a></div>
	<div class="header">
		<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>
   					<td><a href="home.jsp">Home</a></td>
   					<td><a href="user_signup_page.jsp">Register</a></td>
   					<td><a href="user_login_page.jsp">Login</a></td>
   					<td><a href="contact.jsp">Contact</a></td>   					
   					<td><form class="form-wrapper cf">
       					 <input type="text" placeholder="Search here..." >
        				 <button type="submit">Search</button></form> 
        			</td>        			
   			</tr>
		</table>  
	</div>
	<div class="section">
			<table border="0" style="width:100%;height:100%">
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
			</table>			
	</div>
	<div class="aside"><br>
			<form name="Loginform" action="request" method="post">
				<table border="0" style="width: 100%">
					<caption><h3>Fill the details to request new Tshirt</h3></caption>
					<tr>
						<th>First Name</th>
						<td><input type="text" name="firstname" required></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><input type="text" name="lastname" required></td>
					</tr>
					<tr>
						<th>Email Address</th>
						<td><input type="email" name="emailid" required></td>
					</tr>
					<tr>
						<th>Contact No</th>
						<td><input type="tel" name="contactno" required></td>
					</tr>
					<tr>
						<th>Sport Name</th>
						<td><input type="text" name="sportname" required></td>
					</tr>
					<tr>
						<th>Country Name</th>
						<td><input type="text" name="countryname" required></td>
					</tr>					
					<tr>
						<th>T-Shirt Size</th>
						<td><input type="text" name="size" required></td>
					</tr>
					<tr>
						<th>Click button to submit request</th>
						<td><input type="submit" value="Log In"></td>
					</tr>
					<tr>
						<th></th>
						<td><% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %></td>
					</tr>							
				</table>
		</form>
	</div>
	<div class="footer">
		 <a href="home.jsp">Home</a>
        <a href="user_signup_page.jsp">Register</a>
        <a href="user_login_page.jsp">Login</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="customerservice.jsp">Customer Service</a>
        <a href="seller_login_page.jsp">Seller Login</a>
        <a href="seller_signup_page.jsp">Seller Registration</a>
        <a href="admin_login_page.jsp">Admin</a>
        <form name="Signup" action="request.jsp" method="get">
			<table border="0" style="width: 100%">			
				<tr>					
					<td><button type="submit">Request New T-shirt</button></td>
				</tr>		
			</table>
		</form><br>
        @2015 Online T-Shirt Store
	</div>
</div>
<%}
	%>
<% if(loggedIn.equalsIgnoreCase("true")) {%>
<div class="main">
	<div class="topheader"><% out.println("<font size='3' color=red>" + "Welcome " + admin.getFirstName()+" "+ admin.getLastName() +" "+ seller.getFirstName()+" "+ seller.getLastName()+" "+ user.getFirstName()+ " "+ user.getLastName()+"</font>");
    %> | <form name="Signup" action="logout" method="post">
			<button type="submit">Logout</button></form></div>
	<div class="header">
		<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>
   					<td><a href="home.jsp">Home</a></td>
   					<td><a href="user_signup_page.jsp">Register</a></td>
   					<td><a href="user_login_page.jsp">Login</a></td>
   					<td><a href="contact.jsp">Contact</a></td>   					
   					<td><form class="form-wrapper cf">
       					 <input type="text" placeholder="Search here..." >
        				 <button type="submit">Search</button></form> 
        			</td>        			
   			</tr>
		</table>  
	</div>
	<div class="section">
			<table border="0" style="width:100%;height:100%">
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
				<tr><td></td></tr>
			</table>			
	</div>
	<div class="aside"><br>
			<form name="Loginform" action="request" method="post">
				<table border="0" style="width: 100%">
					<caption><h3>Fill the details to request new Tshirt</h3></caption>
					<tr>
						<th>First Name</th>
						<td><input type="text" name="firstname" required></td>
					</tr>
					<tr>
						<th>Last Name</th>
						<td><input type="text" name="lastname" required></td>
					</tr>
					<tr>
						<th>Email Address</th>
						<td><input type="email" name="emailid" required></td>
					</tr>
					<tr>
						<th>Contact No</th>
						<td><input type="tel" name="contactno" required></td>
					</tr>
					<tr>
						<th>Sport Name</th>
						<td><input type="text" name="sportname" required></td>
					</tr>
					<tr>
						<th>Country Name</th>
						<td><input type="text" name="countryname" required></td>
					</tr>					
					<tr>
						<th>T-Shirt Size</th>
						<td><input type="text" name="size" required></td>
					</tr>
					<tr>
						<th>Click button to submit request</th>
						<td><input type="submit" value="Log In"></td>
					</tr>
					<tr>
						<th></th>
						<td><% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %></td>
					</tr>							
				</table>
		</form>
	</div>
	<div class="footer">
		 <a href="home.jsp">Home</a>
        <a href="user_signup_page.jsp">Register</a>
        <a href="user_login_page.jsp">Login</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="customerservice.jsp">Customer Service</a>
        <a href="seller_login_page.jsp">Seller Login</a>
        <a href="seller_signup_page.jsp">Seller Registration</a>
        <a href="admin_login_page.jsp">Admin</a>
        <form name="Signup" action="request.jsp" method="get">
			<table border="0" style="width: 100%">			
				<tr>					
					<td><button type="submit">Request New T-shirt</button></td>
				</tr>		
			</table>
		</form><br>
        @2015 Online T-Shirt Store
	</div>
</div>
<%}
	%>
</body>
</html>