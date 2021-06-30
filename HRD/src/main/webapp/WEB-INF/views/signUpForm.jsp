<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<script type="text/javascript" src="./js/signUp.js"></script>
<style type="text/css">
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div>
<div class="container" style="width: 400px;">
  <h2>회원가입</h2>
  <form action="./signUpForm.do" method="post">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id">
      <input type="button" class="btn btn-info" value="중복확인" onclick="idChk()">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="password" class="form-control" id="pw" name="pw" onchange=inputPw()>
    </div>
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name">
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" name="email">
    </div>
     <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" name="phone">
    </div>
    <div class="form-group">
      <label for="addr" >주소:</label>
      <input type="text" class="form-control" id="addr" name="addr">
    </div>
    <div class="form-group">
      <label for="detailAddr" >상세주소:</label>
      <input type="text" class="form-control" id="detail_addr" name="detail_addr">
    </div>
    <input type="button" class="btn btn-primary" value="회원가입" onclick="signUp()">
  </form>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>