package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;
import model.Seller;
import model.User;

/**
 * Servlet implementation class SellerloginServlet
 */
public class SellerloginServlet extends HttpServlet {
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
        Seller seller;
        String msg="";
		String loggedIn="false";			
		int sellerId = -1;
		HttpSession session;
        
        try
		{
					
		    if(un.length()==0 && pw.length()==0)
			{
			
				msg="Enter the username and password";
				response.sendRedirect("seller_login_page.jsp?msg="+msg);
			}
			else if(un.length()==0)
			{
				msg="Enter the username";
				response.sendRedirect("seller_login_page.jsp?msg="+msg);
				
			}
			else if(pw.length()==0)
			{
				msg="Enter the password";
				response.sendRedirect("seller_login_page.jsp?msg="+msg);
			}	
			else 
			{
				    AuthDAO ado=new AuthDAO();
					sellerId = ado.checkSellerUserPass(un, pw);				
					if(sellerId == 0)
					{
						msg = "Incorrect Username and password";
						response.sendRedirect("seller_login_page.jsp?msg="+msg);
					}
						
					else	
					{		
						seller = AuthDAO.getSellerById(sellerId);
						String fname=seller.getFirstName();
						String lname=seller.getLastName();
						String uname=seller.getUserName();
						int s_Id=AuthDAO.getSellerId(uname);
						System.out.println(s_Id);
						System.out.println("servlet checking");
						System.out.println(fname);
						System.out.println(lname);
						request.setAttribute("sellerId", "s_Id");
						session = request.getSession();
						session.setAttribute("loggedIn","true");
						session.setAttribute("seller",seller);
						response.sendRedirect("seller.jsp?s_Id="+s_Id);
					}
			}
	     
		    try	{
				AuthDAO.DB_Close();
				}
				catch (Throwable e) {
					e.printStackTrace();
				}
		}
        
		catch(NullPointerException e){response.sendRedirect("seller_login_page.jsp");} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			out.close();
		}
	}

}
