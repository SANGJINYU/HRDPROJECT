<%@page import="com.hrd.edu.dto.ManagerDto"%>
<%@page import="com.hrd.edu.model.service.CounselServiceImpl"%>
<%@page import="com.hrd.edu.model.service.ICounselService"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.hrd.edu.dto.CounselDto2"%>
<%@page import="java.util.List"%>
<%@page import="com.hrd.edu.comm.CalendarUtil"%>
<%@page import="java.util.Calendar"%>
<%@page import="com.hrd.edu.model.dao.CounselDaoImpl"%>
<%@page import="com.hrd.edu.model.dao.ICounselDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담 일정 예약 게시판</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<%
	//현재 날짜의 년도와 월을 가져옴
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	//화면에 출력되는 값을 음수처리를 해줘야함 ex) 2021.-1
	//값을 연산하지 않고 Calendar객체를 세팅하고 getYear와 getMonth를 해줘도 됨
	if(month > 12){
		month=1;
		year++;
	}
	if(month < 1){
		month = 12;
		year--;
	}
	
	//요청받은 년도 월로 Calendar 객체를 세팅
	cal.set(year,month-1, 1);
	
	//요청 년도 월의 1일의 요일
	int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
	//요청 년도 월의 최대 일수
	int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	//이전달력계산을 위한 세팅
	cal.set(year,month-1-1, 1);
	int beforelastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
	
	List<CounselDto2> cList = (List<CounselDto2>)session.getAttribute("cList");
	ManagerDto minfo=(ManagerDto)session.getAttribute("m_info");

%>
<div id="container">
<h2 style="text-align: center;"> 상담 일정 예약 게시판 </h2>
${t_info}<br>
${m_info}<br>
${cList}<br>
${m_info.auth}
	<table id="calendar">
		<caption style="text-align: center;font-size:17pt;">
				<a href="./counselCalendar.do?year=<%=year-1%>&month=<%=month%>">◁</a>
				<a href="./counselCalendar.do?year=<%=year%>&month=<%=month-1%>">◀</a>
					<span class="y"><%=year%></span>년도 &nbsp;
					<span class="m"><%=month%></span>월
				<a href="./counselCalendar.do?year=<%=year%>&month=<%=month+1%>">▶</a>
				<a href="./counselCalendar.do?year=<%=year+1%>&month=<%=month%>">▷</a>
		</caption>
		<thead>
			<tr>
				<th>일</th>
				<th>월</th>
				<th>화</th>
				<th>수</th>
				<th>목</th>
				<th>금</th>
				<th>토</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<% //공백
					for(int i=beforelastDay-dayOfWeek+1; i<beforelastDay;i++){
						out.print("<td style='color:#ccc'>"+(i+1)+"</td>");
					}
				
				//달력 출력
				for(int i=1;i<=lastDay;i++){
					%>
						<td>
							<!-- 사용자 -->
							<c:if test="${m_info == null}">
								<c:if test="${t_info.delflag eq 'N'}">
									<a href="./counselBook.do?year=<%=year%>&month=<%=month%>&date=<%=i%>"
										class="countView" style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>"><%=i %></a>
								</c:if>
							</c:if>
							
							<!-- 담당자 -->
							<c:if test="${t_info == null}">
								<c:if test="${m_info.auth != 'N'}">
									<a href="./manager_CounselLists.do?year=<%=year%>&month=<%=month%>&date=<%=i%>"
										class="countView" style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>"><%=i %></a>
								</c:if>
							</c:if>
						
<%-- 						<a href="./counselCalendar.do?year=<%=year%>&month=<%=month%>&date=<%=i%>" --%>
<%-- 							class="countView" style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>"><%=i %></a> --%>
						<!-- 글쓰기 버튼 -->
<%-- 						<a href="./CalController.do?command=insertForm&year=<%=year%>&month=<%=month%>&date=<%=i%>"> --%>
<!-- 							<img alt="글작성" src="./img/pen.png"> -->
<!-- 						</a> -->
						
						
						<!-- 해당 일의 게시글 3개를 출력 -->
						<div class = "clist">
							
							<!-- 사용자 -->
							<c:if test="${m_info == null}">
							<c:forEach var="cList" items="${cList}">
								<c:if test="${t_info.id eq cList.id}">
									<%=CalendarUtil.getCalViewTrainee(i,cList)  %>
								</c:if>
							</c:forEach>
							</c:if>
							
							<!-- 담당자 -->
							<c:if test="${t_info == null}">
							<c:forEach var="cList" items="${cList}">
								<c:if test="${m_info.id == cList.m_id}">
									<%=CalendarUtil.getCalViewManager(i,cList)%>
								</c:if>
							</c:forEach>
							</c:if>
							
<%-- 							${cList} --%>
							
						</div>
						</td>
						
						
						
					<%
					if((dayOfWeek-1+i)%7==0){
						out.print("</tr><tr>");
					}
				}
				
				for(int i=0;i<(7-(dayOfWeek-1+lastDay)%7)%7; i++){
					out.print("<td style='color:#ccc'>"+(i+1)+"</td>");
				}
				
				%>
			</tr>
		</tbody>
	</table>

</div>

<%@include file="/WEB-INF/views/footer.jsp" %>
</body>
</html>