<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>TP3 - Thiago Aragão</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<link href="/styles/style.css" rel="stylesheet" type="text/css" />
</head>
<body>
	<div class="container">
		<div class="row content">

			<tl:if test="${ hasError  == 'false' }">
				<div class='col-md-6 mb-3'>
					<img src='/images/success.png' class='img-fluid' />
				</div>
				<div class='col-md-6'>
					<h3 class='sigin-text mb-3'>Ventura Hr Jobs</h3>
					<p>
						Hi <strong>${ name }</strong>, we are glad to see you here!
					</p>
					<p>Your register have been successfully done!</p>
					<p>
						A confirmation e-mail have been sent to your e-mail <strong>${ email }</strong>
					</p>
					<p>
						Click <a href='/'>here</a> to go back to the sign in page.
					</p>
				</div>
			</tl:if>
			<tl:if test="${ hasError  == 'true' }">
				<div class="col-md-6 mb-3">
					<img src="/images/errors.png" class="img-fluid" />
				</div>
				<div class="col-md-6">
					<h3 class="sigin-text mb-3">Ventura Hr Jobs</h3>
					<h4 class="sigin-text mb-3 text-danger">Houston we got
						problems!!!</h4>
					<p>
						Own no, <strong>Name</strong>, we had identified some problems on
						your informations.
					</p>
					<ul>
					<tl:forEach var="error" items="${ errors }">
						<li class="text-danger"><tl:out value="${ error }"></tl:out></li>
					</tl:forEach>
					</ul>
					<p>Don't worry, check what we found go back and fill the form
						with correct data!</p>
					<p>
						Click <a href="/User/SignUp">here</a> to go back to the
						sign up page.
					</p>
				</div>
			</tl:if>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>