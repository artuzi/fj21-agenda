<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib tagdir="/WEB-INF/tags" prefix="caelum"%>
<html>
<head>

<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
<link type="text/css" href="<c:url value='/resources/css/jquery.css'/>" rel="stylesheet"/>


<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adicionar contato</title>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	<form action="<c:url value='/contato/grava'/>" method="post">
		Nome: <input type="text" name="nome" /><br/>
		E-mail: <input type="text" name="email"/> <br/>
		Endereço: <input type="text" name="endereco"/> <br/>
		Data Nascimento: <caelum:campoData id="dataNascimento"/><br/> 
		Parametro 1 informado: ${param.param1}<br/>
		Parametro 2 informado: ${param.param2}<br/>
		<input type="submit" value="Gravar"/>
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>