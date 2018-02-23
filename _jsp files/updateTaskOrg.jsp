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

		
		<form action="TaskUpdateDelete" method="get">
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<input type="hidden" name="command" value="UPDATE" />
					<input type="hidden" name="status" value="${TASK.taskStatus}"/>
					<input type="hidden" name="id" value="${TASKID}"/>
					<label> The Task Name </label>	
					<input type="text" class="form-control" value="${TASK.taskName}" name="task" placeholder="Enter Task Name" required/> 
				</div>
			</div>
				<c:set var="status" value="${TASK.taskStatus}"/>
				<c:choose>
					<c:when test="${status == 'To Do'}"> 
						<div class="row col-lg-offset-1">
							<div class="form-group col-md-4">
								<label> Assign Task </label>
								<select name="emp" class="form-control">
									<c:forEach var="e" items="${EMPLOYEE}" >
										<option value="${e}" class="form-control">${e} </option>
									</c:forEach>
								</select>
	 						</div>
						</div>
	 				</c:when>
	 				<c:otherwise>
	 				<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<label> Task Status </label>
							<input type="text" class="form-control" value="${TASK.taskStatus}" disabled="disabled"/> 	 					
	 					</div>
					</div>
					<div class="row col-lg-offset-1">
						<div class="form-group col-md-4">
							<label> Task Assigned To </label>
							<input type="text" class="form-control" value="${EMP}" disabled="disabled"/> 	 					
	 					</div>
					</div>
	 				</c:otherwise>
				</c:choose>	

		<div id="dtBox"></div>
	
		<script>
			$('#dtBox').DateTimePicker({
				dateTimeFormat: "yyyy-mm-dd hh:mm:ss"
			});
		</script>
		
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<label> Start Time </label>
					<input type="text" class="form-control" name="stime" value="${TASK.startTime}" data-field="datetime" placeholder="Enter Start Time "/>			
				</div>
			</div>
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
					<label> End Time </label>
					<input type="text" class="form-control" name="etime" value="${TASK.endTime}" data-field="datetime" placeholder="Enter Deadline"/>			
				</div>
			</div>
			
			<div class="row col-lg-offset-1">
				<div class="form-group col-md-4">
				<label> Priority </label>
					<input type="text" class="form-control" name="priority" value="${TASK.priority}" placeholder="Enter Priority"/>			
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
