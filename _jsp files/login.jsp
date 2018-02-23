<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css1/loginDesign.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<title>Login</title>
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

	<h1> Login </h1>

	<!-- Login page respond to RegLogServlet using hidden parameter 'login' -->
	<form name="form" action="RegLogServlet" method="get" >
	
	<!--  hidden parameter -->
	<input type="hidden" name="Page" value="login"/>
		
				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
						<label> USER NAME </label>
						<input type="text" class="form-control" name="username" placeholder="Set User Name" required="required"> 
					</div>
				</div>
		
				<!-- Category for Individual or Organization/Employee -->		
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
						<input type="password" class="form-control" name="password" placeholder="Enter The Password" required="required">
					</div>
				</div>
				

				<div class="row col-lg-offset-4">
					<div class="form-group col-md-4">
							<button type="submit" class="btn btn-success"> SUBMIT</button> 
							
							<!-- If not a User, then go to Registration Page -->
							<a href="registration.jsp" class="btn btn-success"> Register </a> 
					</div>
				</div>
</form>
	</div>
</body>
</html>
