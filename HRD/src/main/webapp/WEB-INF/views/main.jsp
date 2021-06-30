<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인</title>
<script type="text/javascript" src="./js/search.js"></script>
<style type="text/css">

.search,.rdo,.date{

width: 400px;	
 margin: 0px auto;

}

.btn{

	margin: 0 auto;
	
}

table{

margin: 0px auto;

}

a{

	text-decoration: none;

}

#info{

width: 800px;

}
</style>
</head>
<body>
<%@include file="/WEB-INF/views/header.jsp" %>
<div id="container'">
	<form action="./search.do" method="get">
	<div class='form-group'>
			<div class="rdo">
				<input type="radio" name="rdoBtn"  checked="checked">과정명 검색 
				<input type="radio" name="rdoBtn">기관명 검색
			</div>
			<div class="date">
			 시작일 <input type="date"  id="strdate" >			
			 종료일 <input type="date" id="enddate">				
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
		<tr>
			<th>주소</th><th>기관명</th>
			<th>훈련일수</th> 
			<th>당당자 </th><th>담당자 이메일</th>
			<th>담당자 전화번호</th><th>과정회차</th>
			<th>과정명</th>
		</tr>
	</thead>
		<tbody>
		</tbody>
	</table>
	</div>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>