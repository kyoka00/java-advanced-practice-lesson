<%@ page import="entity.User"%>
<%@ page import="entity.Utility"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");
String userId = request.getParameter("userId");
String userName = request.getParameter("userName");
String ageS = request.getParameter("age");
String btn = request.getParameter("btn");

String result = "";


%>
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

.result {
	background: #fffacd;
	display: inline-block;
	margin: 5px;
	padding: 10px;
}

a.button {
	background-color: #ddeeff;
	border: 1px solid #ccc;
	padding: 5px;
	cursor: pointer;
}
</style>
</head>
<body>

	<h1>Java応用 - 演習問題1(発展)</h1>
<%
	String msg ="";
	if (btn != null && btn.equals("reset")) {
		session.invalidate();
			
	}else{

	if (Utility.isNullOrEmpty(userId) == false && Utility.isNullOrEmpty(userName) == false
		&& Utility.isNullOrEmpty(ageS) == false) {
			
		int age = Integer.parseInt(ageS);
		String[] userInfo;
		int i = 0;
		
		if (session.getAttribute("userInfo") != null) {
			userInfo = (String[]) session.getAttribute("userInfo");
				
		} else {
			userInfo = new String[5];
		}

			
		if (userInfo[userInfo.length -1] != null) {
			result = "これ以上ユーザーを登録できません。";
			for (i = 0; i < userInfo.length; i++) {
				msg = msg + userInfo[i] +"<br>";
			}
				
		} else if (userInfo[userInfo.length - 1] == null) {

			for (i = 0; i < userInfo.length; i++) {
				
				if (userInfo[i] != null) {
					msg = msg + userInfo[i] +"<br>";

					} else {
						User user = new User(userName, userId, age);
						String res = user.returnUserInfo();
						userInfo[i] = res;
						session.setAttribute("userInfo", userInfo);
						msg = msg + userInfo[i] +"<br>";
						result = "ユーザーを登録しました";
						break;
					}
				}

			}
		}
			
	}
%>

	<h2>登録結果</h2>

	<div class="result">
		<h3>実行結果</h3>
		<p><%=result%></p>
	</div>

	<p>

		<span>現在の登録ユーザー</span><br>
	<%= msg %>
		
	</p>

	<form action="input.jsp">
		<button type="submit" name="btn" value="back">戻る</button>
		<button type="submit" name="btn" value="reset">リセット</button>
	</form>
</body>
</html>