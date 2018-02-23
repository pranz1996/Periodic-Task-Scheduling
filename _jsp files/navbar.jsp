					<ul class="nav navbar-nav">
						<c:url var="allemp" value="Organization">
							<c:param name="get" value="showEmp"></c:param>
						</c:url>
						<c:url var="alldept" value="Organization">
							<c:param name="get" value="ShowDept"></c:param>
						</c:url>
						<c:url var="allproj" value="Organization">
							<c:param name="get" value="ShowProj"></c:param>
						</c:url>
						<c:url var="allmod" value="Organization">
							<c:param name="get" value="ShowMod"></c:param>
						</c:url>
						<c:url var="alltask" value="Organization">
							<c:param name="get" value="ShowTask"></c:param>
						</c:url>
						<c:url var="go" value="OrganizationBoard">
						</c:url>
						<li> <a href="${go}"> Home </a> </li>			
						<li> <a href="${alldept}">Departments </a> </li>
						<li> <a href="${allemp}">Employee </a> </li>
						<li> <a href="${allproj}">Projects </a> </li>
						<li> <a href="${allmod}">Modules </a> </li>
						<li> <a href="${alltask}">Tasks </a> </li>
					</ul>
					
					<ul class="nav navbar-nav navbar-right">
						<li> <a href="Logout"> Logout </a>
					</ul>
