<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://displaytag.sf.net" prefix="display" %>
<%@ page import="java.util.*, br.com.caelum.agenda.dao.*, br.com.caelum.agenda.modelo.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<link type="text/css" href="<c:url value='/resources/css/tabela.css'/>" rel="stylesheet"/>
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
		<th align="center">Excluir</th>
		<th align="center">Editar</th>
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
	  <td align="center"> <a href="<c:url value='/contato/exclui?id=${contato.id}'/>">Excluir</a> </td>
	  <td align="center" ><a href="<c:url value='/contato/altera?id=${contato.id}'/>">Editar</a></td>
   </tr>
   
</c:forEach>
</table>
<br>
<% ContatoDao dao1 = new ContatoDao();
   List<Contato> contatos = dao1.getLista();
   request.setAttribute("dados", contatos ); %>

<display:table id="lstContatos" name="dados" >
 <display:caption>Contatos</display:caption>
  <display:column property="nome"  title="Nome" sortable="true" />
  <display:column property="email" title="Email" sortable="true"/>
  <display:column property="endereco" title="Endereço"/>
  <display:column property="dataNascimento.time" title="Dt.Nascimento" format="{0,date,dd/MM/yyyy}" />
</display:table>


<c:import url="rodape.jsp"></c:import>


</body>
</html>