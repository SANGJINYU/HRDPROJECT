function signUp(){
	
	var frm = document.forms[0];
	
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	var name = document.getElementById("name");
	var email = document.getElementById("email");
	var phone = document.getElementById("phone");
	var addr = document.getElementById("addr");
	var detailAddr = document.getElementById("detail_addr");
	
	if(id.value =="" || pw.value =="" || name.value==""|| email.value=="" || phone.value=="" || addr.value=="" || detailAddr.value==""){
		alert("필수 정보를 모두 입력해주세요")
		return false;
	} else {
		frm.submit();
	}
}
	
function idChk(){
	
	
	var id = document.getElementById("id");	
	
	$.ajax({
		type:"post",
		url:"./idChk.do",
		data:"id="+id.value,
		success:function(msg){
			console.log(msg)
			
			if(msg=="true"){
				
			alert("중복된 아이디입니다.")	
			id.value="";
	
			}else{
				alert("사용가능")
			}
		},
		error:function(){
			
			alert("잘못된 요청입니다.")	
		}
	});
	
}

function inputPw(){
	var regex = /^(?=.*[a-zA-Z])(?=.*[!@#$%^~*+=-])(?=.*[0-9]).{8,20}$/;
	var val = document.getElementById("pw").value;
	if(!regex.test(val)){
		alert("문자,숫자,특수문자의 조합으로 8자 이상 입력해주세요");
		document.getElementById("pw").value='';
	}else{
		alert("사용가능한 비밀번호입니다.")
	}
}

//$(document).ready(function(){
//	
//	var pw = $("#pw").val;
//	console.log(pw);
//	$("#pw").eventaddEventListener("change",function(event){
//			var regex = /^(?=.*[A-Za-z0-9])(?=.*[.!@#$%^&*])(?=.[0-9A-Za-z]).{8,20}$/
//			if(!regex.test(pw)){
//				$(".result").html("비밀번호는 숫자,영어, 특수문자를 조합하여 8자리 이상 입력해주세요")
//			}
//	});
//	
//});
	

	
