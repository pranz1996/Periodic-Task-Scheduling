<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css1/loginDesign.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<title>Registration</title>
</head>
 
<body>	
	<div id="navigation">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					 <a class="navbar-brand">Periodic Task Scheduling</a>
				</div>
			</div>
		</nav>
	</div>

	<div id="page-content-wrapper">
	<h1> Registration </h1>

	<!-- Registration page respond to RegLogServlet using hidden parameter 'register' -->
	<form action="RegLogServlet" method="get" >
	<!-- Hidden Parameter -->
	<input type="hidden" name="Page" value="register"/>

				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> FIRST NAME </label>
						<input type="text" class="form-control" name="firstname" placeholder="Enter Your First Name" required="required"> 
					</div>	
				</div>
		
				<div class="row col-lg-offset-4">		
					<div class="form-group col-md-4"> 
						<label> LAST NAME </label>
						<input type="text" class="form-control" name="lastname" placeholder="Enter Your Last Name" required="required"> 
					</div>
				</div>
			
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> USER NAME </label>
						<input type="text" class="form-control" name="username" placeholder="Set User Name" required="required"> 
					</div>
				</div>
				
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> ENTER CATEGORY </label>
						<select name="category" class="form-control">
							<option value="Enter Category" class="form-control"> Enter Category </option>
							<option value="individual" class="form-control"> Individual </option>
							<option value="organization" class="form-control"> Organization </option>
						</select>
					</div>
				</div>
			
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> PASSWORD </label>
						<input type="password" class="form-control" name="password" placeholder="Set The Password" required="required">
					</div>
				</div>
				
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> EMAIL ID  </label>
						<input type="text" name="email" class="form-control" placeholder="Enter Your Email Id" required="required"> 
					</div>
				</div>
				
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> Mobile No  </label>
						<input type="text" name="mobile" class="form-control" placeholder="Enter Your Mobile No" required="required"> 
					</div>
				</div>

				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
							<button type="submit" class="btn btn-success"> SUBMIT</button> 
					</div>
				</div>
			</form>
		</div>
</body>
</html>
