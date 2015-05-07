package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;
import model.User;

/**
 * Servlet implementation class UserloginServlet
 */
public class UserloginServlet extends HttpServlet {
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
        User user;
        String msg="";
		String loggedIn="false";			
		int userId = -1;
		HttpSession session;
        
        try
		{
					
		    if(un.length()==0 && pw.length()==0)
			{
			
				msg="Enter the username and password";
				response.sendRedirect("user_login_page.jsp?msg="+msg);
			}
			else if(un.length()==0)
			{
				msg="Enter the username";
				response.sendRedirect("user_login_page.jsp?msg="+msg);
				
			}
			else if(pw.length()==0)
			{
				msg="Enter the password";
				response.sendRedirect("user_login_page.jsp?msg="+msg);
			}	
			else 
			{
				    AuthDAO ado=new AuthDAO();
					userId = ado.checkUserUsernamePassword(un, pw);				
					if(userId == 0)
					{
						msg = "Incorrect Username and password";
						response.sendRedirect("user_login_page.jsp?msg="+msg);
					}
						
					else	
					{		
						user = AuthDAO.getUserById(userId);
						String fname=user.getFirstName();
						String lname=user.getLastName();
						
						session = request.getSession();
						session.setAttribute("loggedIn","true");
						session.setAttribute("user",user);
						//msg = fname + lname;
						response.sendRedirect("user.jsp");
					}
			}
	     
		    try	{
				AuthDAO.DB_Close();
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
		}
        
		catch(NullPointerException e){response.sendRedirect("user_login_page.jsp");} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}

}
