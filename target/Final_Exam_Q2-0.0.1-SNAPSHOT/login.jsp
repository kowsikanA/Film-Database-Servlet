<%@ page language="java" contentType="text/html; charset=UTF-8"
		pageEncoding="UTF-8"%>
	<%@ taglib prefix="c" uri="jakarta.tags.core"%>

	<!DOCTYPE html>
	<html>
	<head>
	<meta charset="UTF-8">
	<title>Login Page</title>
	<link href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css" rel="stylesheet" />
	<style>
		body {
			background: linear-gradient(to right, #6a11cb, #2575fc);
			height: 100vh;
			display: flex;
			justify-content: center;
			align-items: center;
			color: black;
		}

		.container {
			background: rgba(255, 255, 255, 0.9);
			padding: 30px;
			border-radius: 10px;
			box-shadow: 0 4px 8px rgba(0, 0, 0, 0.2);
			max-width: 400px;
		}

		.btn-submit {
			width: 100%;
			max-width: 200px;
			margin: 20px auto 0;
			display: block;
		}

	   
	</style>
	</head>
	<body>
		<div class="container">
			<h2 class="text-center mb-4">Login</h2>
			<form method="get" action="LoginServlet">
				<div class="form-group">
					<label for="email">Email:</label>
					<input type="email" class="form-control" id="email" name="email" required="required" />
				</div>
				<div class="form-group">
					<label for="password">Password:</label>
					<input type="password" class="form-control" id="password" name="password" required="required" />
				</div>
				<button type="submit" class="btn btn-primary btn-submit">Login</button>
			</form>
			
			<br />
			
			<c:if test="${not empty message}">
				<c:choose>
					<c:when test="${message == 'success'}">
						<div class="alert alert-success">Login Successful</div>
					</c:when>
					<c:otherwise>
						<div class="alert alert-danger">Login not Successful. Please try again</div>
					</c:otherwise>
				</c:choose>
			</c:if>
		</div>
	</body>
	</html>