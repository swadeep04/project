package com.cojas.CMS.Controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ojas.CMS.dao.LoginDaoImpl;



/**
 * Servlet implementation class ForgotController
 */
@WebServlet("/forgot")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		String uname = request.getParameter("uname");
		String type = request.getParameter("pwd");
		LoginDaoImpl dao = new LoginDaoImpl();
		String pwd = dao.forgotPassword(uname, type);
		System.out.println(pwd);
		if(!pwd.equals(null)) {
		out.println("Have you forgot the Password : " + pwd);
		RequestDispatcher rd = request.getRequestDispatcher("./0_index.html");
		rd.include(request, response);
		}else {
			out.println("Invalid Username / Type. Please try again....");
			RequestDispatcher rd = request.getRequestDispatcher("./forgot.html");
			rd.include(request, response);
		}
	}

}
