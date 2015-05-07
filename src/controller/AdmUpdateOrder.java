package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.AuthDAO;

/**
 * Servlet implementation class AdmUpdateOrder
 */
public class AdmUpdateOrder extends HttpServlet {
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
		int order_id=Integer.parseInt(request.getParameter("order_id"));
		String order_status=request.getParameter("order_status");					
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String msg11="";
        int userId=-1;
        
		try
		{
			String action=request.getParameter("action");
			
			if("UPDATE".equals(action))
			{
				if(AuthDAO.updateOrder(order_id,order_status)==true)
				{
					msg11 = "Order updated successfully";
					response.sendRedirect("admin.jsp?msg="+msg11);
				}
				
			}
			else if("DELETE".equals(action))
			{
				if(AuthDAO.deleteOrder(order_id)==true)
				{						
					String msg="Order deleted successfully";
					response.sendRedirect("admin.jsp?msg="+msg);
				}
				
			}
			
			 try	{
					AuthDAO.DB_Close();
					}
					catch (Throwable e) {
						e.printStackTrace();
					}
		
		}
		catch(NullPointerException e){response.sendRedirect("admin.jsp");}
		finally
		{
			out.close();
		}
	}

}
