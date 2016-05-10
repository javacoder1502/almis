<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

	<script src="<c:url value="/resources/scripts/allScript.js" />"></script>					


							<table class="table table-bordered" style="margin-top:10px;">
								<tr>
								<th style="background-color:#337ab7; color:#fff;">${tbl_column1_display_name}</th>
								<th style="background-color:#337ab7; color:#fff;">${tbl_column2_display_name}</th>
								<th style="background-color:#337ab7; color:#fff;">${tbl_column3_display_name}</th>
								
									
								</tr>

								<c:forEach items="${contentPrvCount}" var="contentPrvCount">
									<tr>
										<td>${contentPrvCount.content_prv}</td>
										<td>${contentPrvCount.name}</td>
										<td>${contentPrvCount.count}</td>

									</tr>
								</c:forEach>


								<tr>
									<td>Total_pages</td>
									<td></td>
									<td>${total_pages}</td>
								</tr>
							</table>


					<c:forEach begin="1" end="${total_pages}" var="val">
						<a onClick="displayPage('${onClickPageUrl}','${val}');" href="#">${val}</a>

					</c:forEach>
				