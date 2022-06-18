<!-- BOOTSTRAP STYLES-->
<link href="assets/css/bootstrap.css" rel="stylesheet" />
<!-- FONTAWESOME STYLES-->
<link href="assets/css/font-awesome.css" rel="stylesheet" />
<!-- MORRIS CHART STYLES-->
<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
rel='stylesheet' type='text/css' />
<%@page import="com.ojas.CMS.db.*,java.sql.*"%>
<%
int cid1 = Integer.parseInt(request.getParameter("cid"));
Connection con = DBUtility.getConnection();
PreparedStatement ps = con.prepareStatement("select * from customer where cid=?");
ps.setInt(1, cid1);
ResultSet rs = ps.executeQuery();
while (rs.next()) {
out.println("<form action='CustomerUpdate.jsp' method=post>");
out.println("Customer Id : <input type=text name=cid value='" + rs.getInt(1)+"'</input>");
out.println("<br>");
out.println("Customer Name :<input type=text name=cname value='" + rs.getString(2)+"'</input>");
out.println("<br>");
out.println("Customer Mobile No : <input type=text name=mobile value='" + rs.getLong(3)+"'</input>");
out.println("<br>");
out.println("Customer Address : <input type=text name=address value='" + rs.getString(4)+"'</input>");
out.println("<br>");
out.println("Customer Wallet :<input type=text name=wallet value='" + rs.getString(5)+"'</input>");
out.println("<br>");
out.println("Customer RId :<input type=text name=rid value='" + rs.getInt(6)+"'</input>");
out.println("<br>");
out.println("<br>");
out.println("<button class=btn btn-primary>Update</button>");
out.println("</form>");

//int cid = Integer.parseInt(request.getParameter("cid"));

}
 
    
%>

