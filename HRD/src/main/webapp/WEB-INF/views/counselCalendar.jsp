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
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상담 일정 예약 게시판</title>
</head>
<body>
<%@ include file="./header.jsp" %>
<%
//request param의 전달
// 	String id = request.getParameter("id");
// 	id = (String)session.getAttribute("id"); //redirect로 보냈으니까
// 	System.out.println("아이디 아직 못함"+id);

	//현재 날짜의 년도와 월을 가져옴
	Calendar cal = Calendar.getInstance();
	int year = cal.get(Calendar.YEAR);
	int month = cal.get(Calendar.MONTH)+1;
	
	////파라미터를 전송받았어 새로운 년도 월이 필요함. 그럼 파라미터가 있는지 없는지 판단해주고 파라미터가 있다면 년월을 바꿔줌
	//전송된 파라미터 값 중에서 param year와 param month가 있다면 판단하여 값을 재입력해준다
	String paramYear = request.getParameter("year");
	String paramMonth = request.getParameter("month");
	
	//요청을 판단하여 재입력
	if(paramYear != null){
		year = Integer.parseInt(paramYear);
	}
	if(paramMonth != null){
		month = Integer.parseInt(paramMonth);
	}
	
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
	
	////앞뒤찍는거...ㅎㅇㅌ
	//이전달력계산을 위한 세팅
	cal.set(year,month-1-1, 1);
	int beforelastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);

	//달력에 필요한 게시글 정보를 가져오는 Dao를 실행
	ICounselDao dao = new CounselDaoImpl();
	//필요한 입력 형태를 만들어 줌
	//id, yyyymm
	
	String yyyymm=year+CalendarUtil.twoWord(month);
	System.out.printf("%s. %s, %s \n", year, month, yyyymm);
	
	//년도 월의 게시글을 가져옴
	////mvc1형태
// 	Map<String, Object> map = new HashMap<String, Object>();
// 	map.put("id", "user04");
// 	map.put("yyyymm", "202107");
// 	List<CounselDto2> cList = dao.counsel_getCalViewList(map);
	
// 	System.out.print(cList);
%>
<div id="container">
<h2> 상담 일정 예약 게시판 </h2>
${trainee.id}
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
						<a href="./counselBook.do?year=<%=year%>&month=<%=month%>&date=<%=i%>"
							class="countView" style="color:<%=CalendarUtil.fontColor(i, dayOfWeek)%>"><%=i %></a>
						
						<!-- 글쓰기 버튼 -->
<%-- 						<a href="./CalController.do?command=insertForm&year=<%=year%>&month=<%=month%>&date=<%=i%>"> --%>
<!-- 							<img alt="글작성" src="./img/pen.png"> -->
<!-- 						</a> -->
						
						
						<!-- 해당 일의 게시글 3개를 출력 -->
						<div class = "clist">
<%-- 							<%request.getAttribute("cList");%> --%>
<%-- 							<%=CalendarUtil.getCalView(i,cList) %> --%>
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


</body>
</html>