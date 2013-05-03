<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib tagdir="/WEB-INF/tags" prefix="caelum" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/resources/js/jquery-ui.js'/>"></script>
	<link type="text/css" href="<c:url value='/resources/css/jquery.css'/>" rel="stylesheet"/>
</head>
<body>
	<c:import url="cabecalho.jsp"></c:import>
	Formulário para alteração de contatos:<br/>
	
	<form action="<c:url value='/contato/alteraContatoLogic'/>" method="post">
		Id:
			<input type="text" name="id" value="${contatos.id}"/> <br/>
		Nome: 
			<input type="text" name="nome" value="${contatos.nome}" /> <br/>
		E-mail:
			<input type="text" name="email" value="${contatos.email}"/> <br/>
		Endereço:
			<input type="text" name="endereco" value="${contatos.endereco}"/> <br/>
		Data de Nascimento:
			<caelum:campoData id="dataNascimento" value="${contatos.dataNascimento.time}"/>
			<input type="hidden" name="logica" value="AlteraContatoLogic"/>
			<input type="submit" value="Enviar"/>
	</form>
	<c:import url="rodape.jsp"></c:import>
</body>
</html>