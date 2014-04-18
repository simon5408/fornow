<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
	<head>
		<title>首页</title>
		<jsp:include page="/common/header.jsp" />
	</head>

	<body>
		<div class="container">
			<div class="row">
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th style="font-size:20pt;">403</th>
							</tr>
							<tr>
								<th style="color:red">Hello <sec:authentication property="principal.username"/>, you are not authorized to access this page!</th>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div align="center">
										<a href="<c:url value='/'/>">Back</a>
									</div>
								</td>
							</tr>							
						</tbody>
					</table>
			</div>
		</div>
		<jsp:include page="/common/footer.jsp" />
	</body>
</html>
