					<c:url var="emp" value="Populate">
						<c:param name="get" value="addEmp"></c:param>
					</c:url>
					<c:url var="dept" value="Populate">
						<c:param name="get" value="addDept"></c:param>
					</c:url>
					<c:url var="proj" value="Populate">
						<c:param name="get" value="addProj"></c:param>
					</c:url>
					<c:url var="modu" value="Populate">
						<c:param name="get" value="addMod"></c:param>
					</c:url>
					<c:url var="task" value="Populate">
						<c:param name="get" value="addTask"></c:param>
					</c:url>
					<c:url var="assign" value="Populate">
						<c:param name="get" value="assignTask"></c:param>
					</c:url>
					<li> <a href="${dept}">Add Department </a> </li>
					<li> <a href="${emp}">Add Employee </a> </li>
					<li> <a href="${proj}">Add Project </a> </li>
					<li> <a href="${modu}">Add Module </a>	</li>
					<li> <a href="${task}">Add Task </a>   	<li>
					<li> </li>
					<li> </li>
					<hr>
					<li> <a href="${assign}"> Assign Task</a> </li>
