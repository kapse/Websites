package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;

/**
 * Servlet implementation class SellerServlet
 */
public class SellerServlet extends HttpServlet {
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
		String fn=request.getParameter("firstname");
		String mn=request.getParameter("firstname");
		String ln=request.getParameter("lastname");
		String email=request.getParameter("emailid");
		String addr=request.getParameter("address");
		String mo=request.getParameter("phoneno");
		String psd=request.getParameter("psd");
		String cnfpsd=request.getParameter("cnfpsd");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String msg11="";
        int userId=-1;
        
		try
		{
			String action=request.getParameter("action");
			
			if("Check_Availabilty".equals(action))
			{
				if(un.length()==0)
				{
					String msg="Enter user name";
					response.sendRedirect("user_signup_page.jsp?msg="+msg);
				}
				else
				{   
					if(AuthDAO.isUserNameAvailable(un)==false)
					{
						msg11 = "User Name "+un+" is available";
						response.sendRedirect("user_signup_page.jsp?msg="+msg11);
					}
					else
					{
				      String msg="User Name "+un+" is not available";
				      response.sendRedirect("user_signup_page.jsp?msg="+msg);
					}
				}
			}
			else if("Sign_up".equals(action))
			{
				if(un.length()==0 || fn.length()==0  || mn.length()==0 || ln.length()==0 || email.length()==0 || addr.length()==0 || mo.length()==0 || psd.length()==0 || cnfpsd.length()==0  )
				{
					String msg="Fill the complete form";
					response.sendRedirect("user_signup_page.jsp?msg="+msg);
				}
				else
				{   
					if(psd.equals(cnfpsd))
					{
						 userId=AuthDAO.enterNewUser(un, psd);
							if(userId>0 && AuthDAO.enterUserName(0, fn, ln)==true)
							{
								String msg1="Signup successful";
								response.sendRedirect("user_login_page.jsp?msg="+msg1);
							}
					}
					else
					{
						String msg="Entered password are not same";
						response.sendRedirect("user_signup_page.jsp?msg="+msg);
					}
				}
				
			}
			 try	{
					AuthDAO.DB_Close();
					}
					catch (Throwable e) {
						e.printStackTrace();
					}
		
		}
		catch(NullPointerException e){response.sendRedirect("user_signup_page.jsp");}
		finally
		{
			out.close();
		}
	}

}
