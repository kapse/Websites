<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="model.User" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Page</title>
<link rel="stylesheet" href="cssfiles/user.css">
</head>
<body>
<%
	
    User user =  (User)session.getAttribute("user");
    if(user == null) user = new User();
    
	String loggedIn = (String) session.getAttribute("loggedIn");
	if(loggedIn == null) loggedIn = "";
	
	String msg = (String) request.getParameter("msg");
	if(msg == null) msg = "";
   
	String show = (String) request.getParameter("show");
	if(show == null) show = "";
%>	
<% if(!loggedIn.equals("true")) {%>
<form name="Signup" action="user_login_page.jsp" method="get">
			<table border="0" style="width: 50%">
			
				<tr>
					<th>You(user) are not logged in please click to Login :</th>
					<td><button type="submit">User Login Window</button></td>
				</tr>		
			</table>
		</form> 
 
 <%} %>
 <% if(loggedIn.equals("true")) {%>
<div class="main">	
	<div class="topheader"><% out.println("<font size='3' color=red>" + "Welcome " + user.getFirstName()+" "+ user.getLastName()+"</font>");
    %> | Cart | <form name="Signup" action="logout" method="post">
			<button type="submit">Logout</button></form>
	</div>
	<div class="header">
	<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>
   					<td><a href="user.jsp">Home</a></td>
   					<td><a href="boxingpage.jsp" target="iframe_a">Offers</a> </td>
   					<td><a href="user_signup_page.jsp">Register</a></td>
   					<td><a href="user_login_page.jsp">Login</a></td>
   					<td><a href="index.jsp">Contact</a></td>   					
   					<td><form class="form-wrapper cf">
       					 <input type="text" placeholder="Search here..." >
        				 <button type="submit">Search</button></form> 
        			</td>        			
   			</tr>
		</table>  
	</div>
	<div class="section">
			<table border="0" style="width:100%;height:100%">
				<tr><td><B>CATEGORY</B></td></tr>
				<tr><td><a href="cricketpage.jsp" target="iframe_a">Cricket</a></td></tr>
				<tr><td><a href="footballpage.jsp" target="iframe_a">Football</a></td></tr>
				<tr><td><a href="hockeypage.jsp" target="iframe_a">Hockey</a></td></tr>
				<tr><td><a href="basketballpage.jsp" target="iframe_a">Basketball</a></td></tr>
				<tr><td><a href="volleyballpage.jsp" target="iframe_a">Volleyball</a></td></tr>
				<tr><td><a href="tennispage.jsp" target="iframe_a">Tennis</a></td></tr>
				<tr><td><a href="boxingpage.jsp" target="iframe_a">Boxing</a></td></tr>
			</table>			
	</div>
	<div class="aside">
		<iframe border="0" width="830px" height="1050px" src="cricketpage.jsp" name="iframe_a"></iframe>
	</div>
	<div class="footer">
		 <a href="home.jsp">Home</a>
        <a href="boxingpage.jsp" target="iframe_a">Offers</a>
        <a href="user_signup_page.jsp">Register</a>
        <a href="user_login_page.jsp">Login</a>
        <a href="contact.jsp">Contact Us</a>
        <a href="customerservice.jsp">Customer Service</a>
        <form class="form-wrapper cf">
	     	 <button type="submit">Click here to request new T-shirt</button>
	    </form><br>
        @2015 Online T-Shirt Store
	</div>
</div>
 <%} %>
</body>
</html>