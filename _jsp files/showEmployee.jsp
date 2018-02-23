<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> All Employees</title></head>

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
		
		<!--  Sidebar -->
		
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<%@ include file="sidebar.jsp" %>		
			</ul>
		</div>
	
		<div id="page-content-wrapper">
		
			<h1> All Employees </h1>
			<div class="col-lg-3" align="center">
				<ul class="list-group">
					<c:forEach var="emp"  items="${THE_EMPS}">
					<li class="list-group-item">
						${emp}
					</li>
					</c:forEach>
				</ul>
			</div>
						
		</div>
	
  </div>
	
</body>

</html>
