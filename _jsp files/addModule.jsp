<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title> Add Module</title> </head>

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
		
			<form action="Organization" method="get">
					<input type="hidden" name="get" value="addMod" />
					
				<div class="row col-lg-offset-1">
					<div class="form-group col-md-4">	
						<input type="text" class="form-control" name="mod" placeholder="Enter Module Name" required/>
					</div>
				</div>
				<div class="row col-lg-offset-1">
					<div class="form-group col-md-4">
						<label> Set Project </label> 
						<select name="proj" class="form-control">
							<c:forEach var="p" items="${THE_PROJS}" >
								<option value="${p.projName}" class="form-control">${p.projName} </option>
							</c:forEach>
						</select>
					</div>
				</div>
				<div class="row col-lg-offset-1">
					<div class="form-group col-md-4">
						<button type="submit" class="btn btn-success"> Add Module</button>
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
	
	</div>
	
</body>

</html>

