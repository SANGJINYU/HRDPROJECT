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
			
			if(msg.value=="true"){
				
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


function m_signUp(){
	
	var frm = document.forms[0];
	
	var id = document.getElementById("id");
	var pw = document.getElementById("pw");
	var name = document.getElementById("name");
	var email = document.getElementById("email");
	var phone = document.getElementById("phone");
	var inst_ino = document.getElementById("inst_ino");
	
	
	if(id.value =="" || pw.value =="" || name.value=="" || email.value=="" || phone.value=="" ||inst_ino.value==""){
		alert("필수 정보를 모두 입력해주세요")
		return false;
	} else {
		
		frm.submit();
	}
}

function m_idChk(){
	
	var id = document.getElementById("id");
	
	
	
	$.ajax({
		type:"post",
		url:"./managerIdChk.do",
		data:"id="+id.value,
		success:function(msg){
			console.log(msg)
			
			if(msg.isc=="true"){
				
			alert("중복된 아이디입니다.")	
			$("#id").val("");
			}else{
				
			alert("사용가능한 아이디입니다. 사용하시겠습니까?")
			}
		},
		error:function(){
			
			alert("잘못된 요청입니다.")	
		}
	});
	
}


	
