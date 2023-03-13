<%@ include file="/config/header.jsp" %>

<html>

<head>
	<meta charset="UTF-8">
	<meta name="theme-color" content="#712cf9">
	<title>Alumnos</title>
	
	<style type="text/css">
		body {
			font-family: 'Varela Round', sans-serif;
		}
		.modal-confirm {		
			color: #636363;
			width: 400px;
		}
		.modal-confirm .modal-content {
			padding: 20px;
			border-radius: 5px;
			border: none;
			text-align: center;
			font-size: 14px;
		}
		.modal-confirm .modal-header {
			border-bottom: none;   
			position: relative;
		}
		.modal-confirm h4 {
			text-align: center;
			font-size: 26px;
			margin: 30px 0 -10px;
		}
		.modal-confirm .close {
			position: absolute;
			top: -5px;
			right: -2px;
		}
		.modal-confirm .modal-body {
			color: #999;
		}
		.modal-confirm .modal-footer {
			border: none;
			text-align: center;		
			border-radius: 5px;
			font-size: 13px;
			padding: 10px 15px 25px;
		}
		.modal-confirm .modal-footer a {
			color: #999;
		}		
		.modal-confirm .icon-box {
			width: 80px;
			height: 80px;
			margin: 0 auto;
			border-radius: 50%;
			z-index: 9;
			text-align: center;
			border: 3px solid #f15e5e;
		}
		.modal-confirm .icon-box i {
			color: #f15e5e;
			font-size: 46px;
			display: inline-block;
			margin-top: 13px;
		}
		.modal-confirm .btn, .modal-confirm .btn:active {
			color: #fff;
			border-radius: 4px;
			background: #60c7c1;
			text-decoration: none;
			transition: all 0.4s;
			line-height: normal;
			min-width: 120px;
			border: none;
			min-height: 40px;
			border-radius: 3px;
			margin: 0 5px;
		}
		.modal-confirm .btn-secondary {
			background: #c1c1c1;
		}
		.modal-confirm .btn-secondary:hover, .modal-confirm .btn-secondary:focus {
			background: #a8a8a8;
		}
		.modal-confirm .btn-danger {
			background: #f15e5e;
		}
		.modal-confirm .btn-danger:hover, .modal-confirm .btn-danger:focus {
			background: #ee3535;
		}
		.trigger-btn {
			display: inline-block;
			margin: 100px auto;
		}
	</style>
	
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css">
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js"></script>
</head>

