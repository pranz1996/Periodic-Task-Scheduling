<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head> <title> All Tasks</title></head>
	<link rel="stylesheet" href="css1/task.css"/>
	<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
	<link rel="stylesheet" href="bootstrap/css/bootstrap-responsive.css"/>
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
		
				<div>
						
					<ul class="nav navbar-nav navbar-right">
						<li> <a href="Logout"> Logout </a>
					</ul>
				</div>
			</div>
		</nav>
	</div>
	
	<div id="wrapper">
		
		<div id="page-content-wrapper">
				<form action="TaskStartEndProcessing" method="get">
	<div class="container-fluid">
	
	<div class="row-fluid">
		<div class="span4" align="center">
		<b> TO-DO </b>
		</div>
		<div class="span4" align="center">
		<b> IN PROGRESS </b>
		</div>
		<div class="span4" align="center">
		<b> DONE </b>
		</div>
	</div>
	<div class="row-fluid">
		<div class="span4">
		<div class="list-group">
			<c:forEach var="todo" items="${TODO}">
				<li class="list-group-item">
					${todo.taskName}			
				<c:set var="deadline" value="${todo.deadline}"/>
					<c:if test="${deadline != null}"> 
						<span class="badge badge-secondary">
	 						${todo.deadline}
	 					</span>
	 				</c:if>
	 			<c:set var="prio" value="${todo.priority}"/>
					<c:if test="${prio != 0}"> 
						<span class="badge badge-secondary">
	 						${todo.priority}
	 					</span>
	 				</c:if>
					<c:set var="t" value="${todo.taskName}"/> 
					<input type="submit" value="start" class="btn btn-primary" name="tasking"/>
					<input type="hidden" value="${t}" name="task"/>
				</li>
			</c:forEach>
		</div>
		</div>
		<div class="span4">
		<div class="list-group">
			<c:forEach var="doing" items="${DOING}">
				<li class="list-group-item">
					${doing.taskName}
					<c:set var="end" value="${doing.deadline}"/>
					<c:if test="${end != null}"> 
						<span class="badge badge-secondary">
	 						${doing.deadline}
	 					</span>
	 				</c:if>
					<c:set var="p" value="${doing.priority}"/>
					<c:if test="${p != 0}"> 
						<span class="badge badge-secondary">
	 						${doing.priority}
	 					</span>
	 				</c:if>
					<c:set var="d" value="${doing.taskName}"/> 
					<input type="submit" value="end" class="btn btn-success" name="tasking"/>
					<input type="hidden" value="${d}" name="task1"/>
				</li>
			</c:forEach>
		</div>
		</div>
		<div class="span3">
		<div class="list-group">
			<c:forEach var="done" items="${DONE}">
				<li class="list-group-item">
					${done.taskName}
				</li>
			</c:forEach>
		</div>
		</div>
	</div>
	
	</div>

	</form>

	<hr>
	<a href="User" class="btn btn-primary"> Go to Board </a>
		</div>
	
  </div>
</body>

</html>
