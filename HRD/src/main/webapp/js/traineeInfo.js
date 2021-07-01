function modifyTrainee(){
	
	alert("정보 수정하세요")
	
	var info = document.getElementsByClassName("form-control")
	

	
	info[3].removeAttribute("readonly");
	info[4].removeAttribute("readonly");
	info[5].removeAttribute("readonly");
	
	var com  = document.getElementById("complete");
	var modi  = document.getElementById("modify");

	com.removeAttribute("style");
	modi.setAttribute("style","display:none");

}

function resultInfo(){
	alert("정보 수정하셔서 다시 로그인 부탁드려요")
	var frm = document.forms[0];
	frm.submit();
	
}


function modifyManager(){
	var isc= confirm("수정하시겠습니까?");
	if(isc==true){
		return "location.href='./modifyManager.do'";
	}else{
		alert("수정 실패");
		return;
	}
	
}