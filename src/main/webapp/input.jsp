<%@ page language="java" contentType="text/html; charset=UTF-8"
  pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Java応用_演習問題1(発展)</title>
<style>
body {
    border: solid 2px #000080;
    padding: 5px;
}

.box {
    margin: 5px;
}

.box label {
    display: inline-block;
    width: 90px;
    text-align: right;
}
</style>
<% 
request.setCharacterEncoding("UTF-8");
String idNull = (String) request.getAttribute("idNull");
String passNull = (String) request.getAttribute("passNull");
String unmatch =(String)request.getAttribute("unmatch");
%>
</head>
<body>



  <h2>＜login.jsp＞　ログイン画面</h2>

 
  <form action="LoginServlet" method="post">

    <div class="box">
    <span>${requestScope.unmatch}</span><br>
      <label>ID：</label> <input type="text" name="id"> 
      <span>${requestScope.idNull }</span><br>
      <label>PASS：</label> <input type="text" name="pass">
      <span>${requestScope.passNull}</span><br>
      
    </div>
    <button type="submit">登録</button>
  </form>

</body>
</html>