<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB" crossorigin="anonymous">
</head>
<body>

		<div class="container">
			<div class="row">
				<div class="col-5 mx-auto mt-3 p-5 card">
				<h2>Student Registration</h2>
				<hr>
		${msg}
		<form action="reg" method="post">
		<input type="text" name="name" placeholder="Enter name" class="form-control">
		<br>
		<input type="text" name="email" placeholder="Enter eamil" class="form-control">
		<br>
		<input type="text" name="phone" placeholder="Enter phone" class="form-control">
<br>
		<input type="submit" class="btn btn-success">	
		<input type="reset" class="btn btn-primary">
		<a href="display" class="btn btn-warning">Display</a>	
		</form>
		
		</div>
			</div>
		</div>

</body>
</html>