<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<link rel="stylesheet" type="text/css" href="./css/main.css">
<script type="text/javascript" src="./js/search.js"></script>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div id="container'">
	<form action="./search.do" method="get">
	<div class='form-group'>
			<div class="rdo">
				<input type="radio"  name="rdoBtn"  checked="checked">과정명 검색 
				<input type="radio" name="rdoBtn">기관명 검색
			</div>
			<div class="date">
				시작일 : <input type="date" id="strdate">
				종료일 : <input type="date" id="enddate">
			</div>
		<div class="search">
				<input class = "form-control"  type="text" name="search" id	="search">	
				<input class = "btn btn-primary" type ="button" onclick = "searchInfo()" value ="검색">
				<input class = "btn btn-info" type = "reset"  value ="초기화"> 
		</div>
	</div>
	</form>
	<div id="info">
	<table id="resulttable"	style="display: none">
	<thead>
	</thead>
	<tbody>
	</tbody>
	</table>
</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>