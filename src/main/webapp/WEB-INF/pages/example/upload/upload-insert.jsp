<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

<head>
<title>Upload Files</title>
<jsp:include page="/common/header.jsp" />
</head>

<body>

	<div class="container">
		<div class="row">

			<form id="validateForm" class="form-horizontal" method="post"
				enctype="multipart/form-data"
				action="${pageContext.request.contextPath }/upload/uploadFile">
				<table class="table table-bordered table-striped">
					<tbody>
						<tr>
							<th>File: </th>
							<td><input class="input-xlarge required" name="uploadFile"
								type="file" /></td>
						</tr>
						<tr>
							<td colspan="2" align="center">
								<div align="center">
									<button type="submit" class="btn btn-primary">Add</button>
									<button type="button" class="btn btn-primary historyBackClass">Back</button>
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