<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<table class="table table-bordered" style="margin-top:10px;">
	<tr>
		<th style="background-color:#337ab7; color:#fff;">${tbl_column1_display_name}</th>
		<th style="background-color:#337ab7; color:#fff;">${tbl_column2_display_name}</th>
	</tr>
	<c:forEach items="${CountAndValue}" var="CountAndValue">
	<tr>
		<td>${CountAndValue.value}</td>
		<td>${CountAndValue.count}</td>
	</tr>
	
	</c:forEach>
</table>