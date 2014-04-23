<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script type="text/javascript">
<!--
	var basePath = "${pageContext.request.contextPath}";
//-->
</script>

<script type="text/javascript" src="<c:url value='/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/ieCommon.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/twitter/bootstrap.min.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/twitter/bootstrap-modal.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/twitter/bootstrap-tooltip.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/plugins/validate/jquery.validate.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/plugins/validate/jquery.metadata.js'/>"></script>
<script type="text/javascript" src="<c:url value='/js/plugins/validate/messages_cn.js'/>"></script>

<script type="text/javascript" src="<c:url value='/js/date/WdatePicker.js'/>"></script>

<script type="text/javascript">
	$(document).ready(function() {
		$("#validateForm").validate();
		$("button").filter(".historyBackClass").each(function(i) {
			$(this).bind("click", function() {
				javascript:history.back(); 
			});
		});
	});
	
</script>
