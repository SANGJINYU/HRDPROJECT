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
				<td>${cDto2.seq}</td>
			</tr>
			<tr>
				<th>과정명</th>
				<td><input type="text" name="trprNm" value="${cDto2.trpr_nm}" class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>과정차수</th>
				<td><input type="text" name="trprDegr" value="${cDto2.trpr_degr}" class="form-control" readonly> </td>
			<tr>
			<tr>
				<th>기관명</th>
				<td><input type="text" name="trprId" value="${cDto2.trpr_id}" class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>아이디</th>
				<td>${cDto2.id}</td>
			</tr>
			<tr>
				<th>담당자 아이디</th>
				<td>${cDto2.m_id}</td>
			</tr>
			<tr>
				<th>상담일정</th>
				<td>${cDto2.mdate}</td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea class="form-control" rows="10" cols="50" name="content">${cDto2.content}</textarea>
				</td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input class="btn btn-warning" type="button" value="돌아가기" onclick="history.back(-1)">
					<input type="button" class="btn btn-success btn-left" value="수정" onclick="">
					<input type="button" class="btn btn-danger" value="삭제" onclick="">
				</td>
			</tr>
		</tfoot>
	</table>

</div>

<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>