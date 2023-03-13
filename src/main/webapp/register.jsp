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

	<title>Register</title>
</head>

<body class="background-radial-gradient overflow-hidden">

	<div class="container px-4 py-4 px-md-5 text-center text-lg-start my-3">
		<div class="row gx-lg-5 align-items-center mb-5">

			<div class="col-lg-6 position-relative">
				<div id="radius-shape-1" class="position-absolute rounded-circle shadow-5-strong"></div>
				<div id="radius-shape-2" class="position-absolute shadow-5-strong"></div>

				<div class="card bg-glass pt-4">
					<h2 class="text-center">Registro</h2>
					<div class="d-flex justify-content-center mb-1 pb-1">
						<span class="h1 fw-bold mb-0">
							<img src="https://altair.edu.es/wp-content/uploads/2022/05/LogoAltair-1.png" style="width: 180px; height: 75px" />
						</span>
					</div>
					
					<div class="card-body px-4 py-4 px-md-5">
						<form:form action="register" modelAttribute="userModel" method='POST'>
							<!-- Error message -->
							<c:if test="${param.username_already_exists != null}">
								<div class="alert alert-danger">
									<p>El nombre de usuario introducido ya existe.</p>
								</div>
							</c:if>
							<c:if test="${param.passwords_not_match != null}">
								<div class="alert alert-danger">
									<p>Las contraseñas no coinciden.</p>
								</div>
							</c:if>
							
							<!-- Email input -->
							<div class="form-outline mb-4">
								<input type="text" name="username" class="form-control" required />
								<label class="form-label">Usuario</label>
							</div>

							<!-- Password input -->
							<div class="form-outline mb-4">
								<input type="password" name="password" class="form-control" required />
								<label class="form-label">Contraseña</label>
							</div>
							
							<!-- Confirm Password input -->
							<div class="form-outline mb-4">
								<input type="password" name="confirmPassword" class="form-control" required />
								<label class="form-label">Repetir Contraseña</label>
							</div>

							<!-- Submit button -->
							<div class="d-flex justify-content-center">
								<input type="submit" value="Register" class="btn btn-primary btn-block mb-4 " />
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>