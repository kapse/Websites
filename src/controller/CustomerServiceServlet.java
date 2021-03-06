package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Admin;
import model.AuthDAO;
import model.Seller;
import model.User;

/**
 * Servlet implementation class CustomerServiceServlet
 */
public class CustomerServiceServlet extends HttpServlet {
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
		String fn=request.getParameter("firstname");
		String ln=request.getParameter("lastname");
		String email=request.getParameter("emailid");
		String mo=request.getParameter("contactno");
		String desc=request.getParameter("comment");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        User user;
        Seller seller;
        Admin admin;
        String msg="";
		String loggedIn="false";			
		int userId = -1;
		HttpSession session;
        
        try
		{
					
		    if(fn.length()==0 || ln.length()==0 || email.length()==0 || mo.length()==0 || desc.length()==0)
			{
			
				msg="Fill the complete form";
				response.sendRedirect("customerservice.jsp?msg="+msg);
			}			
			else 
			{
				userId=AuthDAO.enterNewCustomerServiceRequest(fn,ln,email,mo,desc);
				if(userId>0 )
				{
					String msg1="Request submitted successfully";
					response.sendRedirect("customerservice.jsp?msg="+msg1);
				}
			}
	     
		    try	{
				AuthDAO.DB_Close();
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
		}
        
		catch(NullPointerException e){response.sendRedirect("customerservice.jsp");} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}

}