<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head> <title> To Do </title>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css1/design.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>


</head>
 
<body>	
	<div id="navigation">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					<c:url var="e" value="CalendarServletIndividual"> 
						<c:param name="userId" value="${i}"></c:param>
					</c:url>
					 <a class="navbar-brand">Periodic Task Scheduling</a> 
				</div>
				<div>
				<ul class="nav navbar-nav">
					<li> <a href="${e}"> CALENDAR VIEW</a> </li>
				
				</ul>
				</div>
				<div>
				<ul class="nav navbar-nav navbar-right">
					<li> <a href="Logout"> Logout </a>
					<li> </li>
				</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div id="wrapper">
		
		<!--  Sidebar -->
		
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
		
				<c:url var="reminder" value="RemindAndLabel">
					<c:param name="command" value="remind"></c:param>
				</c:url>
		
				<c:url var="label" value="RemindAndLabel">
					<c:param name="command" value="labels"></c:param>
				</c:url>
				
				<li> <a href="Individual"> Notes </a> </li>
				<li> <a href="${reminder}"> Reminders </a> </li>
				 <li class="nav-divider " ></li>
				<li> <a href="${label}"> Labels</a>
			</ul>
		
		</div>
	
		<div id="page-content-wrapper">
			
		<%@ include file="addingTask.jsp" %>
		
		<!--   -->
		<c:forEach var="task" items="${THE_TASKS}">
			<c:choose>
				<c:when test="${empty task}">
				<h1> EMPTY </h1>
				</c:when>
				<c:otherwise>
		 	<div class="jumbotron" align="center">
			<div class="form-row">
				<c:url var="update" value="UpdateDelete">
					<c:param name="command" value="LOAD"></c:param>
					<c:param name="Id" value="${task.name}"></c:param>	
				</c:url>
				<c:url var="delete" value="UpdateDelete">
					<c:param name="command" value="DELETE"></c:param>
					<c:param name="Id" value="${task.name}"></c:param>	
				</c:url>
				
 				<div class="form-group col-sm-2">
 					<b>
	 				 ${task.title} 
					</b>
	 			</div>	
	 		 </div>	 
			
			<div class="form-group">
	 				<a href="${update}" class="btn btn-primary btn-sm">Update</a> 	
					<a href="${delete}" class="btn btn-primary btn-sm">Delete</a>
	 		</div>
			
			 <div class="form-row">
 				<div class="form-group col-sm-6">
	 				${task.name}
	 			</div>
	 		</div>	 
			
			<div class="form-row">
 				<div class="form-group col-sm-2">
	 				<c:set var="label" value="${task.label}"/>
	 				
					<c:if test="${label != null}"> 
						<span class="badge badge-secondary">
	 					 ${task.label}
	 					</span>
	 					</c:if>
	 			</div>
 				
 				<div class="form-group col-sm-2">
 					<c:set var="remind" value="${task.reminder}"/>
					<c:if test="${remind != null}"> 
						<span class="badge badge-secondary">
	 					 ${task.reminder}
	 					</span>
	 					</c:if>
	 			</div>
	 		</div>
	 		</div>
				</c:otherwise>
			</c:choose>
		</c:forEach>	
		
	</div>
	
  </div>
</body>

</html>
