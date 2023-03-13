<%@ include file="/config/header.jsp" %>

<!DOCTYPE html>
<html>

<head>
	<meta charset="ISO-8859-1">
	
	<style type="text/css">
		@import url('https://fonts.googleapis.com/css?family=Lato');
		
		* {
		  position: relative;
		  margin: 0;
		  padding: 0;
		  box-sizing: border-box;
		  font-family: 'Lato', sans-serif;
		}
		
		body {
		  height: 100vh;
		  display: flex;
		  flex-direction: column;
		  justify-content: center;
		  align-items: center;
		  background: linear-gradient(to bottom right, #EEE, #AAA);
		}
		
		h1 {
		  margin: 40px 0 20px;
		}
	</style>
	
	<title>Error 403 Forbiden</title>
</head>

<body>
	<div class="container">
		<a class="btn btn-warning mt-2 px-2 text-white" onCLick="history.back()">
			<i class="fa fa-arrow-left" aria-hidden="true"></i>
		</a>
	</div>
	
	<div>
		<img src="https://cdn-icons-png.flaticon.com/512/269/269099.png" width="350px" height="350px" />
	</div>
	
	<div class="message">
	  <h1>Access to this page is restricted</h1>
	  <p>Please check with the site admin if you believe this is a mistake.</p>
	  
	  <div class="d-flex justify-content-center">
	   	<form:form action="logout" method='POST' class="col-12 col-lg-auto mb-3 mb-lg-0 me-lg-3">
	       	<input type="submit" value="Logout" class="btn btn-outline-light me-2" />
	    </form:form>
		&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
		<p class="lead">
		  <a href="<c:url value="/" />" class="btn btn-lg btn-secondary fw-bold border-black bg-black">Index</a>
		</p>
	  </div>
	</div>
</body>

</html>