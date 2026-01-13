<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"
	integrity="sha256-/JqT3SQfawRcv/BIHPThkBvs0OEvtFFmqPF/lYI/Cxo="
	crossorigin="anonymous"></script>

<script type="text/javascript">

		$(document).ready(function(){
			
		})

		const test = ()=>{			
			var dt = $("#dt").val()
			$.get("test",{dt},function(rt){
				$("#data").html(rt)
			})			
		}
		
		
		const search = (q)=>{
			
			$.get("search",{q},function(rt){
				$("#sdata").html(rt)
			})
		}

</script>


</head>
<body>
		<input type="text" name="dt" id="dt" onkeyup="test()">
		<button onclick="test()">Click Me</button>
		<div id="data"></div>
		
		<hr>
		
		<input name="search" id="search" placeholder="Search..."  onkeyup="search(value)">
		<div id="sdata"></div>
		
		
</body>
</html>