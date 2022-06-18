
<!-- BOOTSTRAP STYLES-->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

<!-- Optional theme -->
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap-theme.min.css" integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp" crossorigin="anonymous">

<!-- Latest compiled and minified JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>




<!-- GOOGLE FONTS-->
<link href='http://fonts.googleapis.com/css?family=Open+Sans'
rel='stylesheet' type='text/css' />
<%@page import="com.ojas.CMS.db.*,javax.servlet.*" %>





<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" import="java.sql.*"%>





<%!ResultSet rs = null;%>

<%
Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306","root","root");
PreparedStatement ps = con.prepareStatement("SELECT * FROM cms.customer");
rs = ps.executeQuery();
ResultSetMetaData rsmd = rs.getMetaData();

%>

<table class="table table-striped">
<thead>
<tr>
<th><%out.print(rsmd.getColumnName(1)); %></th>
<th><%out .print(rsmd.getColumnName(2)); %></th>
<th><%out.print(rsmd.getColumnName(3)); %></th>
<th><%out.println(rsmd.getColumnName(4)); %></th>
<th><%out.println(rsmd.getColumnName(5)); %></th>
<th><%out.println(rsmd.getColumnName(6)); %></th>





</tr>
</thead>
<tbody>
<%
while (rs.next()) {
%>
<tr>
<td><% out.println(rs.getInt(1)); %></td>
<td><% out.println(rs.getString(2)); %></td>
<td><% out.println(rs.getLong(3)); %></td>
<td><% out.println(rs.getString(4)); %></td>
<td><% out.println(rs.getString(5)); %></td>
<td><% out.println(rs.getInt(6)); %></td>



<td>
<a class="btn btn-primary" href=./UpdateCustomer.jsp?vid=<%=rs.getInt(1) %>>Update</a>
<a class="btn btn-danger" href=./deletedistributor.jsp?vid=<%=rs.getInt(1) %>>Delete</a>
</td>
</tr>
<%
}
%>
</tbody>
</table>