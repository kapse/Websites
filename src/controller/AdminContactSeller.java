package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;

/**
 * Servlet implementation class AdminContactSeller
 */
public class AdminContactSeller extends HttpServlet {
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
		int admin_id=Integer.parseInt(request.getParameter("admin_id"));
		int seller_id=Integer.parseInt(request.getParameter("seller_id"));	
		String msg=request.getParameter("msg");	
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String msg11="";
        int userId=-1;
        
		try
		{
			String action=request.getParameter("action");
			
			if("SEND".equals(action))
			{
				if(AuthDAO.adminContactSeller(admin_id,seller_id,msg)==true)
				{
					msg11 = "Message sent successfully";
					response.sendRedirect("admin.jsp?msg="+msg11);
				}
				
			}
			
			 try	{
					AuthDAO.DB_Close();
					}
					catch (Throwable e) {
						e.printStackTrace();
					}
		
		}
		catch(NullPointerException e){response.sendRedirect("admin_signup_page.jsp");}
		finally
		{
			out.close();
		}
	}

}