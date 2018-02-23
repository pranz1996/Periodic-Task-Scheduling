<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head><title> Add Task</title> </head>

		<link type="text/css" rel="stylesheet" href="css1/design.css"/>
		<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
		<script src="bootstrap/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>

		<link href="bootstrap/DateTimePicker.css" rel="stylesheet"/>
		<script src="bootstrap/jquery.min.js"></script>
		<script src="bootstrap/DateTimePicker.js"></script>

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
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<input type="hidden" name="get" value="addTask" />		
					<input type="text" class="form-control" name="task" placeholder="Enter Task Name" required/> 
				</div>
			</div>

			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<label> Set Module </label> 
					<select name="modu" class="form-control">
					<c:forEach var="m" items="${THE_MODS}" >
						<option value="${m.modName}" class="form-control">${m.modName} </option>
					</c:forEach>
					</select>
				</div>
			</div>
		<div id="dtBox"></div>
	
		<script>
			$('#dtBox').DateTimePicker({
				dateTimeFormat: "yyyy-mm-dd hh:mm:ss"
			});
		</script>
		
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<input type="text" class="form-control" name="stime" data-field="datetime" placeholder="Enter Start Time "/>			
				</div>
			</div>
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<input type="text" class="form-control" name="etime" data-field="datetime" placeholder="Enter Deadline"/>			
				</div>
			</div>
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<input type="text" class="form-control" name="priority" placeholder="Enter Priority"/>			
				</div>
			</div>	 
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
				</div>
			</div>	 
			
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<button type="submit" class="btn btn-success"> Add Task</button>
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
