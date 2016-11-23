<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ficha de Personagem</title>
</head>
<body>
<%@include file="menu.jsp" %>
<form action="charsheet.do?action=salvar" method="post">
<br/>
	Nome: <input type="text" name="nome" value=""/>
	<table class="tg">
  <tr>
    <th class="tg-9hbo">Primary Stats</th>
    <th class="tg-9hbo">Secondary Stats</th>
  </tr>
  <tr>
    <td class="tg-yw4l" rowspan="2">FIS <input type="number" name="phy" value=""/></td>
    <td class="tg-yw4l">FOR <input type="number" name="str" value=""/></td>
  </tr>
  <tr>
    <td class="tg-yw4l">VEL <input type="number" name="spd" value=""/></td>
  </tr>
  <tr>
    <td class="tg-yw4l" rowspan="2">AGI <input type="number" name="agi" value=""/></td>
    <td class="tg-yw4l">MAE <input type="number" name="prw" value=""/></td>
  </tr>
  <tr>
    <td class="tg-yw4l">DES <input type="number" name="poi" value=""/></td>
  </tr>
  <tr>
    <td class="tg-yw4l" rowspan="2">INT <input type="number" name="intel" value=""/></td>
    <td class="tg-yw4l">ARC <input type="number" name="arc" value=""/></td>
  </tr>
  <tr>
    <td class="tg-yw4l">PER <input type="number" name="per" value=""/></td>
  </tr>
</table>
<br/>
<input type="submit" value="Salvar" />
</form>

</body>
</html>