<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<title>用户注册</title>
<jsp:include page="/common/header.jsp" />
</head>

<body>
	<span style="color: red">${errorMessages}</span>
	<div class="container">
		<div class="row">
			<form action="<c:url value='/user/register'/>" id="validateForm"
				class="form-horizontal" method="post">
				<table class="table table-bordered table-striped">
					<tbody>
						<tr>
							<th>用户名：</th>
							<td><input class="input-xlarge required" name="username"
								type="text" /></td>
						</tr>
						<tr>
							<th>密&nbsp;&nbsp;&nbsp;码：</th>
							<td><input class="input-xlarge required" name="password"
								type="password" /></td>
						</tr>
						<tr>
							<th>验证码：</th>
							<td><input class="input-xlarge required" name="j_captcha"
								type="text" /></td>
						</tr>
						<tr>
							<td colspan="2"><img id="captchaImg"
								src="<c:url value="/jcaptcha.jpg"/>" /> <span
								style="margin-left: 25px"><a
									href="javascript:refreshCaptcha()">看不清楚换一张</a> </span></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<div align="center">
									<button type="submit" class="btn btn-primary">注册</button>
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
<script type="text/javascript">
	function refreshCaptcha() {
		$('#captchaImg').hide().attr(
				'src',
				'<c:url value="/jcaptcha.jpg"/>' + '?'
						+ Math.floor(Math.random() * 100)).fadeIn();
	}
</script>
</html>