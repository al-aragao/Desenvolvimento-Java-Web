<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="tl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
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
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.7.1/font/bootstrap-icons.css">
</head>
<body>
	<tl:import url="/WEB-INF/jsp/Menu.jsp"></tl:import>

	<div class="container">
		
		<div class="row content mt-2">
			<div class="col-md-12">
				<h1>Create a new opportunity</h1>
				
                <div class="col-md-6">                    
                    <form class="mb-3" action="/Opportunity" method="POST">
                        <div class="form-group mb-3">
                            <label for="name">Name</label>
                            <input class="form-control" type="text" name='name' value="Angular Senior developer" size="100" maxlength="100"/>
                        </div>
                        <div class="form-group mb-3">
                            <label for="description">Description</label>
                            <input  class="form-control" type="text" value="Opportunity to work on a startup as a Angular Senior developer" name="description" />
                        </div>
                        
                        <tl:if test="${not empty errorMessages }">
							<div class="mb-3">
								<ul>
									<tl:forEach var="error" items="${ errorMessages }">
										<li class="text-danger"><tl:out value="${ error }"></tl:out></li>
									</tl:forEach>
								</ul>
							</div>
						</tl:if>
						
						<a class="btn btn-outline-dark" href="/Opportunities">Cancel</a>
                        <button class="btn btn-dark" type="submit" name="submit">Create</button>
                    </form>
                </div>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>