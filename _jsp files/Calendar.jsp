<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
 		<link type="text/css" rel="stylesheet" href="css1/design.css"/>
		<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
		<script src="bootstrap/jquery.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
  
  		<link type="text/css" href="css1/exemple.css" rel="stylesheet" />
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
		
		<!--  Sidebar -->
		
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">
				<%@ include file="sidebar.jsp" %>
			</ul>		
		</div>
		
		<div id="page-content-wrapper">
	
		<c:url var="next" value="CalendarServlet">
						<c:param name="traverse" value="next"></c:param>		
						<c:param name="month" value="${month}"></c:param>
						<c:param name="year" value="${year}"></c:param>
		</c:url>
		<c:url var="last" value="CalendarServlet">
						<c:param name="traverse" value="last"></c:param>		
						<c:param name="month" value="${month}"></c:param>
						<c:param name="year" value="${year}"></c:param>
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
        
  		<c:url var="hj" value="CalendarWiseTask">
  			<c:param name="date" value="${pd}"></c:param>
  			<c:param name="month" value="${month}"></c:param>
  			<c:param name="year" value="${year}"></c:param>
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
