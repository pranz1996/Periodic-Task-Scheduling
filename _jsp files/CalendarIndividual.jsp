<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head> <title> To Do </title>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<link href="bootstrap/css/bootstrap-responsive.css" rel="stylesheet">
<link rel="stylesheet" href="css1/design.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<link type="text/css" href="css1/example.css" rel="stylesheet" />

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
				
		<c:url var="next" value="CalendarServletIndividual">
						<c:param name="traverse" value="next"></c:param>		
						<c:param name="month" value="${month}"></c:param>
						<c:param name="year" value="${year}"></c:param>
						<c:param name="userId" value="${user_id}"></c:param>
		</c:url>
		<c:url var="last" value="CalendarServletIndividual">
						<c:param name="traverse" value="last"></c:param>		
						<c:param name="month" value="${month}"></c:param>
						<c:param name="year" value="${year}"></c:param>
						<c:param name="userId" value="${user_id}"></c:param>
		</c:url>
		
		<br>
   		<form>
    		<c:set var="p" value="${monthYear}"> </c:set> 
    		<c:out value="${p}"/> &nbsp;&nbsp;&nbsp;&nbsp;
    		<a href="${next}"> next </a> &nbsp;
    		<a href="${last}"> last </a>
    		<br><br>
    	<table class="table table-bordered">
    	<thead>
		<tr>
    	 <th>Su</th><th>Mo</th><th>Tu</th><th>We</th><th>Th</th><th>Fr</th><th>Sa</th> 
		</tr>
		</thead>
		<tbody>
		<tr>
		
		<c:set var="Mon" value="${month}"></c:set>
		<c:set var="Year" value="${year}"></c:set>
		
		<c:set var="monthToday" value="${monthToday}"></c:set>
		<c:set var="yearToday" value="${yearToday}"></c:set>
		<c:set var="dayToday" value="${dayToday}"></c:set>

    	<%
    	int dd = (int)session.getAttribute("StartDay");
		int p = (int)session.getAttribute("days");
    	
    	for (int i = 0; i < dd; i++) {
    	%>
        	 <td> </td>
    	<% } %>
    	<%
        for (int i = 1; i <= p; i++) {
        %>
        <c:set var="pd" value="<%=i%>"></c:set>
        
  		<c:url var="hj" value="CalendarIndividual">
  			<c:param name="date" value="${pd}"></c:param>
  			<c:param name="month" value="${month}"></c:param>
  			<c:param name="year" value="${year}"></c:param>
  			<c:param name="userId" value="${user_id}"></c:param>
  		</c:url>
  		<c:choose>
        	<c:when test="${Year == yearToday}">
        		<c:choose>
        			<c:when test="${Mon == monthToday}">
        				<c:choose>
        					<c:when test="${pd == dayToday}">
        						<td><mark> <a href="${hj}"> ${pd} </a></mark></td>  
        					</c:when>
        					<c:otherwise>
        						<td> <a href="${hj}"> ${pd} </a> </td>   
        					</c:otherwise>
        			</c:choose>
        			</c:when>
        			<c:otherwise>
        				<td> <a href="${hj}"> ${pd} </a> </td>   
        			</c:otherwise>
        		</c:choose>
        	</c:when>
        	<c:otherwise>
    			<td> <a href="${hj}"> ${pd} </a> </td>    	
        	</c:otherwise>
        </c:choose>
    	
    	<%   if (((i + dd) % 7 == 0) || (i == p))  { %>
        </tr>
         <%} } %>
        </tbody>
    </table>
    </form>	
		</div>
		</div>
</body>

</html>
