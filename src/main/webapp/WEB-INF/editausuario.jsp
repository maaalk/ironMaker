<%@page import="br.com.direfrog.entidade.Usuario"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%Usuario user = (Usuario) request.getAttribute("user"); %>
	<%out.print(user.getId()); %>
	<form action="usuariocontroller.do?" method="post">
		ID: <input type="hidden" name="id" value="<%=user.getId()%>"/><br>
		Nome: <input type="text" name="nome" value="<%=user.getNome()%>"/><br>
		Login: <input type="text" name="login" value="<%=user.getLogin() %>"/><br>
		Senha: <input type="text" name="senha" value="<%=user.getSenha() %>"/><br>
		<input type="submit" value="Salvar"/><br>
		
	</form>
</body>
</html>