<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> To Do </title> 

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link rel="stylesheet" href="css1/design.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<link href="bootstrap/DateTimePicker.css" rel="stylesheet"/>
<script src="bootstrap/jquery.min.js"></script>	
<script src="bootstrap/DateTimePicker.js"></script>

</head>

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
	
		<form action="UpdateDelete" method="get">
		<div id="dtBox"></div>
					<script>
						$('#dtBox').DateTimePicker({
							dateTimeFormat: "yyyy-mm-dd hh:mm:ss"
						});
				</script>
		<div class="container-fluid">
		<input type="hidden" name="command" value="UPDATE"/>
		<input type="hidden" name="Id" value="${TASK.name}"/>
		<div class="form-row">
 		 	<div class="form-group col-md-5">
 		 <input type="text" name="label" class="form-control"
 			value="${TASK.label}" placeholder="Label"/> 
 			</div>
 			<div class="form-group col-md-5">
 			 <input type="text" name="title" class="form-control"
			value="${TASK.title}" placeholder="Title"/> 
			</div>
		</div>	
		 <div class="form-row">
		 	<div class="form-group col-md-5">
		  	<input type="text" name="name" class="form-control"
			value="${TASK.name}" placeholder="Take a note..." required/> 
			</div>
			 <div class="form-group col-md-3">
			  <input type="text" name="reminder" class="form-control"
			value="${TASK.reminder}" data-field="datetime" placeholder="set reminder"/> 
			</div>
			<div class="form-group col-md-2">
				<button type="submit" class="btn btn-success"> Done </button>
			</div>
		</div>
		</div>
		</form>	
		
	</div>
	
  </div>

		
	<!-- 
		<br> <br>
	 	
		<a href="Individual"> Back to Home </a>
		
		<a href="individual.jsp"> Back to List</a>
		-->
</body>

</html>
