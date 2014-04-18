<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
	<head>
		<title>首页</title>
		<jsp:include page="/common/header.jsp" />
	</head>

	<body>
		<span style="color:red">${errorMessages}</span>
		<div class="container">
			<div class="row">
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th>Welcome -- ${serverTime}</th>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div align="center">
										<a href="<c:url value='/login'/>">登录</a>
										<a href="<c:url value='/user/register-new'/>">注册</a>
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
