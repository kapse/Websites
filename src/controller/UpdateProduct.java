package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.AuthDAO;
import model.Seller;


/**
 * Servlet implementation class UpdateProduct
 */
public class UpdateProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int p_id=Integer.parseInt(request.getParameter("p_id"));
		String p_name=request.getParameter("p_name");
		String price=request.getParameter("price");
		String p_size=request.getParameter("p_size");
		String p_desc=request.getParameter("p_desc");				
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String msg11="";
        int userId=-1;
        
		try
		{
			String action=request.getParameter("action");
			
			if("UPDATE".equals(action))
			{
				if(AuthDAO.updateSellerProduct(p_id,p_name,price,p_size,p_desc)==true)
				{
					msg11 = "Product updated successfully";
					response.sendRedirect("seller.jsp?msg="+msg11);
				}
				
			}
			else if("REMOVE".equals(action))
			{
				if(AuthDAO.deleteProduct(p_id)==true)
				{						
					String msg="Product deleted successfully";
					response.sendRedirect("seller.jsp?msg="+msg);
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
