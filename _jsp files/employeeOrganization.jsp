<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> Organization </title>
		<link type="text/css" rel="stylesheet" href="css1/employee.css"/>
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
				
				<!--  Menu -->
				<div>
							
					<ul class="nav navbar-nav">
						
						<c:url var="alltask" value="ServletTask"> </c:url>
						<li> <a href="${alltask}">Tasks </a>  </li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li> <a href="Logout"> Logout </a>
					</ul>
				</div>
			</div>
		</nav>
	</div>
		<h3 align="center"> Employee Dashboard </h3>
	<div id="wrapper">
		
		<div id="page-content-wrapper">
			<form>
			
	<table class="tab table-bordered table-condensed">
			
			<thead>
				<tr>
					<th> Department </th>
					<th> Project </th>
					<th> Module </th>
					<th> Task-Name </th>
					<th> Task Status </th>
				</tr>
			</thead>
			
			<tbody>
				<c:forEach var="l" items="${data}">
					<tr>
						<td> ${l.detpName} </td>
						<td> ${l.projName} </td>
						<td> ${l.modName} </td> 
						<td> ${l.taskName} </td>
						<td> ${l.taskStatus} </td>
					</tr>			
				</c:forEach>
				
			</tbody>
			
	</table>
	</form>
		</div>
	
  </div>

</body>

</html>
