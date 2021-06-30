<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css"  href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.js"></script>

</head>
<header>
<div id= "container">
	<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="./main.do">HRD</a>
    </div>
    <ul class="nav navbar-nav">
      <li ><a href="./main.do">Home</a></li>
      <li ><a  href="#">과정 </a></li>
      <li><a href="#">게시판</a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <c:if test="${trainee == null}">
      <li><a href="./signUp.do">
      <span class="glyphicon glyphicon-user"></span> 회원가입</a></li>
      <li><a href="./loginForm.do"><span class="glyphicon glyphicon-log-in"></span>로그인</a></li>      
      </c:if>
      <c:if test="${trainee != null}">
      <ul class="nav navbar-nav navbar-left">
      <li><a><span>${trainee.name}님 환영합니다</span></a></li>
      <li><a href="./logout.do"><span class="glyphicon glyphicon-log-out"></span>로그아웃</a></li>
      </ul>
      </c:if>
    </ul>
  </div>
</nav>
</div>



</header>
</html>