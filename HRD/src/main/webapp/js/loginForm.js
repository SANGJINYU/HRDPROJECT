

function loginForm(){
	
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	
	var frm = document.forms[0];
	console.log(frm);
	
	if(id.value == "" || pw.value==""){
		alert("로그인 정보를 입력해주세요");
		id.focus();
	}else{
		frm.submit();
	}
}
