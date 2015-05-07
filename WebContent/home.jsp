<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Online T-Shirt Store</title>
<link rel="stylesheet" href="cssfiles/main.css">
</head>
<body>
<% 
 	 String msg=(String)request.getParameter("msg");
 	 try{if(msg==null) msg="";}catch(NullPointerException e){response.sendRedirect("user_login_page.jsp");}
  	 
   	 String loggedIn=(String)session.getAttribute("loggedIn");
 	 try{if(loggedIn==null)loggedIn="";}catch(NullPointerException e){response.sendRedirect("user_login_page.jsp");}
  %>
<div class="main">
	<div class="topheader"><% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %> | My Account | Cart | <a href="user_login_page.jsp">Login</a></div>
	<div class="header">
	<img alt="store logo" src="images/logo.png" height="150px" width="1006px">
	</div>
	<div class="nav">
		<table border="0" style="width:100%;height:100%;align:center">
  			 <tr>
   					<td><a href="home.jsp">Home</a></td>
   					<td><a href="boxingpage.jsp" target="iframe_a">Offers</a> </td>
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
			<table border="0" style="width:100%;height:100%;align:center">
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
        <a href="seller_login_page.jsp">Seller Login</a>
        <a href="seller_signup_page.jsp">Seller Registration</a>
        <a href="admin_login_page.jsp">Admin</a>
        <form name="Signup" action="request.jsp" method="get">
			<table border="0" style="width: 100%">			
				<tr>					
					<td><button type="submit">Request New T-shirt</button></td>
				</tr>		
			</table>
		</form> <br>
        @2015 Online T-Shirt Store
	</div>
</div>
</body>
</html>