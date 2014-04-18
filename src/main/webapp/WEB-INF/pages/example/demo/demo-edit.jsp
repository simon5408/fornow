<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>

	<head>
		<title>Edit</title>
		<jsp:include page="/common/header.jsp"/>
	</head>

	<body>
	
		<div class="container">
			<div class="row">
					
				<form id="validateForm" class="form-horizontal" method="post" action="${pageContext.request.contextPath }/demo/update/${demo.id}">	
					<table class="table table-bordered table-striped">
						<tbody>
							<tr>
								<th>编码：</th>
								<td>
									<input name="id" value="${demo.id}" type="hidden"/>
									<input class="input-xlarge required" name="code" value="${demo.code}" type="text"/>
								</td>
							</tr>
							<tr>
								<th>字典类型名称：</th>
								<td>
									<input class="input-xlarge required" name="name" value="${demo.name}" type="text"/>
								</td>
							</tr>
							<tr>
								<td colspan="2" align="center">
									<div align="center">
										<button type="submit" class="btn btn-primary">提&nbsp;&nbsp;&nbsp;交</button>
										<button type="button" class="btn btn-primary historyBackClass">返&nbsp;&nbsp;&nbsp;回</button>
									</div>
								</td>
							</tr>							
						</tbody>
					</table>
				</form>	
						
			</div>
		</div>
		
		<jsp:include page="/common/footer.jsp"/>
		
	</body>

</html>