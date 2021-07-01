<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>담당자) 상담 예약 글 목록</title>
</head>
<body>
<table class="table table-bordered">
		<thead>
			<tr><!--세션에 있는 걸받아서/ 뿌려지는개수/ 뿌려진걸가지고세서 -->
			<c:if test="${mem.auth eq 'A'}">
				<th>
					<input type="checkbox" onclick="checkAll(this.checked)">
				</th>
			</c:if>
				<th>글번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>조회수</th>
			<c:if test="${mem.auth eq 'A'}">
				<th>삭제여부</th>
			</c:if>
				<th>작성일</th>
			</tr>
		</thead>
		<tbody>
			<jsp:setProperty property="lists" name="format" value="${lists}"/>
			<jsp:setProperty property="mem" name="format" value="${mem}"/>
			<jsp:getProperty property="listForm" name="format"/>
		</tbody>
	</table>
</body>
</html>