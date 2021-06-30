window.onload = function(){
	
	var rdo  = document.getElementsByName("rdoBtn");

	if(rdo[1].checked){
		rdo[0].checked= false; // 사용자
		rdo[1].checked = true; // 관리자
	}
}



function loginForm(){
	
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	
	var rdo  = document.getElementsByName("rdoBtn");
	
	var frm = document.forms[0];
	console.log(frm);
	
	
	if(id.value == "" || pw.value==""){
		alert("로그인 정보를 입력해주세요");
		id.focus();
	}else if(rdo[0].checked){ //사용자 체크
		frm.action= "./memberLogin.do";
		frm.method="post";
		frm.submit();
	}else if(rdo[1].checked){// 담당자 체크
		frm.action="./managerLogin.do";
		frm.method="post";
		frm.submit();
	}
}
