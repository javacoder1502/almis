<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>Airtel-mis</title>

<!-- Bootstrap Core CSS -->
<link href="<c:url value="/resources/css/bootstrap.min.css" />"
	rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<c:url value="/resources/css/metisMenu.min.css" />"
	rel="stylesheet">

<!-- Custom CSS -->
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<c:url value="/resources/css/font-awesome.min.css" />"
	rel="stylesheet" type="text/css">

</head>

<body>

	<div id="wrapper">
		<jsp:include page="/WEB-INF/headers/header.jsp" />



		<!-- Page Content -->
		<div id="page-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">
						<center>
							<h1 class="page-header">Airtel-Mis</h1>
						</center>
					</div>

					<table class="table table-bordered" style="margin-top: 10px;">
						<tr>
							<th style="background-color: #337ab7; color: #fff;">${tbl_column1_display_name}</th>
							<th style="background-color: #337ab7; color: #fff;">${tbl_column2_display_name}</th>
						</tr>
						<c:forEach items="${CountAndValue}" var="CountAndValue">
							<tr>
								<td>${CountAndValue.value}</td>
								<td>${CountAndValue.count}</td>
							</tr>

						</c:forEach>
					</table>
					<section class="display-area"></section>
				</div>
				<!-- /.row -->
			</div>
			<!-- /.container-fluid -->
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<c:url value="/resources/js/bootstrap.min.js" />"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<c:url value="/resources/js/metisMenu.min.js" />"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<c:url value="/resources/js/admin.js" />"></script>

</body>

</html>
