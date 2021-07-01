<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세 정보 조회</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div>
<div class="container" style="width: 400px;">
${dto}
  <h2>상세 정보</h2>
  <form action="./modifyInfo.do" method="post">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id" value="${t_info.id}" readonly>
    </div>
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name" value="${t_info.name}" readonly>
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" name="email" value="${t_info.email}" readonly>
    </div>
     <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" name="phone" value="${t_info.phone}" readonly>
    </div>
    <div class="form-group">
      <label for="addr" >주소:</label>
      <input type="text" class="form-control" id="addr" name="addr" value="${t_info.addr}" readonly>
    </div>
    <div class="form-group">
      <label for="detailAddr" >상세주소:</label>
      <input type="text" class="form-control" id="detail_addr" name="detail_addr" value="${t_info.detail_addr}" readonly>
    </div>
    <input type="button" class="btn btn-primary" id="modify"value="정보 수정" onclick="modifyTrainee()">
    <input type="button" class="btn btn-danger" id="complete" value="수정 완료" onclick="resultInfo()" style="display: none">
    <input type="button" class="btn btn-info" value="뒤로가기" onclick="javascript:history.back(-1)">
    
  </form>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>