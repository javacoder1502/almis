<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">

<table class="table table-bordered" style="margin-top:10px;">
	<tr>
		<th style="background-color:#337ab7; color:#fff;">Category</th>
		<th style="background-color:#337ab7; color:#fff;">count</th>
	</tr>
	<c:forEach items="${CountAndValue}" var="CountAndValue">
	<tr>
		<td>${CountAndValue.value}</td>
		<td>${CountAndValue.count}</td>
	</tr>
	
	</c:forEach>
</table>