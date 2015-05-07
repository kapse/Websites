<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="model.Seller" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>View My Account Page</title>
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
  			 <% out.println("<font size='3' color=red align=center> "+msg+"</font>"); %> 
   			</tr>
		</table>  
	</div>
	<div class="section">
			<form name="Signupform" action="seller" method="post">
				<table border="0" style="width: 100%;height:100%">
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
		<form name="Signupform" action="sellerprofileinfo" method="post">
				<table border="0" style="width: 100%">
					<caption><h2>Update Profile Information</h2></caption>
					
						<tr>
							<th class="mainth">Username</th>
							<td class="maintd"><input type="text" name="username" value="<% out.println(seller.getUserName()); %>" readonly></td>
						</tr>						
						<tr>
							<th class="mainth">Company Name</th>
							<td class="maintd"><input type="text" name="companyname" value="<% out.println(seller.getCompanyName()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">FirstName</th>
							<td class="maintd"><input type="text" name="firstname" value="<% out.println(seller.getFirstName()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">MiddleName</th>
						    <td class="maintd"><input type="text" name="middlename" value="<% out.println(seller.getMiddleName()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">LastName</th>
							<td class="maintd"><input type="text" name="lastname" value="<% out.println(seller.getLastName()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">Email-id</th>
							<td class="maintd"><input type="text" name="email" value="<% out.println(seller.getEmail()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">Address</th>
							<td class="maintd"><input type="text" name="address" value="<% out.println(seller.getAddress()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">Bank Name</th>
							<td class="maintd"><input type="text" name="bank_name" value="<% out.println(seller.getBankName()); %>"></td>
						</tr>		
						<tr>
							<th class="mainth">Branch Name</th>
							<td class="maintd"><input type="text" name="branch_name" value="<% out.println(seller.getBranchName()); %>"></td>
						</tr>				
						<tr>
							<th class="mainth">Account Number</th>
							<td class="maintd"><input type="text" name="account_number" value="<% out.println(seller.getAccountNumber()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">Routing Number</th>
							<td class="maintd"><input type="text" name="routing_number" value="<% out.println(seller.getRoutingNumber()); %>"></td>
						</tr>			
						
						<tr>
							<th class="mainth">Phone Number</th>
							<td class="maintd"><input type="tel" name="phoneno" value="<% out.println(seller.getPhoneno()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">URL</th>
							<td class="maintd"><input type="text" name="url" value="<% out.println(seller.geturl()); %>"></td>
						</tr>
						<tr>
							<th class="mainth">Password</th>
							<td class="maintd"><input type="text" name="psd" value="<% out.println(seller.getPassword()); %>"></td>
						</tr>	
						
						<tr>
							<td class="maintd"><input type='submit' name='action' value='Update_Information'/></td>
							<td class="maintd"><input type='submit' name='action' value='Close_Account'/></td>
						</tr>		
						
						
				</table>
				</form>
		
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