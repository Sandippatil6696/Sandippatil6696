<html xmlns:th="https://thymeleaf.org">
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<style>
h1 {
	text-align: center;
}

table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 1px solid #dddddd;
	text-align: center;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}

button {
	background-color: #4caf84;
	color: #ffff;
	border: none;
	width: 10%;
	height: 40px;
	margin-bottom: 10px;
	align: center;
}
</style>
</head>
<form>

	<div>

		<h1>Faculty Management System</h1>

		<a th:href="@{/}" class="btn btn-primary ms-3">Add NewEmployee </a>

		<table class="mt-3">
			<thead>
				<tr>
					<th>ID</th>
					<th>Faculty Name</th>
					<th>Faculty Address</th>
					<th>Actions</th>
				</tr>
			</thead>
			<tbody>
				<tr th:each="f2:${facultylist}">
					<td th:text="${f2.id}"></td>
					<td th:text="${f2.name}"></td>
					<td th:text="${f2.address}"></td>
					<td><a th:href="@{/update(id=${f2.id})}" class="btn btn-success">Update</a> 
					<a th:href="@{/del (id=${f2.id})}" class="btn btn-danger">Delete</a></td>
				</tr>
			</tbody>
		</table>

	</div>
</form>
</html>