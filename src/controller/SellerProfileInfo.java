package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;

/**
 * Servlet implementation class SellerProfileInfo
 */
public class SellerProfileInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String un=request.getParameter("username");
		String cn=request.getParameter("companyname");
		String fn=request.getParameter("firstname");
		String mn=request.getParameter("middlename");
		String ln=request.getParameter("lastname");
		String email=request.getParameter("email");
		String addr=request.getParameter("address");
		String mo=request.getParameter("phoneno");
		String url=request.getParameter("url");
		String psd=request.getParameter("psd");	
		String bank_name=request.getParameter("bank_name");
		String branch_name=request.getParameter("branch_name");
		String account_number=request.getParameter("account_number");
		String routing_number=request.getParameter("routing_number");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String msg11="";
        int userId=-1;
        
		try
		{
			String action=request.getParameter("action");
			
			if("Update_Information".equals(action))
			{
				if(AuthDAO.updateSellerInfo(un,cn,fn,mn,ln,email,addr,mo,url,psd,bank_name,branch_name,account_number,routing_number)==true)
				{
					msg11 = "Information updated successfully";
					response.sendRedirect("seller.jsp?msg="+msg11);
				}
				
			}
			else if("Close_Account".equals(action))
			{
				if(AuthDAO.deleteSellerInfo(un)==true)
				{
					
					HttpSession session=request.getSession();
					// TODO Auto-generated method stub
					session.invalidate();
					String msg="Profile deleted successfully";
					response.sendRedirect("home.jsp?msg="+msg);
				}
				
			}
			 try	{
					AuthDAO.DB_Close();
					}
					catch (Throwable e) {
						e.printStackTrace();
					}
		
		}
		catch(NullPointerException e){response.sendRedirect("seller_signup_page.jsp");}
		finally
		{
			out.close();
		}
	}

}
