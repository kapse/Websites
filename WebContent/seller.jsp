<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Seller" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Seller Page</title>
<link rel="stylesheet" href="cssfiles/seller.css">
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
  			 <% out.println("<font size='3' color=red>" + " " + msg+"</font>"); %> 	
  			 		 
   			</tr>
		</table>  
	</div>
	<div class="section">
			<form name="Signupform" action="seller" method="post">
				<table border="0" style="width: 100%;height:100%">
					<caption><h3>MENU</h2></caption>
						<tr><td><a href="list_product.jsp" >List Products</a></td></tr>
						<tr><td><a href="admin_update_product.jsp" >Update Products</a></td></tr>
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