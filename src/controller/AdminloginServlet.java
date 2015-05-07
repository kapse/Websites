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
import model.User;

/**
 * Servlet implementation class AdminloginServlet
 */
public class AdminloginServlet extends HttpServlet {
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
		String pw=request.getParameter("password");
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        Admin admin;
        String msg="";
		String loggedIn="false";			
		int adminId = -1;
		HttpSession session;
        
        try
		{
					
		    if(un.length()==0 && pw.length()==0)
			{
			
				msg="Enter the username and password";
				response.sendRedirect("admin_login_page.jsp?msg="+msg);
			}
			else if(un.length()==0)
			{
				msg="Enter the username";
				response.sendRedirect("admin_login_page.jsp?msg="+msg);
				
			}
			else if(pw.length()==0)
			{
				msg="Enter the password";
				response.sendRedirect("admin_login_page.jsp?msg="+msg);
			}	
			else 
			{
				    AuthDAO ado=new AuthDAO();
				    adminId = ado.checkAdminUserPass(un, pw);				
					if(adminId == 0)
					{
						msg = "Incorrect Username and password";
						response.sendRedirect("admin_login_page.jsp?msg="+msg);
					}
						
					else	
					{		
						admin = AuthDAO.getAdminById(adminId);
						String fname=admin.getFirstName();
						String lname=admin.getLastName();
						
						session = request.getSession();
						session.setAttribute("loggedIn","true");
						session.setAttribute("admin",admin);
						//msg = fname + lname;
						response.sendRedirect("admin.jsp");
					}
			}
	     
		    try	{
				AuthDAO.DB_Close();
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
		}
        
		catch(NullPointerException e){response.sendRedirect("admin_login_page.jsp");} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}

}

