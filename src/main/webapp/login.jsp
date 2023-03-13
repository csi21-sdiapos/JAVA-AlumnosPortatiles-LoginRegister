<%@ include file="/config/header.jsp" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">

	<style>
		.background-radial-gradient {
			background-color: hsl(218, 41%, 15%);
			background-image: radial-gradient(650px circle at 0% 0%,
					hsl(218, 41%, 35%) 15%,
					hsl(218, 41%, 30%) 35%,
					hsl(218, 41%, 20%) 75%,
					hsl(218, 41%, 19%) 80%,
					transparent 100%),
				radial-gradient(1250px circle at 100% 100%,
					hsl(218, 41%, 45%) 15%,
					hsl(218, 41%, 30%) 35%,
					hsl(218, 41%, 20%) 75%,
					hsl(218, 41%, 19%) 80%,
					transparent 100%);
		}

		#radius-shape-1 {
			height: 220px;
			width: 220px;
			top: -60px;
			left: -130px;
			background: radial-gradient(#44006b, #ad1fff);
			overflow: hidden;
		}

		#radius-shape-2 {
			border-radius: 38% 62% 63% 37% / 70% 33% 67% 30%;
			bottom: -60px;
			right: -110px;
			width: 300px;
			height: 300px;
			background: radial-gradient(#44006b, #ad1fff);
			overflow: hidden;
		}

		.bg-glass {
			background-color: hsla(0, 0%, 100%, 0.9) !important;
			backdrop-filter: saturate(200%) blur(25px);
		}
	</style>

	<title>Login</title>
</head>

<body class="background-radial-gradient overflow-hidden">

	<div class="container px-4 py-4 px-md-5 text-center text-lg-start my-3">
		<div class="row gx-lg-5 align-items-center mb-5">
			<div class="col-lg-6 mb-5 mb-lg-0" style="z-index: 10">
				<h1 class="my-5 display-5 fw-bold ls-tight" style="color: hsl(218, 81%, 95%)">
					Proyecto de Spring Framework MVC<br />
					<span style="color: hsl(218, 81%, 75%)">AlumnosPortatiles</span>
				</h1>
				<p class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%)">
					En esta continuación del proyecto de AlumnosPortatiles hemos implementado este login 
					con Security Web y Security Config, y más adelante también incluiremos los roles de Admin, Employee y User.<br/><br/>
					Los usuarios de prueba son:
					<ul class="mb-4 opacity-70" style="color: hsl(218, 81%, 85%); list-style: none;">
						<li>sergio --> 123 --> Admin</li>
						<li>moises --> 123 --> Employee</li>
						<li>javier --> 123 --> user</li>
					</ul>
				</p>
			</div>

			<div class="col-lg-6 position-relative">
				<div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
				<div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

				<div class="card bg-glass pt-4">
					
					<div class="d-flex justify-content-center mb-1 pb-1">
						<span class="h1 fw-bold mb-0">
							<img src="https://altair.edu.es/wp-content/uploads/2022/05/LogoAltair-1.png" style="width: 180px; height: 75px" />
						</span>
					</div>
					
					<div class="card-body px-4 py-4 px-md-5">
						<form:form action="loginUser" method='POST'>
							<!-- Error message -->
							<c:if test="${param.error != null}">
								<div class="alert alert-danger">
									<p>Usuario o contraseña incorrectos.</p>
								</div>
							</c:if>
							<c:if test="${param.logout != null}">
								<div class="alert alert-warning">
									<p>Has cerrado sesión. Hasta pronto!</p>
								</div>
							</c:if>
							<c:if test="${param.registered != null}">
								<div class="alert alert-success">
									<p>El nuevo usuario ha sido registrado.</p>
								</div>
							</c:if>
						
							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="text" name="username" class="form-control" />
								<label class="form-label">Usuario</label>
							</div>

							<!-- Password input -->
							<div class="form-outline mb-4">
								<input type="password" name="password" class="form-control" />
								<label class="form-label">Contraseña</label>
							</div>

							<!-- Checkbox -->
							<div class="form-check d-flex justify-content-center mb-4">
								<input class="form-check-input me-2" type="checkbox" checked />
								<label class="form-check-label">Recordar inicio de sesión</label>
							</div>

							<!-- Submit button -->
							<div class="d-flex justify-content-center">
								<input type="submit" value="Login" class="btn btn-primary btn-block mb-4" />
								&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
								<a href="<c:url value="/navigateToRegister" />">
									<input type="button" value="Register" class="btn btn-warning btn-block mb-4" />
								</a>
							</div>

							<!-- Register buttons -->
							<div class="text-center">
								<p>or login with:</p>
								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-facebook-f"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-google"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-twitter"></i>
								</button>

								<button type="button" class="btn btn-link btn-floating mx-1">
									<i class="fab fa-github"></i>
								</button>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>