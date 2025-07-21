<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page
	import="org.json.* ,java.util.List, ca.seneca.FilmServlet, ca.seneca.Film"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Universities in Canada</title>
<link
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"
	rel="stylesheet" />

<style>
th {
	border-style: solid;
	border-color: black;
}

.table .thead-dark th {
	background-color: black;
}
</style>
</head>
<body>
	<nav class="navbar navbar-dark bg-primary justify-content-between py-3">
		<a class="navbar-brand">Navbar</a>
		<form class="form-inline" method="get" action="FilmServlet">
			<input class="form-control mr-sm-2" type="search"
				name="search" placeholder="Search" aria-label="Search" >
			<button class="btn  my-2 my-sm-0" type="submit">🔍</button>
		</form>
	</nav>

	<div class="container mt-5">
		<h1 class="text-center mb-4">Customers</h1>
		<%
		List<Film> films = (List<Film>) request.getAttribute("films");
		%>
		<table class="table table-striped">
			<thead class="thead-dark">
				<tr>
					<th scope="col">FirstName</th>
					<th scope="col">LastName</th>
					<th scope="col">Email</th>

				</tr>
			</thead>
			<tbody>
				<%
				for (Film film : films) {
				%>

				<tr>
					<td><%=film.getFirst_name()%></td>
					<td><%=film.getLast_name()%>
					<td><%=film.getEmail()%></td>
				</tr>
				<%
				}
				%>

			</tbody>
		</table>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
	<script
		src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>
