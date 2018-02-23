<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> All Departments</title></head>

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

			<h1> All Departments </h1>
			<div class="col-lg-3" align="center">
				<ul class="list-group">
					<c:forEach var="dept" items="${THE_DEPTS}">
						<li class="list-group-item">
							${dept.detpName}
						</li>
					</c:forEach>
				</ul>
			</div>
		<!-- 		<form action="orgChangeName" method="get">
					<input type="hidden" name="change" value="deptPopulate"/>
					<input type="submit" class="btn btn-primary" value="Change Department Name"/>
				</form>		
			 -->
		</div>
  </div>		
</body>

</html>
