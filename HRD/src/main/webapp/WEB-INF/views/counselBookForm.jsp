<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담 예약 글 작성 페이지</title>
</head>
<%
	int lastDay = (Integer)request.getAttribute("lastDay");
	int hour = (Integer)request.getAttribute("hour"); 
	int minute = (Integer)request.getAttribute("minute");
	
	int year = Integer.parseInt(request.getParameter("year").trim());
	int month = Integer.parseInt(request.getParameter("month"));
	int date = Integer.parseInt(request.getParameter("date"));
%>
<body>
<%@ include file="./header.jsp" %>

<div id="container">
	<div style="width:800px; margin: 20px auto;">
		<form action="./counselBookForm.do" method="post">
			<table class="table">
				<tbody>
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
						<td>${t_info.id}</td>
					</tr>
					<tr>
						<th>일정</th>
						<td>
							<select name="year">
							<%
								for(int i=(year-2); i<(year+3); i++){
									%>
										<option value="<%=i%>" <%=(i==year)?"selected":""%>><%=i%></option>
									<%
								}
							%>
							</select>년도
							<select name="month">
							<%
								for(int i=1; i<=12; i++){
									%>
										<option value="<%=i%>" <%=(i==month)?"selected":""%>><%=i%></option>
									<%
								}
							%>
							</select>월
							<select name="date">
							<%
								for(int i=1; i<=lastDay; i++){
									%>
										<option value="<%=i%>" <%=(i==date)?"selected":""%>><%=i%></option>
									<%
								}
							%>
							</select>일
							<select name="degr">
								<option value="1" selected>1</option>
								<option value="2">2</option>
							</select>회차
						</td>
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
							<input type="submit"  class="btn btn-success"  value="상담 예약하기">
						</td>
					</tr>
				</tfoot>
			</table>
		</form>
	</div>
</div>
</body>
</html>