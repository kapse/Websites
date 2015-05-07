<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User SignUp Page</title>
<link rel="stylesheet" href="cssfiles/signup.css">
</head>
<body>
<% 


String msg=(String)request.getParameter("msg");
try{if(msg==null) msg="";}catch(NullPointerException e){response.sendRedirect("user_signup_page.jsp");}
String loggedIn=(String)session.getAttribute("loggedIn");
try{if(loggedIn==null)loggedIn="";}catch(NullPointerException e){response.sendRedirect("user_signup_page.jsp");}

%>
<% if(!loggedIn.equalsIgnoreCase("true")) {%>
<div class="main">
	<div class="topheader">My Account | Cart | <a href="user_login_page.jsp">Login</a></div>
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
			<form name="Signupform" action="usersignup" method="post">
				<table border="0" style="width: 100%">
					<caption><h2>USER SIGNUP PORTAL</h2></caption>
						<tr>
							<th></th>
							<td><% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %></td>
					    </tr>
						<tr>
							<th>Enter UserName</th>
							<td><input type="text" name="username" required></td>
						</tr>
						<tr>
							<th>Click to check user availability</th>
							<td><input type='submit' name='action' value='Check_Availabilty'/></td>
						</tr>
						<tr>
							<th>Enter FirstName</th>
							<td><input type="text" name="firstname"></td>
						</tr>
						<tr>
							<th>Enter MiddleName</th>
							<td><input type="text" name="middlename"></td>
						</tr>
						<tr>
							<th>Enter LastName</th>
							<td><input type="text" name="lastname"></td>
						</tr>
						<tr>
							<th>Enter Email-id</th>
							<td><input type="email" name="emailid"></td>
						</tr>
						<tr>
							<th>Enter Address</th>
							<td><input type="text" name="address"></td>
						</tr>
						<tr>
							<th>Enter Phone Number</th>
							<td><input type="tel" name="phoneno"></td>
						</tr>
						<tr>
							<th>Password</th>
							<td><input type="password" name="psd"></td>
						</tr>
						<tr>
							<th>Confirm Password</th>
							<td><input type="password" name="cnfpsd"></td>
						</tr>
						<tr>
							<th>Click button to Sign up</th>
							<td><input type='submit' name='action' value='Sign_up'/></td>
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
 
	 
	  <form name="Signup" action="user.jsp" method="get">
			<table border="0" style="width: 100%">
			
				<tr>
					<th>You(user) are already a member please Click to move your main page :</th>
					<td><button type="submit">My LoggedIn Page</button></td>
				</tr>		
			</table>
		</form> 
	  
 <%} %>
</body>
</html>