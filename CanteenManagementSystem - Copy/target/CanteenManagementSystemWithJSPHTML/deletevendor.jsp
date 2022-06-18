<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<%@page import="com.ojas.CMS.db.DBUtility,java.sql.*"%>
<%
int vid = Integer.parseInt(request.getParameter("vid"));
System.out.println("vid="+vid);
 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/cms","root","root");
 System.out.println("con="+con);
   PreparedStatement ps=con.prepareStatement("delete from vendor where vid=?");
   ps.setInt(1, vid);
   System.out.println(ps);
    ps.executeUpdate();

   RequestDispatcher rd=request.getRequestDispatcher("./viewAllVendor.jsp");
   rd.include(request, response);
 
%>