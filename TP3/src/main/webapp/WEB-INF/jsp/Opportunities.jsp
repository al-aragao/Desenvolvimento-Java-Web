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
		<div class="row content mb-10 mt-3">
			<div class="d-grid gap-2 col-4">
				<a href="/Opportunity" class="btn btn-outline-dark"> <i
					class="bi bi-plus-circle-fill"></i> Create a new opportunity
				</a>
			</div>
		</div>
		<div class="row content mt-2">
			<div class="col-md-12">
				<table
					class="table table-bordered table-striped table-hover align-middle">
					<thead>
						<tr>
							<th>Id</th>
							<th>Title</th>
							<th>Description</th>
							<th>Actions</th>
						</tr>
					</thead>
					<tbody>
						<tl:if test="${ empty opportunities }">
							<tr>
								<td colspan="4" class="text-center">No opportunities
									registered</td>
							</tr>
						</tl:if>
						<tl:if test="${ not empty opportunities }">
							<tl:forEach var="op" items="${ opportunities }">
								<tr>
									<td><tl:out value="${ op.getId() }" /></td>
									<td><tl:out value="${ op.getName() }" /></td>
									<td><tl:out value="${ op.getDescription() }" /></td>
									<td class="text-center">
										<%-- 										<a href="/Opportunity/${ op.getId() }/Edit" class="btn btn-outline-dark"><i class="bi bi-pencil-fill" style="font-size: 1.2rem;"></i></a> --%>
										<a href="/Opportunity/${ op.getId() }/Delete"
										class="btn btn-outline-dark"><i class="bi bi-trash-fill"
											style="font-size: 1.2rem;"></i></a>
									</td>
								</tr>
							</tl:forEach>

						</tl:if>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
		crossorigin="anonymous"></script>
</body>
</html>