<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager Main</title>
<style type="text/css">
	#tb{
		width: 500px;
		margin: 100px auto;
	}
	td{
		width: 100px;
		height: 100px;
		border: 3px solid #808080;
		background-color: #c0c0c0;
		text-align: center;
		cursor: pointer;
		font-weight: bold;
		font-family: sans-serif;
	}
</style>
</head>
<body>
${m_info}
<%@include file="/WEB-INF/views/header.jsp" %>
<div id="container">
<table id="tb">
	<tr>
		<td onclick="location.href='./counselCalendar.do'" >예약현황</td>
		<td onclick="location.href='./mListForm.do'" >계정관리</td>
		<td onclick="location.href='./traineeMain.do'" >메인페이지</td>
	</tr>
</table>
</div>
<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>