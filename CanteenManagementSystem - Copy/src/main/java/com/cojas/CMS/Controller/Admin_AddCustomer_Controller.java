package com.cojas.CMS.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.CMS.dao.admin.AdminCustomerdaoImpl;
import com.ojas.CMS.dao.admin.AdminVendorImpl;

/**
 * Servlet implementation class Admin_AddCustomer_Controller
 */
@WebServlet("/AddCustomer")
public class Admin_AddCustomer_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Admin_AddCustomer_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out =response.getWriter();
		response.setContentType("text/html");
		
		String vendorName = request.getParameter("c_name");
		long vendorMobile = Long.parseLong(request.getParameter("c_mobilenumber"));
		String address = request.getParameter("c_address");
		String Wallet = request.getParameter("c_wallet");
		int rid = Integer.parseInt(request.getParameter("rid"));
		AdminCustomerdaoImpl adminDAO = new AdminCustomerdaoImpl();
		String message = adminDAO.addCustomer(vendorName, vendorMobile, address, Wallet, rid);
		out.println(message);
		RequestDispatcher rd = request.getRequestDispatcher("./4_admin_addcustomer.html");
		rd.include(request,response);
	}

}
