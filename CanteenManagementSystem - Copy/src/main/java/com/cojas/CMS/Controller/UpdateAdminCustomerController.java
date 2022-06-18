package com.cojas.CMS.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateAdminCustomerController
 */
@WebServlet("/CustomerUpdate")
public class UpdateAdminCustomerController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateAdminCustomerController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","root");

			PreparedStatement ps = con.prepareStatement("UPDATE cms.customer SET cname =?, mobilenumber=?, address=?, wallet=?, rid=? WHERE cid=?");
			System.out.println(ps);
			ps.setString(1, request.getParameter("cname"));
			ps.setLong(2, Long.parseLong(request.getParameter("mobile")));
			ps.setString(3, request.getParameter("address"));
			ps.setString(4, request.getParameter("wallet"));
			ps.setInt(5, Integer.parseInt(request.getParameter("rid")));
			System.out.println(ps);
			int result = ps.executeUpdate();
		    System.out.println(result);
			if (result != 0)
				writer.println(" record updated");
			else
				writer.println("record not updated");

			RequestDispatcher rd = request.getRequestDispatcher("./UpdateCustomer.jsp");
			rd.include(request, response);
		} catch (NumberFormatException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		} catch (ServletException e) {

			e.printStackTrace();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}



	}


