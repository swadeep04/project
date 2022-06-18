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
 * Servlet implementation class UpdateAdminVendorController
 */
@WebServlet("/updatevendor")
public class UpdateAdminVendorController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public UpdateAdminVendorController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		PrintWriter writer = response.getWriter();
		response.setContentType("text/html");

		Connection con = null;

		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","root");

			PreparedStatement ps = con.prepareStatement("update vendor set vname=?, mail=?,mob=?,addrss=?  where vid=?;");
			System.out.println(ps);
			ps.setString(1, request.getParameter("vname"));
			ps.setString(2, request.getParameter("mail"));
			ps.setLong(3, Long.parseLong(request.getParameter("mob")));
			ps.setString(4, request.getParameter("address"));
			ps.setInt(5, Integer.parseInt(request.getParameter("vid")));
			System.out.println(ps);
			int result = ps.executeUpdate();
		    System.out.println(result);
			if (result != 0)
				writer.println(" record updated");
			else
				writer.println("record not updated");

			RequestDispatcher rd = request.getRequestDispatcher("./updatevendor.jsp");
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
