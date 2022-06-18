package com.cojas.CMS.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.CMS.dao.admin.AdminCustomerdaoImpl;
import com.ojas.CMS.dao.admin.AdminVendorImpl;
import com.ojas.CMS.model.Customer;
import com.ojas.CMS.model.Vendor;

/**
 * Servlet implementation class ViewCustomer_Controller
 */
@WebServlet("/ViewCustomer")
public class ViewCustomer_Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewCustomer_Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 	PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		System.out.println(request.getParameter("c_id"));
		int customerId =Integer.parseInt( request.getParameter("c_id"));
		//System.out.println("==========>"+vendorId);
		AdminCustomerdaoImpl dao = new AdminCustomerdaoImpl();
		Customer c = dao.viewCustomer(customerId);
		out.println("Customer Id  : "+c.getCid()+"<br>");
		out.println("Customer Name  : "+c.getCname()+"<br>");
		out.println("Customer Mobile  : "+c.getMob()+"<br>");
		out.println("Customer Address  : "+c.getAddress()+"<br>");
		out.println("Customer Wallet  : "+c.getWallet()+"<br>");
		out.println("Customer rid  : "+c.getRid()+"<br>");
	       
	}

}
