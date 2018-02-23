<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> Organization </title>
		<link type="text/css" rel="stylesheet" href="css1/design.css"/>
		<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
		<script src="bootstrap/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>

</head>

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
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<%@ include file="sidebar.jsp" %>
			</ul>		
		</div>		
	</div>
				
		<div id="page-content-wrapper">
			<h2> Task Details </h2>
			<table class="table table-bordered table-striped">
			<thead>
				<tr>
					<th> Task Name </th>
					<th> Assign To </th>
					<th> Task Status </th>
					<th> Start Time </th>
					<th> Deadline </th>
					<th> Priority </th>
					<th> Module Name </th>
					<th> Project Name </th>
					<th> Department Name </th>
					<th> Action </th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="d" items="${LIST}">
				
				<!--  set up a link for each task -->
					<c:url var="updateTask" value="TaskUpdateDelete">
						<c:param name="command" value="LOAD"></c:param>	
						<c:param name="name" value="${d.empName}"></c:param>	
						<c:param name="id" value="${d.taskId}"></c:param>
					</c:url>
					
				<!--  set up a link to delete a task -->
					<c:url var="deleteTask" value="TaskUpdateDelete">
						<c:param name="command" value="DELETE"></c:param>		
						<c:param name="id" value="${d.taskId}"></c:param>
					</c:url>
				
					<tr>
					<td> ${d.taskName}</td>
					<td> ${d.empName}</td>
					<td> ${d.taskStatus}</td>
					<td> ${d.startTime}</td>
					<td> ${d.endTime}</td>
					<td> ${d.priority}</td>
					<td> ${d.modName}</td>
					<td> ${d.projName}</td>
					<td> ${d.detpName}</td>
					<td> <a href="${updateTask}" class="btn  btn-sm" >Update</a>
					      <a href="${deleteTask}" class="btn btn-sm"
					      onclick="if(!(confirm('Are you want to delete this task?'))) return false"> Delete</a>
					</td>
					</tr>
				</c:forEach>
			</tbody>
			</table>			
		</div>
</body>

</html>
