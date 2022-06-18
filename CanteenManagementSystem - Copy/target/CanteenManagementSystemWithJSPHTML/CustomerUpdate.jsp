<link href="assets/js/morris/morris-0.4.3.min.css" rel="stylesheet" />
<!-- CUSTOM STYLES-->
<link href="assets/css/custom.css" rel="stylesheet" />
<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
	rel='stylesheet' type='text/css' />
<%@page import="com.ojas.CMS.db.DBUtility,java.sql.*"%>
<% 

int id=Integer.parseInt(request.getParameter("cid"));
String name=request.getParameter("cname");
long mobile=Long.parseLong(request.getParameter("mobile"));
String address=request.getParameter("address");
String wallet=request.getParameter("wallet");
int rid=Integer.parseInt(request.getParameter("rid"));




try{
out.println("enter");
Connection con1=DBUtility.getConnection();



PreparedStatement ps= con1.prepareStatement("UPDATE cms.customer SET cname =?, mobilenumber=?, address=?, wallet=?, rid=? WHERE cid=?");



ps.setString(1,name);
ps.setLong(2,mobile);
ps.setString(3,address);
ps.setString(4,wallet);
ps.setInt(5,rid);
ps.setInt(6,id);
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