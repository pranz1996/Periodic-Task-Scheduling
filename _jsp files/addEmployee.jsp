<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title> Add Employee</title> </head>

		<link type="text/css" rel="stylesheet" href="css1/design.css"/>
		<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
		<script src="bootstrap/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>


<body>
		
	<div id="navigation">
		<nav class="navbar navbar-default">
			<div class="container-fluid">
			
				<!--  Logo  -->
					<div class="navbar-header">
						 <a class="navbar-brand">Periodic Task Scheduling</a>
					</div>
				
				<!--  Nav Menu -->
				<div>
					<%@ include file="navbar.jsp" %>				
				</div>
			</div>
		</nav>
	</div>
		<div id="page-content-wrapper">
		
			<form action="Organization" method="get">
			
						<div class="row col-lg-offset-1">
							<div class="form-group col-md-4">	
								<input type="hidden" name="get" value="addEmp" />
								<input type="text" name="empname" class="form-control" placeholder="Enter Employee Name" required/>
							</div>
						</div>

			
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<input type="text" name="username" class="form-control" placeholder="Set Username" required /> 
						</div>
					</div>
					
					<div class="row col-lg-offset-1">	
						<div class="form-group col-md-4">
							<input type="password" name="password" class="form-control" placeholder="Set password" required />
						</div>
					</div>
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<label> Set Departmemt </label>
							<select name="dept" class="form-control" >
								<c:forEach var="d" items="${THE_DEPTS}" >
								<option class="form-control" value="${d.detpName}">${d.detpName} </option>
								</c:forEach>
							</select>
						</div>
					</div>
					
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
						</div>
					</div>
					
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<button type="submit" class="btn btn-success"> Add Employee</button>
						</div>
					</div>
					</form>
		
				<br><br><br>
					
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<a href="OrganizationBoard" class="btn btn-primary"> Cancel </a>
						</div>
					</div>	
					
		</div>

	
</body>

</html>
