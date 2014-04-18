<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="u" uri="ueye"%>

<!DOCTYPE html>
<html>

	<head>
		<title>用户信息</title>
		<jsp:include page="/common/header.jsp"/>
	</head>

	<body>
		
		<div class="container">
			
			<form id="validateForm" class="form-horizontal" method="post" action="<c:url value='/user/search'/>">
				<div class="search">
					<div class="row">
						<div class="span12">
							<div class="control-group">
					           	<span style="margin-left: 10px;">姓名 </span>
					            <input class="input-small" name="filter_LIKES_username" value="${filter_LIKES_username}"/>
					            <span style="margin-left: 10px;">添加日期： </span>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime}" onFocus="WdatePicker()" placeholder="开始日期"/>
					            <input class="input-small" name="filter_BAT_createDateTime" value="${filter_BAT_createDateTime_}" onFocus="WdatePicker()" placeholder="结束日期"/>
					            
							  	<button type="submit" class="btn btn-primary">查询</button>
							  	<a href="<c:url value='/logout'/>">logout</a>
					        </div>
						</div>
					  </div>
				</div>
				
				<div>
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th>编号</th>
								<th>名称</th>
								<th>添加日期</th>
								<th>操 作</th>
							</tr>
							<c:forEach var="user" items="${page.datas}">
								<tr>
									<td>${user.userid}</td>
									<td>${user.username}</td>
									<td>
										<u:dateFormat value="${user.createDateTime}"/>
									</td>
									<td>
										<sec:authorize ifAnyGranted="ROLE_ADMIN">
											<a href="${pageContext.request.contextPath}/user/edit/${user.userid}">修改</a>
										</sec:authorize>
										<a href="${pageContext.request.contextPath}/user/destroy/${user.userid}" class="deletePromptClass">删除</a>
									</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
					
					<jsp:include page="/common/page.jsp">
						<jsp:param name="actionURL" value="user"/>
					</jsp:include>
						
				</div>
				
			</form>
				
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
		
	</body>

</html>