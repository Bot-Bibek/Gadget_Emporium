<%@page import="Model.Message"%>
<%@page import="Model.User"%>
<%
User user1 = (User) session.getAttribute("activeUser");
if (user1 == null) {
	Message message = new Message("You are not logged in! Login first!!", "error", "alert-danger");
	session.setAttribute("message", message);
	response.sendRedirect("login.jsp");
	return;
}
%>

<style>
label {
	font-weight: bold;
}
</style>
<div class="container px-3 py-3">
	<h3>Personal Information</h3>
	<form id="update-user" action="UpdateUserServlet" method="post">
		<input type="hidden" name="operation" value="updateUser">
		<div class="row">
			<div class="col-md-6 mt-2">
				<label class="form-label">Your name</label> <input type="text"
					name="Name" class="form-control" placeholder="First and last name"
					value="<%=user1.getName()%>">
			</div>
			<div class="col-md-6 mt-2">
				<label class="form-label">Email</label> <input type="email"
					name="Email" placeholder="Email address" class="form-control"
					value="<%=user1.getEmail()%>">
			</div>
		</div>
		<div class="row">
			<div class="col-md-6 mt-2">
				<label class="form-label">Mobile number</label> <input type="text"
					name="Phone" placeholder="Mobile number" class="form-control"
					value="<%=user1.getPhone_Number()%>">
			</div>
			<div class="col-md-6 mt-5">
				<label class="form-label pe-3">Gender</label>
				<%
				String gender = user1.getGender();
				if (gender.trim().equals("Male")) {
				%>
				<input class="form-check-input" type="radio" name="Gender"
					value="Male" checked> <span
					class="form-check-label pe-3 ps-1"> Male </span> <input
					class="form-check-input" type="radio" name="Gender" value="Female">
				<span class="form-check-label ps-1"> Female </span>

				<%
				} else {
				%>
				<input class="form-check-input" type="radio" name="Gender"
					value="Male"> <span class="form-check-label pe-3 ps-1">
					Male </span> <input class="form-check-input" type="radio" name="Gender"
					value="Female" checked> <span class="form-check-label ps-1">
					Female </span>
				<%
				}
				%>

			</div>
		</div>
		<div class="mt-2">
			<label class="form-label">Address</label> <input type="text"
				name="Address" placeholder="Enter Address(Area and Street))"
				class="form-control" value="<%=user1.getAddress()%>">
		</div>
		<div class="row">
			<div class="col-md-6 mt-2">
				<label class="form-label">City</label> <input class="form-control"
					type="text" name="City" placeholder="City/Town"
					value="<%=user1.getCity()%>">
			</div>
			<div class="col-md-6 mt-2">
				<label class="form-label">Postal Code</label> <input
					class="form-control" type="text" name="PostalCode"
					placeholder="Postal Code" maxlength="6"
					value="<%=user1.getPostalcode()%>">
			</div>
		</div>
		<div class="row mt-2">
			<label class="form-label">Province</label> <input
				class="form-control" type="text" name="District"
				placeholder="District" value="<%=user1.getProvince()%>">
		</div>
		<div id="submit-btn" class="container text-center mt-3">
			<button type="submit" class="btn btn-outline-primary me-3">Update</button>
			<button type="reset" class="btn btn-outline-primary">Reset</button>
		</div>
	</form>
</div>

















