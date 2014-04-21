<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="ueye"%>

<!DOCTYPE html>
<html>

	<head>
		<title>Upload</title>
		<jsp:include page="/common/header.jsp"/>
	</head>

	<body>
		
		<div class="container">
			
			<form id="validateForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/upload/search">
				<div class="search">
					<div class="row">
						<div class="span12">
							<div class="control-group">
					            <span style="margin-left: 10px;">Date: </span>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime}" onFocus="WdatePicker()" placeholder="Start Date"/>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime_}" onFocus="WdatePicker()" placeholder="End Date"/>
					            
							  	<button type="submit" class="btn btn-primary">Search</button>
					        </div>
						</div>
					  </div>
				</div>
				
				<div>
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th  class="th" colspan="7" align="right">
									<div align=right style="margin-right:10px;">
										<a href="${pageContext.request.contextPath}/upload/edit-new">
											Add
										</a>
									</div>
								</th>
							</tr>
							<tr>
								<th>No.</th>
								<th>Addr</th>
								<th>Date</th>
								<th></th>
							</tr>
							<c:forEach var="uploadFiles" items="${page.datas}">
								<tr>
									<td>${uploadFiles.uploadid}</td>
									<td>${uploadFiles.filepath}</td>
									<td>
										<u:dateFormat value="${uploadFiles.createDateTime}"/>
									</td>
									<td>
										<a href="${pageContext.request.contextPath}/upload/edit/${uploadFiles.uploadid}">Edit</a>
										<a href="${pageContext.request.contextPath}/upload/destroy/${uploadFiles.uploadid}" class="deletePromptClass">Delete</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<jsp:include page="/common/page.jsp">
						<jsp:param name="actionURL" value="uploadFiles"/>
					</jsp:include>
						
				</div>
				
			</form>
				
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
		
	</body>

</html>