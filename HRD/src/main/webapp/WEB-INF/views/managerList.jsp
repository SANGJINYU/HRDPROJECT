<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
 #tb{
 	width: 700px;
 	margin: 200px auto;
 	text-align: center;
 }
 
 th, td{
 	border: 1px solid #808080;
 	text-align: center;
 }

</style>
</head>
<body>
${m_list}
<%@include file="/WEB-INF/views/header.jsp" %>
<div id="container">
<table id="tb">
	<tr>
		<th>연번</th>
		<th>아이디</th>
		<th>이름</th>
		<th>이메일</th>
		<th>전화번호</th>
		<th>권한</th>
		<th>권한변경</th>
	</tr>
	<c:forEach var="d" items="${m_list}" varStatus="vs">
	<tr>
		<td>${vs.count}</td>
		<td>${d.id}</td>
		<td>${d.name}</td>
		<td>${d.email}</td>
		<td>${d.phone}</td>
		<td>${d.auth}</td>
		<td> 
			<c:if test="${d.auth != 'M'}">
			<select>
				<option selected="selected">수정</option>
				<option value="Y">Y</option>
				<option value="N">N</option>
			</select>
			</c:if>
		</td>
	</tr>
	</c:forEach>
</table>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>