<body>
	<header class="p-3 text-bg-dark">
	    <div class="container">
	      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
	
	        <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
	          <li><a href="<c:url value="/" />" class="nav-link px-2 text-secondary">Home</a></li>
	          <li><a href="<c:url value="navigateToAlumnos" />" class="nav-link px-2 text-white">Alumnos</a></li>
	          <li><a href="<c:url value="navigateToPortatiles" />" class="nav-link px-2 text-white">Portatiles</a></li>	         
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
		
		<form method="post" action="findPortatilByAlumnoId">
			<div class="modal-body">
				<div class="form-group">
					<label>Introduzca el ID de un alumno para consultar su portatil asignado</label>
					<input id="alumno_id" name="alumno_id" type="text" class="form-control" required="required" />
				</div>
			</div>
			<div class="modal-footer justify-content-center">
				<input type="submit" class="btn btn-primary" value="buscar" />
			</div>
		</form>
		
		<c:choose>
			<c:when test="${portatilModel != null}">
				<table class="table table-dark table-hover">
		 			<thead>
						<tr>
							<th scope="col">Alumno ID</th>
							<th scope="col">Nombre</th>
							<th scope="col">Apellidos</th>
							<th scope="col"><i class="fa fa-long-arrow-right" aria-hidden="true"></i></th>
							<th scope="col">Portatil ID</th>
							<th scope="col">Marca</th>
							<th scope="col">Modelo</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><c:out value="${alumnoModel.alumno_id}" /></td>
							<td><c:out value="${alumnoModel.alumno_nombre}" /></td>
							<td><c:out value="${alumnoModel.alumno_apellidos}" /></td>
							<td><i class="fa fa-long-arrow-right" aria-hidden="true"></i></td>
							<td><c:out value="${portatilModel.portatil_id}" /></td>
							<td><c:out value="${portatilModel.portatil_marca}" /></td>
							<td><c:out value="${portatilModel.portatil_modelo}" /></td>
						</tr>
					</tbody>
				</table>
			</c:when>    
			<c:otherwise>
				
			</c:otherwise>
		</c:choose>
		

		
		<div class="d-flex justify-content-between">
			<h1 class="text-center">Lista de alumnos</h1>
			<a href="<c:url value="navigateToCreateFormAlumno" />" class="btn btn-success px-2 py-2 mb-2 text-white">Nuevo Alumno</a>
		</div>
		<table class="table table-dark table-hover">
 			<thead>
				<tr>
					<th scope="col">UUID</th>
					<th scope="col">DATE</th>
					<th scope="col">ID</th>
					<th scope="col">Nombre</th>
					<th scope="col">Apellidos</th>
					<th scope="col">Teléfono</th>
					<th scope="col">Portátil ID</th>
					<th scope="col">Editar/Eliminar</th>
				</tr>
			</thead>
			<c:forEach var="alumnoModel" items="${listaAlumnos}">
				<tbody>
					<tr>
						<td><c:out value="${alumnoModel.alumno_uuid}" /></td>
						<td><c:out value="${alumnoModel.alumno_date.getTime()}" /></td>
						<td><c:out value="${alumnoModel.alumno_id}" /></td>
						<td><c:out value="${alumnoModel.alumno_nombre}" /></td>
						<td><c:out value="${alumnoModel.alumno_apellidos}" /></td>
						<td><c:out value="${alumnoModel.alumno_telefono}" /></td>
						<td><c:out value="${alumnoModel.portatil.portatil_id}" /></td>
						<td>
							<sec:authorize access="hasRole('ADMIN')">
								<a href="editAlumno?alumno_id=${alumnoModel.alumno_id}" onclick="openEditModal();" data-toggle="modal" class="edit btn btn-warning px-2 text-white">
									<i class="fa fa-pencil" aria-hidden="true"></i>
								</a>
								<!--<a href="navigateToEditFormAlumno/?alumno_id=${alumnoModel.alumno_id}" class="btn btn-warning px-2 text-white">Editar</a>-->
							
								<a href="deleteAlumno?alumno_id=${alumnoModel.alumno_id}" onclick="openDeleteModal();" data-toggle="modal" class="delete btn btn-danger px-2 text-white">
									<i class="fa fa-trash" aria-hidden="true"></i>
								</a>
								<!--<a href="deleteAlumno?alumno_id=${alumnoModel.alumno_id}">Eliminar Sin Modal</a> -->
								
								<input type="hidden" id="id" value="${alumnoModel.alumno_id}" />
							</sec:authorize>
						</td>
					</tr>
				</tbody>
				
				
				<!-- --------------------------------- Edit Modal -------------------------------------------------- -->
				
				<div id="editModal" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<form method="post" action="editAlumno">
								<div class="modal-header flex-column">
									<div class="icon-box">
										<i class="material-icons">&#xf040;</i>
									</div>						
									<h4 class="modal-title w-100">Editar (No funciona)</h4>	
									<button type="button" onclick="closeEditModal();" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">
									<div class="form-group">
										<label>Nombre</label>
										<input id="nombre" name="nombre" type="text" class="form-control" required="required" />
									</div>
									<div class="form-group">
										<label>Apellidos</label>
										<input id="apellidos" name="apellidos" type="text" class="form-control" required="required" />
									</div>
									<div class="form-group">
										<label>Teléfono</label>
										<input id="telefono" name="telefono" type="text" class="form-control" required="required" />
									</div>
								</div>
								<div class="modal-footer justify-content-center">
									<button type="button" onclick="closeEditModal();" class="btn btn-secondary" data-dismiss="modal">Cancel</button>
									<input type="submit" class="btn btn-danger" value="Edit" />
									
									<input type="hidden" name="id" id="id" />
								</div>
							</form>
						</div>
					</div>
				</div>  
				
				<!-- --------------------------------- Delete Modal --------------------------------------------- -->
				
				<div id="deleteModal" class="modal fade">
					<div class="modal-dialog modal-confirm">
						<div class="modal-content">
							<form method="post" action="deleteAlumno">
								<div class="modal-header flex-column">
									<div class="icon-box">
										<i class="material-icons">&#xE5CD;</i>
									</div>							
									<h4 class="modal-title w-100">Are you sure?</h4>	
									<button type="button" onclick="closeDeleteModal();" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
								</div>
								<div class="modal-body">
									<p>Do you really want to delete these records? This process cannot be undone.</p>
								</div>
								<div class="modal-footer justify-content-center">
									<button type="button" onclick="closeDeleteModal();" class="btn btn-secondary" data-dismiss="modal">Cancel</button>			
									<input type="submit" class="btn btn-danger" value="Delete" />
									
									<input type="hidden" name="id" id="id" />
								</div>
							</form>
						</div>
					</div>
				</div>
				 
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
	
	<!-- -------------------------------------- Scripts ----------------------------------------- -->
	<script type="text/javascript">
		function openEditModal() {
			$('#editModal').modal('show');
		}
	</script>
	<script type="text/javascript">
		function closeEditModal() {
			$('#editModal').modal('hide');
		}
	</script>
	
	<script type="text/javascript">
		function openDeleteModal() {
			$('#deleteModal').modal('show');
		}
	</script>
	<script type="text/javascript">
		function closeDeleteModal() {
			$('#deleteModal').modal('hide');
		}
	</script>
	
	<script type="text/javascript">
		function openViewModal() {
			$('#viewModal').modal('show');
		}
	</script>
	<script type="text/javascript">
		function closeViewModal() {
			$('#viewModal').modal('hide');
		}
	</script>
	
	<script type="text/javascript">		
		$(document).ready(function(){
			$('table .delete').on('click', function(){
				var id = $(this).parent().find('#id').val();
				$('#deleteModal #id').val(id);
			});
		});
	</script>
</body>

</html>