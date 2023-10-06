<html xmlns:th="https://thymeleaf.org" lang="en">
<head>
<title>update Page</title>
<style type="text/css">
* {
	box-sizing: border-box;
}

body {
	font-family: Verdana, Geneva, Tahoma, sans-serif;
	margin: 15px 30px;
	font-size: 15px;
	padding: 8px;
}

.container {
	background-color: #f2f2f2;
	padding: 20px 20px 20px 20px;
	border: 1px solid lightgray;
	border-radius: 4px;
	width: 400px;
	margin: auto;
}

input[type="submit"] {
	background-color: #4caf84;
	color: #ffff;
	border: none;
	width: 100%;
	height: 30px;
	align: center
}

input[type="submit"]:hover {
	background-color: lightcoral;
	color: black;
}

input[type="text"] {
	padding: 5px;
	border: 2px solid #ccc;
	border-radius: 4px;
	margin: 5px;
}
</style>
</head>
<body>
	<div class="container">

		<form action="update" method="POST">
			<table>
				<tr>
					<td><label for="Faculty-Id">Faculty Id</label></td>
					<td><input type="text" name="id" th:value="${facultylist.id}"></input></td>
				</tr>
				<tr>
					<td><label for="Faculty-Name">Faculty Name</label></td>
					<td><input type="text" name="name"
						th:value="${facultylist.name}"></input></td>
				</tr>
				<tr>
					<td><label for="Faculty-Address">Address</label></td>
					<td><input type="text" name="address"
						th:value="${facultylist.address}"></input></td>
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
