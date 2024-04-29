<%@page import="Model.Message"%>
<%@page import="Controller.UserController"%>
<%@page errorPage="error_exception.jsp"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%
Admin activeAdmin = (Admin) session.getAttribute("activeAdmin");
if (activeAdmin == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("adminlogin.jsp");
	return;
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View User's</title>
<%@include file="Components/common_css_js.jsp"%>
</head>
<body>
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>

	<div class="container-fluid px-5 py-3">
		<table class="table table-hover">
			<tr class="text-center table-primary" style="font-size: 18px;">
				<th>User Name</th>
				<th>Email</th>
				<th>Phone No.</th>
				<th>Gender</th>
				<th>Address</th>
				<th>Action</th>
			</tr>
			<%
			UserController userController = new UserController(DB_Connection.getConnection());
			List<User> userList = userController.getAllUser();
			for (User u : userList) {
			%>
			<tr>
				<td><%=u.getName()%></td>
				<td><%=u.getEmail()%></td>
				<td><%=u.getPhone_Number()%></td>
				<td><%=u.getGender()%></td>
				<td><%=userController.getUserAddress(u.getUser_Id())%></td>
				<td><a href="UpdateUserServlet?operation=deleteUser&uid=<%=u.getUser_Id()%>" role="button" class="btn btn-danger">Remove</a></td>
			</tr>
			<%
			}
			%>
		</table>
	</div>
</body>
</html>