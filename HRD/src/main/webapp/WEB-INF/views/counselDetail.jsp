<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
<style type="text/css">
 #container{
 	width:1000px;
 }
</style>
</head>
<body>
<%@ include file="./header.jsp" %>

<div id="container">
	<table class="table">
		<tbody>
			<tr>
				<th>글번호</th>
				<td>${mdto.seq}</td>
			</tr>
			<tr>
				<th>기관아이디</th>
<%-- 				<td> ${TRPR_ID} </td> --%>
				<td><input type="text" name="trprId" value="${mdto.trpr_id}" class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>과정명</th>
<%-- 				<td>${TRPR_NM}</td> --%>
				<td><input type="text" name="trprNm" value="${mdto.trpr_nm}" class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>과정차수</th>
<%-- 				<td>${TRPR_DEGR}</td> --%>
				<td><input type="text" name="trprDegr" value="${mdto.trpr_degr}" class="form-control" readonly> </td>
			<tr>
				<th>아이디</th>
				<td>${mdto.id}</td>
			</tr>
			<tr>
				<th>일정</th>
				<td>${mdto.mdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea class="form-control" rows="10" cols="50" name="content">${mdto.content}</textarea>
				</td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input class="btn btn-warning" type="button" value="돌아가기" onclick="history.back(-1)">
					<input type="button" class="btn btn-success btn-left" value="수정">
					<input type="button" class="btn btn-danger" value="삭제">
				</td>
			</tr>
		</tfoot>
	</table>

</div>

<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>