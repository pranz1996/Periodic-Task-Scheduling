<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<head> <title> To Do 
</title>

<link rel="stylesheet" href="bootstrap/cssp/bootstrap.min.css" />
<script src="bootstrap/jquery.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<link href="bootstrap/DateTimePicker.css" rel="stylesheet"/>
<script src="bootstrap/jquery.min.js"></script>	
<script src="bootstrap/DateTimePicker.js"></script>


</head>

<body>

		<form action="Individual" method="post">
			<div class="container-fluid">
			
 			<div class="form-row">
 				<div class="form-group col-md-5">
	 				 <input type="text" name="label" class="form-control" placeholder="Label"/>
	 			</div>
	 			<div class="form-group col-md-5">
	 				<input type="text" name="title" class="form-control" placeholder="Title"/>
	 			</div>
	 		</div>	 
	 			
		 	<div class="form-row">
 				<div class="form-group col-md-5">
					<input type="text" name="name" class="form-control" placeholder="Take a note..." required/>	 			
				</div>
	 			<div class="form-group col-md-3">
	 				<div id="dtBox"></div>
					<script>
						$('#dtBox').DateTimePicker({
							dateTimeFormat: "yyyy-mm-dd hh:mm:ss"
						});
					</script>
					 <input type="text" name="reminder" class="form-control" data-field="datetime" placeholder="set reminder"/> 
	 			</div>
	 			<div class="form-group col-md-2">
 					 <button type="submit" class="btn btn-success"> Done </button> 
	 			</div>
	 		</div>
			</div>
		</form>
		<hr>		
</body>

</html>
