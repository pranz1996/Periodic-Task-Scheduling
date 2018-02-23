package organization;

public class Task {
	
		// attributes
		int taskId;
		String taskName;
		String empName ;
		String taskStatus;
		String startTime;
		String endTime;
		int priority;
		String modName;
		String projName;
		String detpName;
		String userName;
		String password;
		int status;
		int deptid;
		int projid;
		int modid;
		
		// constructors
		public Task() {
			
		}
		
		public Task(String taskName, String deadline, int priority) {
			super();
			this.taskName = taskName;
			this.endTime = deadline;
			this.priority = priority;
		}

		public Task(String tname, String taskStatus, String stime, String etime, int prio) {
			this.taskName = tname;
			this.startTime = stime;
			this.endTime = etime;
			this.priority = prio;
			this.taskStatus = taskStatus;	
		}
		
		public Task(String deptname, String projname, String modname, String task, String taskStatus) {
			this.taskName = task;
			this.taskStatus = taskStatus;
			this.modName = modname;
			this.projName = projname;
			this.detpName = deptname;
		}

		public Task(int taskId,String taskName, String empName, String taskStatus, String startTime, String endTime,
				int priority2, String modName, String projName, String detpName) {
			this.taskId = taskId;
			this.taskName = taskName;
			this.empName = empName;
			this.taskStatus = taskStatus;
			this.startTime = startTime;
			this.endTime = endTime;
			this.priority = priority2;
			this.modName = modName;
			this.projName = projName;
			this.detpName = detpName;
		}

		// getter setter methods
		public int getTaskId() {
			return taskId;
		}
		public void setTaskId(int taskId) {
			this.taskId = taskId;
		}
		public String getTaskName() {
			return taskName;
		}
		public void setTaskName(String taskName) {
			this.taskName = taskName;
		}
		
		public String getEmpName() {
			return empName;
		}
		public void setEmpName(String empName) {
			this.empName = empName;
		}
		
		public String getTaskStatus() {
			return taskStatus;
		}
		public void setTaskStatus(String taskStatus) {
			this.taskStatus = taskStatus;
		}
		
		public String getStartTime() {
			return startTime;
		}
		public void setStartTime(String startTime) {
			this.startTime = startTime;
		}
		
		public String getEndTime() {
			return endTime;
		}
		public void setEndTime(String endTime) {
			this.endTime = endTime;
		}
		
		public int getPriority() {
			return priority;
		}
		public void setPriority(int priority) {
			this.priority = priority;
		}
		
		public String getModName() {
			return modName;
		}
		public void setModName(String modName) {
			this.modName = modName;
		}
		
		public String getProjName() {
			return projName;
		}
		public void setProjName(String projName) {
			this.projName = projName;
		}
		
		public String getDetpName() {
			return detpName;
		}
		public void setDetpName(String detpName) {
			this.detpName = detpName;
		}
	
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}

		public String getPassword() {
			return password;
		}
		public void setPassword(String password) {
			this.password = password;
		}
			
		public int getStatus() {
			return status;
		}
		public void setStatus(int status) {
			this.status = status;
		}

		public int getDeptid() {
			return deptid;
		}
		public void setDeptid(int deptid) {
			this.deptid = deptid;
		}

		public int getProjid() {
			return projid;
		}
		public void setProjid(int projid) {
			this.projid = projid;
		}

		public int getModid() {
			return modid;
		}
		public void setModid(int modid) {
			this.modid = modid;
		}

		// special setter methods
		public void setTask(String taskName2, String mod, int prio,String stime,String etime,int Status) {
			taskName = taskName2;
			modName = mod ;
			priority = prio;
			startTime = stime;
			endTime = etime;
			status = Status;
		}
		public void setModule(String modName2, String project) {
			modName = modName2;
			projName = project;
		}
		public void setProject(String projName2, String department) {
			projName = projName2;
			detpName = department;
		}
		public void setDepartment(String empName2, String user, String pass, String department) {
			empName = empName2;
			detpName = department;
			userName = user ;
			password = pass;
		}
		
		// toString for debugging purpose
		@Override
		public String toString() {
			return "Task [taskName=" + taskName + ", taskStatus=" + taskStatus + ", startTime=" + startTime
					+ ", endTime=" + endTime + ", priority=" + priority + "]";
		}

}
