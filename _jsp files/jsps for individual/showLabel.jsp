<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> Label </title> </head>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link rel="stylesheet" href="css1/design.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<body>
		<div id="navigation">
		<nav class="navbar navbar-inverse">
			<div class="container-fluid">
				<div class="navbar-header">
					 <a class="navbar-brand">Periodic Task Scheduling</a>
				</div>
				
				<ul class="nav navbar-nav navbar-right">
					<li> <a href="Logout"> Logout </a>
					<li> </li>
				</ul>
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
		
		<c:forEach var="labels" items="${THE_LABELS}"> 
		<c:url var="Show" value="RemindAndLabel">
				<c:param name="command" value="showTask"></c:param>
				<c:param name="Id" value="${id}"></c:param>	
				<c:param name="labelName" value="${labels.label}"> </c:param>
				
		</c:url>
		<ul>
			<li> ${labels.label} 
		 	<a href="${Show}" class="btn btn-info">Show Task(s)</a> 
			</li>
		</ul>
		</c:forEach>
	
		
	</div>
	
  </div>
	<!--	<h1> Label(s) </h1>
		
		<br> <br>
		
		<a href="Individual"> Back to Home </a>
		
		<a href="individual.jsp"> Back to List</a>
		-->
</body>

</html>
