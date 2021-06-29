/**
 * 
 */

function searchInfo(){

//	$("#resulttable>tbody").html("");
	
	var search = document.getElementById("search").value;
//	var inst = document.getElementById("inst").value;
	

	var url = "http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?returnType=XML"
	+ "&authKey=zTTgDhnacOrKYEU7PyiCIPquwdPOJFDO&"
	+ "pageNum=1&"
	+ "pageSize=100&";
	
	var strdate = document.getElementById("strdate").value;
	var enddate = document.getElementById("enddate").value;
	
	var cstrDate = strdate.replace(/-/g,'');
	var cendDate = enddate.replace(/-/g,'')
	
	console.log(cstrDate);
	console.log(cendDate);
	url += "srchTraStDt="+cstrDate+"&" //모집 시작 시작일
	url += "srchTraEndDt="+cendDate+"&" // 모집 종료 ?
	url += "outType=1&"// 반환 1 리스트 2 상세
	url += "sort=ASC&" // 오름차순 
//	url += "srchTraProcessNm="+keyword+"&"
//	url += "sortCol=srchTraOrganNm&"
	//추후작성
	url += "sortCol=TR_STT_DT&" //훈련일수
	url += "crseTracseSe=C0055&" // 내일배움카드
	url += "srchKeco1=20&"// 정보통신
	url += "srchTraArea1=11&"; //서울
	url += "srchTraProcessNm="+search+"&"
//	url += "srchTraOrganNm="+search+"&" // 기관명
	url += "srchTraGbn=00";
	
//	var srchTraArea1 = document.getElementById("upperAreaCd").value;
//		url += "srchTraArea1="+srchTraArea1;
//	var srchTraArea2 = document.getElementById("areaCd").value;
//	if(srchTraArea2 != 0){
//		url += "&srchTraArea2="+srchTraArea2;
//	}
//	var srchKeco1 =  document.geElementById("upperNcsCd").value;
//	if(srchKeco1 != 0){
//	url += "&srchKeco1="+srchKeco1;
//    }
//	console.log(srchTraArea1+","+srcthTraArea2 +","+ srchKeco1+","+date);

	$("#resulttable").attr('style', "display:inline;");

	$.ajax({
		type: "get",
		url: "./search.do",
		data:{
			"url" : url
		},
		dataType: "json",
		success: function(data){
			$.each(data, function(key, value){
				var html = "";
				if(key == "info"){
					var list = value;
					$.each(list, function(k, v){
						
//					  console.log(list.length);
//			
//					$("#resulttable>tbody").html("<tr></tr>");
					
						
//						for(var i = 0; i < 15; i++){
//						$("#resulttable>tbody>tr").append("<td>+"'resultV'"+</td>");
//					}		
//						$("#resulttable>tbody>tr").children().eq(1).text(v.addr1);
//						$("#resulttable>tbody>tr").children().eq(2).text(v.instIno);
//						$("#resulttable>tbody>tr").children().eq(3).text(v.subTitle);
//						$("#resulttable>tbody>tr").children().eq(4).text(v.trDcnt);
//						$("#resulttable>tbody>tr").children().eq(5).text(v.trprChap);
//						$("#resulttable>tbody>tr").children().eq(6).text(v.trprChapEmail);
//						$("#resulttable>tbody>tr").children().eq(7).text(v.trprChapTel);
//						$("#resulttable>tbody>tr").children().eq(8).text(v.trprId);
//						$("#resulttable>tbody>tr").children().eq(9).text(v.trprDegr);
//						$("#resulttable>tbody>tr").children().eq(10).text(v.trprNm);
//						$("#resulttable>tbody>tr").children().eq(12).text(v.trtm);
//						$("#resulttable>tbody>tr").children().eq(13).text(v.traStartDate);
//						$("#resulttable>tbody>tr").children().eq(14).text(v.traEndDate);
//						$("#resulttable>tbody>tr").children().eq(15).text(v.yardMan);

//					 for(i=0; i < Object.keys(v).length;i++){
//							console.log(Object.keys(v)[i]);	
//					$("#resulttable>tbody>tr").children().eq(i).text(v. Object.keys(v)[i]);
//					
//				}		
//								
							html = "<tr>"
							html += "	<td>"+v.address+"</td>"
							html += "	<td>"+v.addr1+"</td>"
							html += "	<td><a href= '"+v.hpAddr+"'>"+v.hpAddr+"</a></td>" //innerHTML로 
							html += "	<td>"+v.instIno+"</td>"
							html += "	<td>"+v.subTitle+"</td>"
							html += "	<td>"+v.trDcnt+"</td>"
							html += "	<td>"+v.trprChap+"</td>"
							html += "	<td>"+v.trprChapEmail+"</td>"
							html += "	<td>"+v.trprChapTel+"</td>"
							html += "	<td>"+v.trprId+"</td>"
							html += "	<td>"+v.trprDegr+"</td>"						
//						html += " 	<input value='"+v.trprDegr+"' name='v.trprDegr' type='hidden'>"
							html += "	<td>"+v.trprNm+"</td>"
							html += "	<td>"+v.trtm+"</td>"
							html += "	<td>"+v.traStartDate+"</td>"
							html += "	<td>"+v.traEndDate+"</td>"
							html += "	<td>"+v.yardMan+"</td>"
							html += "</tr>"
						$("#resulttable>tbody").append(html);
					});
				}
			});
		},
		error:function(){
			alert("잘못된 요청")
		}
	})
	alert("종료!");
	return false;
}

function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '' + month + '' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}