<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<title>Send Mail</title>
<jsp:include page="/common/header.jsp" />
</head>

<body>
	<span style="color: red">${errorMessages}</span>
	<div class="container">
		<div class="row">
			<table class="table table-bordered table-striped">
				<tbody>
					<tr>
						<th>Subject: </th>
						<td><input class="input-xlarge required" name="mailSubject" id="mailSubject"
							type="text" value="this is test" /></td>
					</tr>
					<tr>
						<th>To Name: </th>
						<td><input class="input-xlarge required" name="mailToName" id="mailToName"
							type="text" value="Simon Lv" /></td>
					</tr>
					<tr>
						<th>To Email: </th>
						<td><input class="input-xlarge required" name="mailTo" id="mailTo"
							type="text" value="simon-jiafa@163.com" /></td>
					</tr>
					<tr>
						<th>Content：</th>
						<td><textarea rows="8" cols="20" name="mailContent" id="mailContent">This is testing for Spring Mail Server..</textarea></td>
					</tr>
					<tr>
						<td colspan="2" align="center">
							<div align="center">
								<button class="btn btn-primary" onclick="onSend();">Send</button>
							</div>
						</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
	<jsp:include page="/common/footer.jsp" />
	<script type="text/javascript">
		function onSend(){
			var mailSubject = $("#mailSubject").val();
			var mailToName = $("#mailToName").val();
			var mailTo = $("#mailTo").val();
			var mailContent = $("#mailContent").val();
			
			var reqJson = {
					mailSubject: mailSubject,
					mailToName: mailToName,
					mailTo: mailTo,
					mailContent: mailContent
			};
			
			$IEC.ajaxCall({
				success: function(data){
					alert("Send this message successfully.");
				},
	            error: function(data){
	            	alert("Send this message failure, please try again."); 
	            },
	            uri: "<c:url value='/sendMail'/>",
	            data: reqJson,
	            type: "POST"
			});
		}
	</script>
</body>
</html>
