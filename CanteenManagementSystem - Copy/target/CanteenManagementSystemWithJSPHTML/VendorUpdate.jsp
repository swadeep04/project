<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<%@page import="com.ojas.CMS.db.DBUtility,java.sql.*"%>
<% 

int id=Integer.parseInt(request.getParameter("vid"));
String name=request.getParameter("vname");
String email=request.getParameter("email");
long mobile=Long.parseLong(request.getParameter("mobile"));
String address=request.getParameter("address");




try{
out.println("enter");
Connection con1=DBUtility.getConnection();



PreparedStatement ps= con1.prepareStatement("UPDATE cms.vendor SET vname =?, email =?, mobilenumber=?, address=? WHERE vid=?");



ps.setString(1,name);
ps.setString(2,email);
ps.setLong(3,mobile);
ps.setString(4,address);
ps.setInt(5,id);
int n = ps.executeUpdate();
if(n!=0)
{

out.print("<br> inserted");
}
else
{
out.print("<br> not inserted");
}
}
catch(Exception e)
{

}
%>