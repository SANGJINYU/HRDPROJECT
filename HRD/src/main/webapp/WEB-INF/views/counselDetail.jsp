<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상세페이지</title>
</head>
<body>
<%@ include file="./header.jsp" %>

<div id="container">
<form action="./counselBookForm.do" method="post">
	<table class="table">
		<tbody>
<!-- 			SEQ, M_ID, ID, CONTENT, DEGR, TRPR_ID, TRPR_DEGR, TRPR_NM, REGDATE, FLAG, MDATE -->
		<!-- 화면에서 받아올거임 session -->
			<tr>
				<th>글번호</th>
				<td>${cDto2.seq}</td>
			</tr>
			<tr>
				<th>기관아이디</th>
<%-- 				<td> ${TRPR_ID} </td> --%>
				<td><input type="text" name="trprId" value="" class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>과정명</th>
<%-- 				<td>${TRPR_NM}</td> --%>
				<td><input type="text" name="trprNm"  class="form-control" readonly> </td>
			</tr>
			<tr>
				<th>과정차수</th>
<%-- 				<td>${TRPR_DEGR}</td> --%>
				<td><input type="text" name="trprDegr" value="" class="form-control" readonly> </td>
			<tr>
				<th>아이디</th>
				<td>${cDto2.id}</td><!-- sessionscope. 하고 하면ㅅ이름 안꼬임 -->
			</tr>
			<tr>
				<th>일정</th>
				<td></td>
			</tr>
			<tr>
				<th>내용</th>
				<td>
					<textarea class="form-control" rows="10" cols="50" name="content"></textarea>
				</td>
			</tr>
			
		</tbody>
		<tfoot>
			<tr>
				<td colspan="2">
					<input class="btn btn-warning" type="button" value="돌아가기" onclick="history.back(-1)">
					<input type="button" class="btn btn-success" value="수정">
					<input type="button" class="btn btn-danger" value="삭제">
				</td>
			</tr>
		</tfoot>
	</table>
</form>

</div>
</body>
</html>