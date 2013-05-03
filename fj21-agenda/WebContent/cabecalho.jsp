
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
  <script src="http://code.jquery.com/jquery-1.8.3.js"></script>
  <script src="http://code.jquery.com/ui/1.9.2/jquery-ui.js"></script>
  <link href="<c:url value='/resources/menu_assets/styles.css'/>" rel="stylesheet" type="text/css">
</head>
<img src="<c:url value='/resources/imagens/logoartuzzi.jpg'/>"/>
<h2>Agenda de Contatos do Denis</h2>
<div id='cssmenu'>
<ul>
   <li class='active '><a href="<c:url value='/contato/home'/>"><span>Home</span></a></li>
   <li><a href="<c:url value='/contato/adiciona'/>"><span>Adicionar</span></a></li>
   <li><a href="<c:url value='/contato/lista'/>"><span>Listar</span></a></li>
</ul>
</div>
<hr/>
