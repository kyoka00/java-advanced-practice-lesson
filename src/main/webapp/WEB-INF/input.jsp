<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ログイン画面</title>
<%
 String checkS = (String) request.getAttribute("check");
%>
</head>
<body>
<h1>＜login.jsp＞ログイン画面</h1>
<c:if "${check}"= "4">
<p>IDまたはPASSが間違っています。</p>
</c:if>
<form action= "LoginSerclet" method ="post">

<label>ID:</label>
<input type ="text" name="id">
<label>${requestScope.msg_id}</label><br>

<label>PASS:</label>
<input type ="text" name="pass">
<label>${requestScope.msg_pass}</label><br>

<button type="submit">ログイン</button>

</form>
</body>
</html>