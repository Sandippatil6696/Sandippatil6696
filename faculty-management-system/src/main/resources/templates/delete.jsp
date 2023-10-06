<html xmlns:th="https://thymeleaf.org" lang="en">
<head>
<title>Index Page</title>
<style type="text/css">
body {
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	margin: 15px 30px;
	font-size: 15px;
	padding: 8px;
}

input[type="text"] {
	padding: 5px;
	border: 2px solid #ccc;
	border-radius: 4px;
}

input[type="submit"] {
	background-color: #4caf84;
	color: #ffff;
	border: none;
	width: 100%;
	height: 40px;
}

input[type="submit"]:hover {
	background-color: lightcoral;
	color: black;
}

.container {
	background-color: #f2f2f2;
	padding: 20px 20px 20px 20px;
	border: 1px solid lightgray;
	border-radius: 4px;
	width: 200px;
	margin: auto;
}
</style>
</head>

<body>
	<div class="container">
		<h2 style="text-align: center;">Delete By Id</h2>
		<form action="delete" method="GET">
			<table>
				<tr>
					<td><label for="faculty-Id">Id</label></td>
					<td><input type="text" name="id"></input></td>
				</tr> 
				<tr>
					<td></td>
					<td><input type="submit" value="Submit"></input></td>
				</tr>

			</table>
		</form>
	</div>
</body>
</html>
