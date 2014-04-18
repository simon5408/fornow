<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>用户编辑</title>
<jsp:include page="/common/header.jsp" />
</head>

<body>
	<span style="color:red">${errorMessages}</span>
	<div class="container">
		<div class="row">
			<form action="<c:url value='/user/update/${user.userid}'/>" id="validateForm" class="form-horizontal" method="post" >
				<input type="hidden" name="userid" value="${user.userid}">
				<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th>用户名：</th>
								<td>
									<input class="input-xlarge required" name="username" value="${user.username}" readonly type="text"/>
								</td>
							</tr>
							<tr>
								<th>密&nbsp;&nbsp;&nbsp;码：</th>
								<td>
									<input class="input-xlarge required" name="password" type="password"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div align="center">
										<button type="submit" class="btn btn-primary">提交</button>
										<button type="button" class="btn btn-primary historyBackClass">返回</button>
									</div>
								</td>
							</tr>							
						</tbody>
					</table>
			</form>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
</body>
</html>