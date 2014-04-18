<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" uri="ueye"%>

<!DOCTYPE html>
<html>

	<head>
		<title>Demo</title>
		<jsp:include page="/common/header.jsp"/>
	</head>

	<body>
		
		<div class="container">
			
			<form id="validateForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath}/demo/search">
				<div class="search">
					<div class="row">
						<div class="span12">
							<div class="control-group">
					           	<span style="margin-left: 10px;">编码 </span>
					            <input class="input-small" name="filter_LIKES_code" value="${filter_LIKES_code}"/>
					           	<span style="margin-left: 10px;">名称 </span>
					            <input class="input-small" name="filter_LIKES_name" value="${filter_LIKES_name}"/>
					            <span style="margin-left: 10px;">添加日期： </span>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime}" onFocus="WdatePicker()" placeholder="开始日期"/>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime_}" onFocus="WdatePicker()" placeholder="结束日期"/>
					            
							  	<button type="submit" class="btn btn-primary">查询</button>
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
										<a href="${pageContext.request.contextPath}/demo/edit-new">
											添加
										</a>
									</div>
								</th>
							</tr>
							<tr>
								<th>编号</th>
								<th>编码</th>
								<th>名称</th>
								<th>添加日期</th>
								<th>操 作</th>
							</tr>
							<c:forEach var="demo" items="${page.datas}">
								<tr>
									<td>${demo.id}</td>
									<td>${demo.code}</td>
									<td>${demo.name}</td>
									<td>
										<u:dateFormat value="${demo.createDateTime}"/>
									</td>
									<td>
										<a href="${pageContext.request.contextPath}/demo/edit/${demo.id}">修改</a>
										<a href="${pageContext.request.contextPath}/demo/destroy/${demo.id}" class="deletePromptClass">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<jsp:include page="/common/page.jsp">
						<jsp:param name="actionURL" value="demo"/>
					</jsp:include>
						
				</div>
				
			</form>
				
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
		
	</body>

</html>