<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<%@include file="header.jsp" %>
<body>
<div id="container">
	<div id="title">Total Spring</div>
	<form method="post">
		<input type="radio" class="selBtn" name="btn" value="trainee">회원
		<input type="radio" class="selBtn" name="btn" value="manager">관리자
		<div class="inputWord">아이디</div>
			<input type="text" name="id" id="inputId" placeholder="아이디입력"><br>
		
		<div class="inputWord">비밀번호</div>
			<input type="password" name="pw" id="inputPw" placeholder="비밀번호 입력" onkeyup="enterKey()"><br>
			
		<div style="text-align: center;">
			<input type="button" id="login" name="login" value="LOGIN" onclick="loginCheck()">
		</div>
		<div id="bottom">
			<input type="button" id="signup" value="회원가입">
			<input type="button" value="아이디 찾기">
			<input type="button" value="비밀번호 찾기">
		</div>
	</form>
</div>
</body>
</html>