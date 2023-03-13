<%@ include file="/config/header.jsp" %>

<html>

<head>
	<meta charset="UTF-8">
	<meta name="theme-color" content="#712cf9">
	<title>Register Form</title>
</head>
 
<body>
	<header class="p-3 text-bg-dark">
	    <div class="container">
	      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
	
	        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	          <li><a href="<c:url value="/" />" class="nav-link px-2 text-secondary">Home</a></li>
	          <li><a href="<c:url value="navigateToAlumnos" />" class="nav-link px-2 text-white">Alumnos</a></li>
	          <li><a href="<c:url value="navigateToPortatiles" />" class="nav-link px-2 text-white">Portátiles</a></li>
	      	</ul>
	
	        <form class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3" role="search">
	          <input type="search" class="form-control form-control-dark text-bg-dark" placeholder="Search..." aria-label="Search">
	        </form>
	
	        <div class="d-flex justify-content-end">
	        	<h3><sec:authentication property="principal.username" /></h3>
	          	<form:form action="logout" method='POST' class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
	        		<input type="submit" value="Logout" class="btn btn-outline-light me-2" />
	    		</form:form>
	        </div>
	      </div>
	    </div>
	</header>
    
    <div class="container">
    	<a class="btn btn-warning mt-2 px-2 text-white" onCLick="history.back()">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>
		</a>
    	
    	<h1 class="text-center">Formulario de Registro de Portátiles</h1>
    	
    	<form:form method="POST" action="formCreateAlumno" modelAttribute="alumnoModel">
	    	<table>
	        	<tr class="mb-3">
	             	<td><form:label path="alumno_nombre" for="alumno_nombre" class="form-label">Nombre</form:label></td>
	                <td><form:input path="alumno_nombre" type="text" class="form-control" id="alumno_nombre" placeholder="nombre..." /></td>
	            </tr>
	            <tr>
	              	<td><form:label path="alumno_apellidos" for="alumno_apellidos" class="form-label">Apellidos</form:label></td>
	                <td><form:input path="alumno_apellidos" type="text" class="form-control" id="alumno_apellidos" placeholder="apellidos..." /></td>
	            </tr>
	            <tr>
	              	<td><form:label path="alumno_telefono" for="alumno_telefono" class="form-label">Teléfono</form:label></td>
	                <td><form:input path="alumno_telefono" type="text" class="form-control" id="alumno_telefono" placeholder="teléfono..." /></td>
	            </tr>
	            <tr>
	              	<td><form:label path="portatil_id" for="portatil_id" class="form-label">Portátil ID</form:label></td>
	                <td><form:input path="portatil_id" type="text" class="form-control" id="portatil_id" placeholder="portátil ID..." /></td>
	            </tr>
	                
	            <tr>
	              	<td><input type="submit" class="btn btn-primary" value="Registrar Alumno"/></td>
	            </tr>
	        </table>
	  	</form:form>
	  	
	  	<h2 class="text-center">Portátiles Disponibles</h2>
	  	<table class="table table-dark table-hover">
 			<thead>
				<tr>
					<th scope="col">UUID</th>
					<th scope="col">DATE</th>
					<th scope="col">ID</th>
					<th scope="col">Marca</th>
					<th scope="col">Modelo</th>
				</tr>
			</thead>
			<c:forEach var="portatilModel" items="${listaPortatiles}">
				<tbody>
					<c:choose>
						<c:when test="${portatilModel.alumno.alumno_id == null}">
							<tr>
								<td><c:out value="${portatilModel.portatil_uuid}" /></td>
								<td><c:out value="${portatilModel.portatil_date.getTime()}" /></td>
								<td><c:out value="${portatilModel.portatil_id}" /></td>
								<td><c:out value="${portatilModel.portatil_marca}" /></td>
								<td><c:out value="${portatilModel.portatil_modelo}" /></td>
							</tr>
						</c:when>
						<c:otherwise>
							<tr></tr>
						</c:otherwise>
					</c:choose>
				</tbody>
			</c:forEach>
		</table> 
    </div>
  	
  	<footer class="py-5 text-bg-dark">
	    <div class="row">
	      <div class="col-6 col-md-2 mb-3">
	        <h5>Section</h5>
	        <ul class="nav flex-column">
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Features</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Pricing</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
	        </ul>
	      </div>
	
	      <div class="col-6 col-md-2 mb-3">
	        <h5>Section</h5>
	        <ul class="nav flex-column">
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Features</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Pricing</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
	        </ul>
	      </div>
	
	      <div class="col-6 col-md-2 mb-3">
	        <h5>Section</h5>
	        <ul class="nav flex-column">
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Home</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Features</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">Pricing</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">FAQs</a></li>
	          <li class="nav-item mb-2"><a href="#" class="nav-link p-0 text-muted">About</a></li>
	        </ul>
	      </div>
	
	      <div class="col-md-5 offset-md-1 mb-3">
	        <form>
	          <h5>Subscribe to our newsletter</h5>
	          <p>Monthly digest of what's new and exciting from us.</p>
	          <div class="d-flex flex-column flex-sm-row w-100 gap-2">
	            <label for="newsletter1" class="visually-hidden">Email address</label>
	            <input id="newsletter1" type="text" class="form-control" placeholder="Email address">
	            <button class="btn btn-primary" type="button">Subscribe</button>
	          </div>
	        </form>
	      </div>
	    </div>
	
	    <div class="d-flex flex-column flex-sm-row justify-content-between py-4 my-4 border-top">
	      <p>&copy; 2022 Company, Inc. All rights reserved.</p>
	    </div>
	</footer>
	
 </body>

</html>