<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title>Assign Task</title> </head>

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
	
	<div id="wrapper">
		<div id="page-content-wrapper">
		
		<form action="AssignTaskToEmp" method="get">
		
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
				<label> Choose Employee </label>
				<select name="emps" class="form-control">
					<c:forEach var="e" items="${EMPs}" >
						<option value="${e}" class="form-control">${e} </option>	
					</c:forEach>
				</select>
				</div>
			</div>		
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">	
				<label>Choose Task </label>
				<select name="tasks" class="form-control">
					<c:forEach var="d" items="${TASKs}" >
						<option value="${d}" class="form-control" >${d} </option>
					</c:forEach>
				</select>
				</div>
			</div>
			<div class="row col-lg-offset-1">
					<div class="form-group col-md-4">
						<button type="${assign}" class="btn btn-success"> Assign </button>
					</div>
			</div>
		</form>
			
			<br><br><br>
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<a href="OrganizationBoard" class="btn btn-primary" > Cancel </a>
				</div>
			</div>
		</div>
	
  </div>
		
</body>

</html>
