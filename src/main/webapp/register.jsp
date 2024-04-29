<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registration</title>
<%@include file="Components/common_css_js.jsp"%>
<style>
label {
	font-weight: bold;
}
</style>
</head>
<body>
	<!--navbar -->
	<%@include file="Components/navbar.jsp"%>

	<div class="container-fluid mt-4">
		<div class="row g-0">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body px-5">

						<div class="container text-center">
							<img src="Images/signUp.png" style="max-width: 80px;"
								class="img-fluid">
						</div>
						<h3 class="text-center">Create Account</h3>
						<%@include file="Components/alert_message.jsp"%>

						<!--registration-form-->
						<form id="register-form" action="Register_Servlet" method="post">
							<div class="row">
								<div class="col-md-6 mt-2">
									<label class="form-label">Your name</label> <input type="text"
										name="name" class="form-control"
										placeholder="First and last name" required>
								</div>
								<div class="col-md-6 mt-2">
									<label class="form-label">Email</label> <input type="email"
										name="email" placeholder="Email address"
										class="form-control" required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mt-2">
									<label class="form-label">Mobile number</label> <input
										type="text" name="Phone" placeholder="Mobile number"
										class="form-control">
								</div>
								<div class="col-md-6 mt-5">
									<label class="form-label pe-3">Gender</label> <input
										class="form-check-input" type="radio" name="gender"
										value="Male"> <span class="form-check-label pe-3 ps-1">
										Male </span> <input class="form-check-input" type="radio"
										name="gender" value="Female"> <span
										class="form-check-label ps-1"> Female </span>
								</div>
							</div>
							<div class="mt-2">
								<label class="form-label">Address</label> <input type="text"
									name="address"
									placeholder="Enter Address(Area and Street))"
									class="form-control" required>
							</div>
							<div class="row">
								<div class="col-md-6 mt-2">
									<label class="form-label">City</label> <input
										class="form-control" type="text" name="city"
										placeholder="City" required>
								</div>
								<div class="col-md-6 mt-2">
									<label class="form-label">Postal Code</label> <input
										class="form-control" type="text" name="postalcode"
										placeholder="Postal Code" maxlength="6" required>
								</div>
							</div>
							<div class="row">
								<div class="col-md-6 mt-2">
									<label class="form-label">Province</label> <input
										class="form-control" type="text" name="province"
										placeholder="Province"  required>
								</div>

								<div class="col-md-6 mt-2">
									<label class="form-label">Password</label> <input
										type="password" name="password"
										placeholder="Enter Password" class="form-control" required>
								</div>
							</div>

							<div id="submit-btn" class="container text-center mt-4">
								<button type="submit" class="btn btn-outline-primary me-3">Submit</button>
								<button type="reset" class="btn btn-outline-primary">Reset</button>
							</div>
							<div class="mt-3 text-center">
								<h6>
									Already have an account?<a href="login.jsp"
										style="text-decoration: none"> Sign in</a>
								</h6>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>