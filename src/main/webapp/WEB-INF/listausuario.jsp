<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="br.com.direfrog.entidade.Usuario"%>
<%@page import="java.util.List"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Lista de Usuários</title>
<script type="text/javascript">
	function confirmaExclusao(id){
		if(confirm('Tem certeza que deseja excluir?')){
			location.href="usuariocontroller.do?action=excluir&id="+id;
		}
	}
</script>

</head>
<body>
<%@include file="menu.jsp" %>
<%	List<Usuario> lista = (List<Usuario>)request.getAttribute("listaUsuario");%>

<table border=1>
<tr> 
	<th>ID</th>
	<th>Nome</th>
	<th>Login</th>
	<th>Ação</th>
</tr>

	<%for (Usuario u:lista){ %>	

	<tr>
		<td><% out.print( u.getId() ); %></td>
		<td><%= u.getNome() %></td>
		<td><%= u.getLogin() %></td>
		<td>
			<a href="javascript:confirmaExclusao(<%= u.getId()%>)">Excluir</a>
			<a href="usuariocontroller.do?action=editar&id=<%= u.getId()%>">Editar</a>
		</td>
	</tr>
	<%} %>
	
	
</table>
<a href="usuariocontroller.do?action=novo">Novo Usuario</a>
</body>
</html>