package com.cojas.CMS.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.CMS.dao.admin.AdminVendorImpl;
import com.ojas.CMS.model.Vendor;

/**
 * Servlet implementation class ViewAdminVenderController
 */
@WebServlet("/viewvendor")
public class ViewAdminVenderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewAdminVenderController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	           
//		   PrintWriter writer = response.getWriter();
//		   response.setContentType("text/html");
//		    int vid=Integer.parseInt(request.getParameter("vid"));
//		    AdminVendorImpl dao=new AdminVendorImpl();
//		    Vendor viewvendor = dao.viewvendor(vid);
//		    
//		       writer.println("<p> Vendor id:"+viewvendor.getVid()+"<br>"+
//		    		   
//		    		          " vendor name"+viewvendor.getVname()+"<br>  email "+viewvendor.getEmail()+"<br> Contact No:"+viewvendor.getMob()+"<br> Address:"
//		    		          		+ viewvendor.getAdress());
		       
		      
//		                 RequestDispatcher rd=request.getRequestDispatcher("./3_admin_view");
//		                 rd.include(request, response);
		       
		       
		   	PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			System.out.println(request.getParameter("vid"));
			int vendorId =Integer.parseInt( request.getParameter("vid"));
			System.out.println("==========>"+vendorId);
			AdminVendorImpl dao = new AdminVendorImpl();
			Vendor v = dao.viewvendor(vendorId);
			out.println("Vendor Id  : "+v.getVid()+"<br>");
			out.println("Vendor Name  : "+v.getVname()+"<br>");
			out.println("Vendor Email  : "+v.getEmail()+"<br>");
			out.println("Vendor Mobile  : "+v.getMob()+"<br>");
			out.println("Vendor Address  : "+v.getAdress()+"<br>");	       
		       

	}

}
