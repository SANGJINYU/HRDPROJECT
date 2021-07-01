<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="./js/signUp.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div>
<div class="container" style="width: 400px;">
  <h2>회원가입</h2>
  <form action="./managerInsert.do" method="post">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id">
      <input style="position: absolute; right: 290px; top: 158px;" type="button" class="btn btn-info" value="중복확인" onclick="m_idChk()">
    </div>
    <div class="form-group">
      <label for="pw">비밀번호:</label>
      <input type="password" class="form-control" id="pw" name="password" onchange=inputPw()>
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
      <input type="hidden" class="form-control" id="inst_ino" name="inst_ino" value="${m_info.inst_ino}">
    <input type="button" class="btn btn-primary" value="회원가입" onclick="m_signUp()">
  </form>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>