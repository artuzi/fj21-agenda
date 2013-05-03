<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ attribute name="id" required="true"%>
<%@ attribute name="value" required="false" type="java.util.Date" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<input type="text" id="${id}" name="${id}" value=<fmt:formatDate value="${value}" pattern="dd/MM/yyyy"/>>
<script type="text/javascript">
	$("#${id}").datepicker({dateFormat: 'dd/mm/yy'});
</script>

