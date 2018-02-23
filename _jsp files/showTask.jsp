<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>

<head> <title> All Tasks</title></head>

		<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
		<link type="text/css" rel="stylesheet" href="css1/task.css"/>
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
		
		<h1 align="center"> All Tasks </h1>

		<div align="center">
				<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span3">
			
		</div>
		<div class="span3">
		<b> TO-DO </b>
		</div>
		<div class="span3">
		<b> IN PROGRESS </b>
		</div>
		<div class="span3">
		<b> DONE </b>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span3">
			
		</div>
		<div class="span3">
			<div class="list-group">
				<c:forEach var="todo" items="${TODO}">
					<li class="list-group-item ">
						${todo.taskName}
				<c:set var="deadline" value="${todo.endTime}"/>
					<c:if test="${deadline != null}"> 
						<span class="badge badge-secondary">
	 						${todo.endTime}
	 					</span>
	 				</c:if>
	 			<c:set var="prio" value="${todo.priority}"/>
					<c:if test="${prio != 0}"> 
						<span class="badge badge-secondary">
	 						${todo.priority}
	 					</span>
	 				</c:if>						
					</li>
				</c:forEach>
			</div>
		</div>
		<div class="span3">
			<div class="list-group">
				<c:forEach var="doing" items="${DOING}">
					<li class="list-group-item">
						${doing.taskName}
				<c:set var="deadline" value="${doing.endTime}"/>
					<c:if test="${deadline != null}"> 
						<span class="badge badge-secondary">
	 						${doing.endTime}
	 					</span>
	 				</c:if>
	 			<c:set var="prio" value="${doing.priority}"/>
					<c:if test="${prio != 0}"> 
						<span class="badge badge-secondary">
	 						${doing.priority}
	 					</span>
	 				</c:if>
					</li>
				</c:forEach>
			</div>
		</div>
		<div class="span3">
			<div class="list-group">
				<c:forEach var="done" items="${DONE}">
					<li class="list-group-item">
						${done.taskName}
				<c:set var="deadline" value="${done.endTime}"/>
					<c:if test="${deadline != null}"> 
						<span class="badge badge-secondary">
	 						${done.endTime}
	 					</span>
	 				</c:if>
	 			<c:set var="prio" value="${done.priority}"/>
					<c:if test="${prio != 0}"> 
						<span class="badge badge-secondary">
	 						${done.priority}
	 					</span>
	 				</c:if>
					</li>
				</c:forEach>
			</div>
		</div>
	</div>
	
	</div>
			
		</div>		
		
		</div>
	
  </div>
		
</body>

</html>
