/**
 * 
 */
window.onload = function(){

	
	var rdo = document.getElementsByName("rdoBtn");

	
	if(rdo[1].checked){
		rdo[0].checked= false;
		rdo[1].checked = true;
	}
}


function searchInfo(){

	$("#resulttable>tbody").html("");
	$("#resulttable").attr('style', "display:inline;");
	var search = document.getElementById("search").value;
//	var inst = document.getElementById("inst").value;
	

	var url = "http://www.hrd.go.kr/jsp/HRDP/HRDPO00/HRDPOA60/HRDPOA60_1.jsp?returnType=XML&authKey=zTTgDhnacOrKYEU7PyiCIPquwdPOJFDO&pageNum=1&pageSize=100&";
	
	var strdate = document.getElementById("strdate").value;
	var enddate = document.getElementById("enddate").value;
	
	var tDate = new Date();
	
 	var today = getFormatDate(tDate);
	console.log(today);
	document.getElementById("strdate").valueAsDate = new Date();

	console.log(strdate);
	console.log(enddate);
	console.log(today);

	
	strdate.value = today;
	
	var cstrDate = strdate.replace(/-/g,'')
	var cendDate = enddate.replace(/-/g,'')
	
	var trpr = document.getElementsByName("rdoBtn")[0];
	var inst = document.getElementsByName("rdoBtn")[1];

	
	url += "srchTraStDt="+cstrDate+"&" //모집 시작 시작일
	url += "srchTraEndDt="+cendDate+"&" // 모집 종료 ?
	url += "outType=1&"// 반환 1 리스트 2 상세
	url += "sort=DESC&" // 오름차순 
//	url += "srchTraProcessNm="+keyword+"&"
//	url += "sortCol=srchTraOrganNm&"
	//추후작성
	url += "sortCol=TR_STT_DT&" //훈련일수
	url += "crseTracseSe=C0055&" // 내일배움카드
	url += "srchKeco1=20&"// 정보통신
	url += "srchTraArea1=11&"; //서울
	if(inst.checked){
	url += "srchTraOrganNm="+search+"&" // 기관명
	}else{
	url += "srchTraProcessNm="+search+"&"
	}
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




	$.ajax({
		type: "get",
		url: "./search.do",
		data:{
			"url" : url
		},
		dataType: "json",
		success: function(data){
			$("#container").append("<h1 style='text-align: center;'>검색 결과</h1>")
			htmlh = "<tr>"
			htmlh += "<th>번호</th>"
			htmlh += "	<th>주소</th>"
			htmlh +=  "	<th>기관명</th>"
			htmlh +=  "	<th>훈련일수</th>"
			htmlh +=  "	<th>과정회차</th>"
			htmlh +=  "	<th>과정명</th>"
			htmlh += "</tr>"
			$("#resulttable>thead").append(htmlh);
			$.each(data, function(key, value){
				html ="";
				if(key == "info"){
					var list = value;
					$.each(list, function(k, v){
						console.log(k);
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

//append
//tbody 만들어서 tr 만들고 append  tbody에 붙이고 전체를 table에 붙여 넣음


							$("#resulttable").attr('style', "display:inline;");
							html = "	<tr>"
							html += "	<td>"+k+"</td>"
							html += "	<td>"+v.address+"</td>"
							html += "	<td>"+v.subTitle+"</td>"
							html += "	<td>"+v.trDcnt+"</td>"
							html += "	<td>"+v.trprDegr+"</td>"						
							html += "	<td>"+v.trprNm+"</td>"
							html += "	<td><input class = 'btn btn-warning' type ='button'  value ='관심담기' onclick='myInterest()'></td>"
							html += "</tr>"
						$("#resulttable>tbody").append(html);
						$(".form-group").attr('style','display:none');
						
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


function myInterest(){
	
	alert("관심 과정 등록")
//	location.href="./outcome.do?trpr_id="+v.trprId+"&trpr_degr="+v.trprDegr+"&json="+url;
	
}


function getFormatDate(date){
    var year = date.getFullYear();              //yyyy
    var month = (1 + date.getMonth());          //M
    month = month >= 10 ? month : '0' + month;  //month 두자리로 저장
    var day = date.getDate();                   //d
    day = day >= 10 ? day : '0' + day;          //day 두자리로 저장
    return  year + '' + month + '' + day;       //'-' 추가하여 yyyy-mm-dd 형태 생성 가능
}