<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Lista contatos</title>
</head>
<body>

<c:import url="cabecalho.jsp"></c:import>

<jsp:useBean id="dao" class="br.com.caelum.agenda.dao.ContatoDao"></jsp:useBean>

<table>
   <tr>
		<th>Nome</th>
		<th>Email</th>
		<th>Endereco</th>
		<th align="center">Data Nascimento</th>
		<th>Excluir</th>

   </tr>

<c:forEach var="contato" items="${dao.lista}" varStatus="i">
   <tr bgcolor="#${i.count%2==0?'#f0f0f0':'#cccccc'}">
	  <td>${contato.nome}</td>
	  <td>
	    <c:if test="${not empty contato.email}">
	     <a href="mailto:${contato.email}">${contato.email}</a>
	    </c:if>
	    <c:if test="${empty contato.email}">
	     E-mail não informado
	    </c:if>

	  </td>
	  <td>${contato.endereco}</td>
	  <td align="center"><fmt:formatDate value="${contato.dataNascimento.time}"
	  pattern="dd/MM/yyyy"/></td>
	  <td align="center"> <a href="<c:url value='/contato/exclui?id=${contato.id}'/>">...</a> </td>
   </tr>
   
</c:forEach>
</table>

<c:import url="rodape.jsp"></c:import>


</body>
</html>