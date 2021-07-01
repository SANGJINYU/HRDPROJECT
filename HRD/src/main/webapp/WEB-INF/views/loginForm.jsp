<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
<script type="text/javascript" src="./js/loginForm.js"></script>
<style type="text/css">


.form-group{
	
	width: 400px;
}

.loginForm{

margin-left: 300px;
margin-top: 50px;
height: 300px;
}


</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div class="container">
  <div class="loginForm">
    <h2>로그인</h2>
  <form>
	    <input type="radio" name="rdoBtn" checked="checked">회원
	 	<input type="radio" name="rdoBtn">기관 담당자
    <div class="form-group">
      <label for="email">아이디:</label>
      <input type="text" class="form-control" id="id" placeholder="아이디를 입력하세요" name="id">
    </div>
    <div class="form-group">
      <label for="pwd">비밀번호:</label>
      <input type="password" class="form-control" id="pw" name="pw" placeholder="비밀번호를 입력하세요" >
    </div>
    <input class="btn btn-primary" type="button" name="login" value="로그인" onclick="loginForm()">
    <input class="btn btn-info" type="button" name="signUp" value="회원가입" onclick="location.href='./signUp.do'">
    <input class="btn btn-warning"  type="button" value="아이디 찾기">
	<input class="btn btn-danger" type="button" value="비밀번호 찾기">
	<a href="./managerSignUpForm.do">담당자 회원가입</a>
  </form>
  </div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>