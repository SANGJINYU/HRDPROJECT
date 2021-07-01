<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div>
<div class="container" style="width: 400px;">
  <h2>상세 정보</h2>
  <form action="./modifyManager.do" method="post">
    <div class="form-group">
      <label for="id">아이디:</label>
      <input type="text" class="form-control" id="id" name="id" value="${m.id}" readonly>
    </div>
    <div class="form-group">
      <label for="name">이름:</label>
      <input type="text" class="form-control" id="name" name="name" value="${m.name}" >
    </div>
    <div class="form-group">
      <label for="email">이메일:</label>
      <input type="text" class="form-control" id="email" name="email" value="${m.email}" >
    </div>
     <div class="form-group">
      <label for="phone">전화번호:</label>
      <input type="text" class="form-control" id="phone" name="phone" value="${m.phone}" >
    </div>
    <div class="form-group">
      <label for="auth" >권한:</label>
<%--       <input type="text" class="form-control" id="auth" name="auth" value="${m.auth}" > --%>
      <select class="form-control" id="auth" name="auth">
      	<option value="${m.auth}">${m.auth}</option>
      	<c:if test="${m.auth == 'Y'}">
      	<option value="N">N</option>
      	</c:if>
      	<c:if test="${m.auth == 'N'}">
      	<option value="Y">Y</option>
		</c:if>
      </select>
    </div>
    <input type="submit" class="btn btn-primary" value="수정">
    <input type="button" class="btn btn-info" value="뒤로가기" onclick="javascript:history.back(-1)">
    
  </form>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>